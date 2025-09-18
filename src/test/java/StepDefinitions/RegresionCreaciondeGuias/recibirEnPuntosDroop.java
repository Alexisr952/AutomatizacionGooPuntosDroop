package StepDefinitions.RegresionCreaciondeGuias;

import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;

import static drivers.AppiumDriver.driver;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.actors.OnlineCast;
import java.util.List;
import drivers.AppiumDriver;
import funciones.PantallaDeLogin;
import funciones.PantallaPerfil;
import funciones.PantallaPuntosDroop;
import funciones.PantallaDeServicios;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
//import java.time.Duration;
import java.nio.file.Path;
import java.nio.file.Paths;
import funciones.PantallaPuntosDroop.GuiaInfo;

public class recibirEnPuntosDroop {

    @Before
    public void before() {
        OnStage.setTheStage(new OnlineCast());
    }

    @Given("Que estoy en la pantalla de Login de la aplicacion para Puntos Droop")
    public void Que_estoy_en_la_pantalla_de_Login_de_la_aplicacion() {
        AppiumDriver.initializeDriver();
        OnStage.theActorCalled("Apertura Goo").can(BrowseTheWeb.with(AppiumDriver.on()));
        theActorInTheSpotlight().attemptsTo(PantallaDeLogin.ingresoUsuario("30709"));
        PantallaDeLogin.waitTime(1000);
        theActorInTheSpotlight().attemptsTo(PantallaDeLogin.botoncontinuarglobal());
        PantallaDeLogin.waitTime(1000);
        theActorInTheSpotlight().attemptsTo(PantallaDeLogin.ingresoPassword("4", "0", "1", "3"));
        PantallaDeLogin.waitTime(1000);
        theActorInTheSpotlight().attemptsTo(PantallaDeLogin.botoncontinuarglobal());
        PantallaDeLogin.waitTime(1000);
        theActorInTheSpotlight().attemptsTo(PantallaPerfil.ingresarAlaPantallaDeEquipoDeTrabajo());
        PantallaDeLogin.waitTime(1000);
        theActorInTheSpotlight().attemptsTo(PantallaPerfil.ingresarEquipoDeTrabajo("9"));
        theActorInTheSpotlight().attemptsTo(PantallaDeLogin.botoncontinuarglobal());
        PantallaDeLogin.waitTime(1000);
        theActorInTheSpotlight().attemptsTo(PantallaDeLogin.botoncontinuarglobal());
        // heActorInTheSpotlight().attemptsTo(PantallaPerfil.ingresarLaMovil("1080"));
        PantallaDeLogin.waitTime(3000);
        driver.pressKey(new KeyEvent(AndroidKey.ENTER));
        PantallaDeLogin.waitTime(3000);
        driver.pressKey(new KeyEvent(AndroidKey.BACK));
        PantallaDeLogin.waitTime(1000);

    }

    @When("Estoy en el inicio de la aplicacion para Puntos Droop")
    public void Estoy_en_el_inicio_de_la_aplicacion() {
        theActorInTheSpotlight().attemptsTo(PantallaPerfil.presionarMenuHamburguesa());
        PantallaDeLogin.waitTime(2000);
        theActorInTheSpotlight().attemptsTo(PantallaPerfil.presionarPuntosDroop());

    }

    @Then("Ingreso a Recibir en Punto Droop y leo las guias para Puntos Droop")
    public void Ingreso_a_Recibir_en_Punto_Droop_y_leo_las_guias_para_Puntos_Droop() {
        List<GuiaInfo> guias;
        try {
            Path pdf = Paths.get(System.getProperty("user.dir"), "impresionrotulos1.pdf");
            if (!java.nio.file.Files.exists(pdf)) {
                throw new AssertionError("❌ No se encuentra el PDF en: " + pdf.toAbsolutePath());
            }
            guias = PantallaPuntosDroop.extraerGuiasDesdePdf(pdf);
        } catch (Exception e) {
            throw new AssertionError("❌ Error al leer las guías: " + e.getMessage());
        }

        theActorInTheSpotlight().attemptsTo(PantallaPuntosDroop.ingresarGuias(guias));
        // Guardar las guías para usarlas en pasos posteriores
        OnStage.theActorInTheSpotlight().remember("guiasExtraidas", guias);

        driver.hideKeyboard();
        PantallaDeLogin.waitTime(1000);
        theActorInTheSpotlight().attemptsTo(PantallaPuntosDroop.presionarFinalizar());
        PantallaDeLogin.waitTime(1000);
        theActorInTheSpotlight().attemptsTo(PantallaPuntosDroop.presionarBotonAceptar());
        PantallaDeLogin.waitTime(3000);
        theActorInTheSpotlight().attemptsTo(PantallaPuntosDroop.presionarVerServicios());
        PantallaDeLogin.waitTime(2000);
        theActorInTheSpotlight().attemptsTo(PantallaPerfil.presionarBotonPerfil());
        PantallaDeLogin.waitTime(1000);
        theActorInTheSpotlight().attemptsTo(PantallaDeServicios.ingresoAlaPantallaDeServicios());
    }

    @Then("Busco las guías en carga de trabajo")
    public void Busco_las_guias_en_carga_de_trabajo() {
        List<GuiaInfo> guias = OnStage.theActorInTheSpotlight().recall("guiasExtraidas");
        if (guias == null || guias.isEmpty()) {
            throw new AssertionError("No se encontraron guías previamente extraídas para realizar la búsqueda");
        }

        // Usar solo el código de remisión puro (sin prefijo 7 ni sufijos como .0 o 001)
        String codigoRemision = guias.get(0).getCodigoRemision();

        theActorInTheSpotlight().attemptsTo(PantallaDeServicios.botonBusquedaDeServicios());
        PantallaDeLogin.waitTime(1000);
        theActorInTheSpotlight()
                .attemptsTo(PantallaDeServicios.ingresarNumeroDeGuiaEnBuscadorDeServicios(codigoRemision));
        PantallaPuntosDroop.waitTime(1000);
        theActorInTheSpotlight().attemptsTo(PantallaPuntosDroop.seleccionarResultadoPorCodigo(codigoRemision));
    }

}
