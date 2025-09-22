package StepDefinitions.RegresionCreaciondeGuias;

import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;

 

import static drivers.AppiumDriver.driver;
import utils.GuiaDataReader;
 
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.actors.OnlineCast;
import java.util.List;
import drivers.AppiumDriver;
import funciones.PantallaDeLogin;
 
import funciones.PantallaPerfil;
import funciones.PantallaPuntosDroop;
 
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
//import java.time.Duration;
 
import java.nio.file.Path;
import java.nio.file.Paths;
import utils.GuiaInfo;

public class CrearGuiasFP {

    @Before
    public void before() {
        OnStage.setTheStage(new OnlineCast());
    }

    @Given("Que estoy en la pantalla de Login de la aplicacion")
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

    @When("Estoy en el inicio de la aplicacion")
    public void Estoy_en_el_inicio_de_la_aplicacion() {
        theActorInTheSpotlight().attemptsTo(PantallaPerfil.presionarMenuHamburguesa());
        PantallaDeLogin.waitTime(2000);
        theActorInTheSpotlight().attemptsTo(PantallaPerfil.presionarPuntosDroop());

    }

    @Then("Ingreso a Recibir en Punto Droop y leo las guias")
    public void Ingreso_a_Recibir_en_Punto_Droop_y_leo_las_guias() {
        
    }

}
