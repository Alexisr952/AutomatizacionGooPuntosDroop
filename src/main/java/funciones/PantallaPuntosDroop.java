package funciones;

import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isClickable;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;

import java.io.IOException;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.actions.Hit;
import net.serenitybdd.screenplay.targets.Target;
import net.serenitybdd.screenplay.waits.WaitUntil;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import net.serenitybdd.screenplay.Actor;
import static net.serenitybdd.screenplay.Tasks.instrumented;

import net.serenitybdd.screenplay.actions.EnterValue;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.text.PDFTextStripper;

import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.actors.OnlineCast;
import java.util.concurrent.TimeUnit;
import static drivers.AppiumDriver.driver;

/**
 * Clase base vacía para la pantalla de Puntos Droop.
 */
public final class PantallaPuntosDroop {

    private PantallaPuntosDroop() {
    }

    private static final Target CAMPO_LECTURA = Target.the("Campo para insertar unidades").located(By.id("com.coordinadora.timgoo.qa.PuntosDroopModule:id/unit"));


     public static Performable ingresarCampoTexto() {
        return Task.where("Ingresar al campo de texto",
                WaitUntil.the(CAMPO_LECTURA, isVisible()),
                WaitUntil.the(CAMPO_LECTURA, isClickable()),
                Click.on(CAMPO_LECTURA));
    }

    /**
     * Lee un PDF y extrae las guías con sus unidades, construyendo la etiqueta 1D.
     * Coincide con el patrón: GUIA: <numero.con.decimal> ... UNIDAD <n/total>
     * Ej.: GUIA: 123456789.1  UNIDAD 2/5  -> etiqueta1d: 77 + 123456789 + 002
     *
     * @param pdfPath ruta al archivo PDF
     * @return lista de GuiaInfo con codigoRemision y etiqueta1d
     * @throws IOException si falla la lectura del PDF
     */
    public static List<GuiaInfo> extraerGuiasDesdePdf(Path pdfPath) throws IOException {
        String texto = extraerTextoPdf(pdfPath);
        System.out.println("📄 Contenido del PDF (primeros 1000 caracteres):");
        System.out.println(texto.substring(0, Math.min(1000, texto.length())));
        System.out.println("📄 Total de caracteres en el PDF: " + texto.length());
        
        // Patrones más flexibles para diferentes formatos
        Pattern[] patrones = {
            Pattern.compile("GUIA:\\s*(\\d+\\.\\d+).*?UNIDAD\\s([\\d/]+)", Pattern.DOTALL),
            Pattern.compile("GUIA\\s*:\\s*(\\d+\\.\\d+).*?UNIDAD\\s*([\\d/]+)", Pattern.DOTALL),
            Pattern.compile("GUIA\\s*(\\d+\\.\\d+).*?UNIDAD\\s*([\\d/]+)", Pattern.DOTALL),
            Pattern.compile("(\\d+\\.\\d+).*?UNIDAD\\s*([\\d/]+)", Pattern.DOTALL),
            Pattern.compile("GUIA.*?(\\d+\\.\\d+).*?UNIDAD.*?([\\d/]+)", Pattern.DOTALL)
        };

        List<GuiaInfo> resultado = new ArrayList<>();
        
        for (int i = 0; i < patrones.length; i++) {
            Pattern patron = patrones[i];
            Matcher matcher = patron.matcher(texto);
            System.out.println("🔍 Probando patrón " + (i+1) + ": " + patron.pattern());
            
            int coincidencias = 0;
            while (matcher.find()) {
                coincidencias++;
                String guia = matcher.group(1); // p.e. 123456789.1
                String unidad = matcher.group(2); // p.e. 2/5

                String codigoRemision = guia.split("\\.")[0];
                String[] partesUnidad = unidad.split("/");
                String unidadNum = partesUnidad[0];
                String etiqueta1d = "7" + codigoRemision + String.format("%03d", Integer.parseInt(unidadNum));

                resultado.add(new GuiaInfo(codigoRemision, etiqueta1d));
                System.out.println("✅ Encontrada guía: " + guia + " -> " + etiqueta1d);
            }
            System.out.println("📊 Coincidencias con patrón " + (i+1) + ": " + coincidencias);
            
            if (coincidencias > 0) {
                System.out.println("🎯 Usando patrón " + (i+1) + " con " + coincidencias + " coincidencias");
                break;
            }
        }
        
        System.out.println("📋 Total de guías extraídas: " + resultado.size());
        return resultado;
    }

    private static String extraerTextoPdf(Path pdfPath) throws IOException {
        try (PDDocument doc = PDDocument.load(pdfPath.toFile())) {
            PDFTextStripper stripper = new PDFTextStripper();
            return stripper.getText(doc);
        }
    }

    public static final class GuiaInfo {
        private final String codigoRemision;
        private final String etiqueta1d;

        public GuiaInfo(String codigoRemision, String etiqueta1d) {
            this.codigoRemision = codigoRemision;
            this.etiqueta1d = etiqueta1d;
        }

        public String getCodigoRemision() {
            return codigoRemision;
        }

        public String getEtiqueta1d() {
            return etiqueta1d;
        }
    }

    
    public static Performable ingresarGuias(List<GuiaInfo> guias) {
        return instrumented(IngresarGuiasTask.class, guias);
    }

    public static class IngresarGuiasTask implements Task {
        private final List<GuiaInfo> guias;

        public IngresarGuiasTask(List<GuiaInfo> guias) {
            this.guias = guias;
        }

        @Override
        public <T extends Actor> void performAs(T actor) {
            System.out.println("🔍 Iniciando ingreso de " + guias.size() + " guías");
            
            actor.attemptsTo(
                    WaitUntil.the(CAMPO_LECTURA, isVisible()),
                    WaitUntil.the(CAMPO_LECTURA, isClickable())
            );
            
            for (GuiaInfo g : guias) {
                System.out.println("📝 Ingresando guía: " + g.getEtiqueta1d());
                actor.attemptsTo(
                        Click.on(CAMPO_LECTURA),
                        Enter.keyValues(g.getEtiqueta1d()).into(CAMPO_LECTURA)
                );
                
                // Presionar Enter usando el teclado virtual
                try {
                    driver.pressKey(new io.appium.java_client.android.nativekey.KeyEvent(io.appium.java_client.android.nativekey.AndroidKey.ENTER));
                    System.out.println("⌨️ Presionado Enter del teclado virtual");
                } catch (Exception e) {
                    System.out.println("⚠️ Error al presionar Enter: " + e.getMessage());
                    // Fallback: intentar con Hit.the
                    actor.attemptsTo(Hit.the(Keys.ENTER).into(CAMPO_LECTURA));
                }
                
                PantallaPuntosDroop.waitTime(1000);
            }
            System.out.println("✅ Finalizado ingreso de guías");
        }
    }

    public static void waitTime(long time) {
        try {
            TimeUnit.MILLISECONDS.sleep(time);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            e.printStackTrace();
        }
    }

    

}


