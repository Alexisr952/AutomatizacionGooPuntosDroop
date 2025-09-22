package funciones;

import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isClickable;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;

import java.util.List;
import utils.GuiaInfo;

import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.actions.Hit;
import net.serenitybdd.screenplay.targets.Target;
import net.serenitybdd.screenplay.waits.WaitUntil;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;

import net.serenitybdd.screenplay.Actor;
import static net.serenitybdd.screenplay.Tasks.instrumented;

 

import java.util.concurrent.TimeUnit;
import static drivers.AppiumDriver.driver;

/**
 * Clase base vacía para la pantalla de Puntos Droop.
 */
public final class PantallaPuntosDroop {

    private PantallaPuntosDroop() {
    }

    private static final Target CAMPO_LECTURA = Target.the("Campo para insertar unidades")
            .located(By.id("com.coordinadora.timgoo.qa.PuntosDroopModule:id/unit"));
    private static final Target BOTON_FINALIZAR = Target.the("Boton Finalizar")
            .located(By.id("com.coordinadora.timgoo.qa.PuntosDroopModule:id/btn_effective"));
    private static final Target BOTON_ACEPTAR = Target.the("Botón aceptar mensaje confirmación")
            .locatedBy("//android.widget.Button[@resource-id='android:id/button1']");
    private static final Target BOTON_VER_SERVICIOS = Target.the("Boton ver servicios")
            .located(By.id("com.coordinadora.timgoo.qa.PuntosDroopModule:id/btnServicios"));

    public static Performable ingresarCampoTexto() {
        return Task.where("Ingresar al campo de texto",
                WaitUntil.the(CAMPO_LECTURA, isVisible()),
                WaitUntil.the(CAMPO_LECTURA, isClickable()),
                Click.on(CAMPO_LECTURA));
    }

    public static Performable presionarFinalizar() {
        return Task.where("Se presiona botón Finalizar",
                WaitUntil.the(BOTON_FINALIZAR, isVisible()),
                WaitUntil.the(BOTON_FINALIZAR, isClickable()),
                Click.on(BOTON_FINALIZAR));
    }

    public static Performable presionarBotonAceptar() {
        return Task.where("Se presiona botón Aceptar mensaje confirmación",
                WaitUntil.the(BOTON_ACEPTAR, isVisible()),
                WaitUntil.the(BOTON_ACEPTAR, isClickable()),
                Click.on(BOTON_ACEPTAR));
    }

    public static Performable presionarVerServicios() {
        return Task.where("Se presiona botón ver servicios",
                WaitUntil.the(BOTON_VER_SERVICIOS, isVisible()),
                WaitUntil.the(BOTON_VER_SERVICIOS, isClickable()),
                Click.on(BOTON_VER_SERVICIOS));
    }

    // La lectura de guías desde PDF fue movida a utils.GuiaDataReader

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

            actor.attemptsTo(
                    WaitUntil.the(CAMPO_LECTURA, isVisible()),
                    WaitUntil.the(CAMPO_LECTURA, isClickable()));

            for (GuiaInfo g : guias) {

                actor.attemptsTo(
                        Click.on(CAMPO_LECTURA),
                        Enter.keyValues(g.getEtiqueta1d()).into(CAMPO_LECTURA));

                // Presionar Enter usando el teclado virtual
                try {
                    driver.pressKey(new io.appium.java_client.android.nativekey.KeyEvent(
                            io.appium.java_client.android.nativekey.AndroidKey.ENTER));

                } catch (Exception e) {
                    System.out.println("⚠️ Error al presionar Enter: " + e.getMessage());
                    // Fallback: intentar con Hit.the
                    actor.attemptsTo(Hit.the(Keys.ENTER).into(CAMPO_LECTURA));
                }

                PantallaPuntosDroop.waitTime(1000);
            }

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

    public static Performable seleccionarResultadoPorCodigo(String codigoRemision) {
        Target RESULTADO_UNICO = Target.the("Resultado para " + codigoRemision)
                .locatedBy(
                        "//androidx.recyclerview.widget.RecyclerView[@resource-id='com.coordinadora.timgoo.qa:id/recyclerview']//*[contains(@text,'"
                                + codigoRemision + "')]");
        return Task.where("Seleccionar resultado exacto en RecyclerView",
                WaitUntil.the(RESULTADO_UNICO, isVisible()),
                WaitUntil.the(RESULTADO_UNICO, isClickable()),
                Click.on(RESULTADO_UNICO));
    }

}
