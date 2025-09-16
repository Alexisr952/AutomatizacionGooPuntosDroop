package StepDefinitions.RegresionCreaciondeGuias;

import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static drivers.AppiumDriver.driver;
import utils.GuiaDataReader;
import net.serenitybdd.core.annotations.findby.By;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.actors.OnlineCast;
import java.util.List;
import drivers.AppiumDriver;
import funciones.PantallaDeLogin;
import funciones.PantallaFPinternacional;
import funciones.PantallaPerfil;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import Tareas.IngresarTextoYEnter;
//import java.time.Duration;
import Tareas.ClickEnElemento;

public class CrearGuiasFP {

    @Before
    public void before() {
        OnStage.setTheStage(new OnlineCast());
    }

    @Given("Que estoy en la pantalla de recogidas de la aplicacion")
    public void Que_estoy_en_la_pantalla_de_recogidas_de_la_aplicacion() {
        AppiumDriver.initializeDriver();
        OnStage.theActorCalled("Apertura Goo").can(BrowseTheWeb.with(AppiumDriver.on()));
        theActorInTheSpotlight().attemptsTo(PantallaDeLogin.ingresoUsuario("1077"));
        PantallaDeLogin.waitTime(1000);
        theActorInTheSpotlight().attemptsTo(PantallaDeLogin.botoncontinuarglobal());
        PantallaDeLogin.waitTime(1000);
        theActorInTheSpotlight().attemptsTo(PantallaDeLogin.ingresoPassword("6","8","2","7"));
        PantallaDeLogin.waitTime(1000);
        theActorInTheSpotlight().attemptsTo(PantallaDeLogin.botoncontinuarglobal());
        PantallaDeLogin.waitTime(1000);
        theActorInTheSpotlight().attemptsTo(PantallaPerfil.ingresarAlaPantallaDeEquipoDeTrabajo());
        PantallaDeLogin.waitTime(1000);
        theActorInTheSpotlight().attemptsTo(PantallaPerfil.ingresarEquipoDeTrabajo("3333"));
        theActorInTheSpotlight().attemptsTo(PantallaDeLogin.botoncontinuarglobal());
        PantallaDeLogin.waitTime(1000);
        theActorInTheSpotlight().attemptsTo(PantallaPerfil.ingresarLaMovil("1080"));
        PantallaDeLogin.waitTime(3000);
        driver.pressKey(new KeyEvent(AndroidKey.ENTER));
        PantallaDeLogin.waitTime(3000);
        driver.pressKey(new KeyEvent(AndroidKey.BACK));
        PantallaDeLogin.waitTime(2000);
        theActorInTheSpotlight().attemptsTo(PantallaFPinternacional.presionarrecogida());
        PantallaDeLogin.waitTime(2000);
    }

    @When("Estoy en la pantalla de Recogidas MX")
    public void Estoy_en_la_pantalla_de_Recogidas_MX() {
        try {
            boolean textoPresente = driver.getPageSource().contains("Información del envío");
            if (!textoPresente) {
                throw new AssertionError("❌ El texto 'Información del envío' no está presente en la pantalla.");
            }
            System.out.println("✅ El texto 'Información del envío' está presente en la pantalla.");
        } catch (Exception e) {
            throw new AssertionError("❌ Error al validar la pantalla: " + e.getMessage());
        }
    }

@Then("Ingreso los campos para crear una recogida")
public void Creo_una_guia_de_recogida() {
    // Llenar campos básicos
    theActorInTheSpotlight().attemptsTo(
        IngresarTextoYEnter.enCampo("//android.widget.EditText[@resource-id='com.coordinadora.timgoo.qa:id/editName']", "Fabian Leudo"),
        IngresarTextoYEnter.enCampo("//android.widget.EditText[@resource-id='com.coordinadora.timgoo.qa:id/editLastname']", "Leudo Ramos"),
        IngresarTextoYEnter.enCampo("//android.widget.EditText[@resource-id='com.coordinadora.timgoo.qa:id/editIdentificacion']", "1113676827"),
        ClickEnElemento.enXpath("//android.widget.Button[@resource-id='com.coordinadora.timgoo.qa:id/btnNext']")
    );

    // Esperar que se cargue la siguiente pantalla
    PantallaDeLogin.waitTime(3000);

    // Scroll hasta la palabra Dirección
    try {
        driver.findElement(AppiumBy.androidUIAutomator(
            "new UiScrollable(new UiSelector().scrollable(true))" +
            ".scrollIntoView(new UiSelector().text(\"Dirección\"))"
        ));
        System.out.println("✅ El texto 'Dirección' está presente en la pantalla.");
    } catch (Exception e) {
        throw new AssertionError("❌ Error al validar la pantalla 'Dirección': " + e.getMessage());
    }

    // Espera breve por si el scroll toma tiempo
    PantallaDeLogin.waitTime(2000);

    // Ingresar ciudad y seleccionar sugerencia
    try {
        WebElement campoCiudad = driver.findElement(By.xpath("//android.widget.AutoCompleteTextView[@resource-id='com.coordinadora.timgoo.qa:id/editCiudad']"));
        campoCiudad.sendKeys("Azcapotzalco");
        PantallaDeLogin.waitTime(1000); // Esperar a que cargue la lista
        ((AndroidDriver) driver).pressKey(new KeyEvent(AndroidKey.ENTER)); // Seleccionar ciudad
        System.out.println("✅ Ciudad 'Azcapotzalco' seleccionada correctamente.");
    } catch (Exception e) {
        throw new AssertionError("❌ Error al seleccionar la ciudad: " + e.getMessage());
    }

    //Ingresar tipo de via
// Ingresar tipo de vía usando teclas
try {
    // 1. Clic en el Spinner
    driver.findElement(By.id("com.coordinadora.timgoo.qa:id/editTipoVia")).click();
    PantallaDeLogin.waitTime(1000);

    // 2. Obtener el AndroidDriver desde el actor
    AndroidDriver androidDriver = (AndroidDriver) BrowseTheWeb.as(theActorInTheSpotlight()).getDriver();


    // 3. Simular doble DPAD_DOWN y ENTER
    androidDriver.pressKey(new KeyEvent(AndroidKey.DPAD_DOWN));
    PantallaDeLogin.waitTime(300);
    androidDriver.pressKey(new KeyEvent(AndroidKey.DPAD_DOWN));
    PantallaDeLogin.waitTime(300);
    androidDriver.pressKey(new KeyEvent(AndroidKey.ENTER));

    System.out.println("✅ Tipo de vía seleccionada mediante navegación por teclas.");
} catch (Exception e) {
    throw new AssertionError("❌ Error al seleccionar el tipo de vía con teclas: " + e.getMessage());
}

theActorInTheSpotlight().attemptsTo(
    IngresarTextoYEnter.enCampo("//android.widget.EditText[@resource-id='com.coordinadora.timgoo.qa:id/editVia']", "Calle 40a"),
    IngresarTextoYEnter.enCampo("//android.widget.EditText[@resource-id='com.coordinadora.timgoo.qa:id/editNumero']", "43 59"),
    IngresarTextoYEnter.enCampo("//android.widget.EditText[@resource-id='com.coordinadora.timgoo.qa:id/editComplemento']", "Esto es una prueba automatizada por FL"),
    ClickEnElemento.enXpath("//android.widget.Button[@resource-id='com.coordinadora.timgoo.qa:id/btnNext']"),
    ClickEnElemento.enXpath("//android.widget.Button[@resource-id='android:id/button1']"),
    ClickEnElemento.enXpath("//android.widget.LinearLayout[@resource-id=\"com.coordinadora.timgoo.qa.RecogidasModule:id/linearHayGuia\"]/android.widget.LinearLayout[3]/android.widget.ImageView"),
    ClickEnElemento.enXpath("//android.widget.LinearLayout[@resource-id=\"com.coordinadora.timgoo.qa.RecogidasModule:id/linearNoHayGuia\"]/android.widget.LinearLayout[3]/android.widget.ImageView")
    
);

}

@Then("Creo una guía de recogida")
public void creo_una_guia_de_recogida() {

    // 1. Click en el botón 'Siguiente'
    theActorInTheSpotlight().attemptsTo(
        ClickEnElemento.enXpath("//android.widget.Button[@resource-id='com.coordinadora.timgoo.qa:id/btnNext']")
    );

    // 2. Captura del número de envío desde el mensaje emergente
    try {
        PantallaDeLogin.waitTime(2000); // espera a que aparezca el mensaje

        WebElement mensaje = driver.findElement(By.xpath("//android.widget.TextView[@resource-id='android:id/message']"));
        String textoMensaje = mensaje.getText();
        System.out.println("📦 Mensaje capturado: " + textoMensaje);

        String numeroEnvio = "";
        java.util.regex.Pattern pattern = java.util.regex.Pattern.compile("envío (\\d+)");
        java.util.regex.Matcher matcher = pattern.matcher(textoMensaje);

        if (matcher.find()) {
            numeroEnvio = matcher.group(1);
            System.out.println("✅ Número de envío capturado: " + numeroEnvio);
        } else {
            throw new AssertionError("❌ No se encontró número de envío en el mensaje: " + textoMensaje);
        }

        PantallaDeLogin.waitTime(1000);
        driver.findElement(By.id("android:id/button1")).click(); // cerrar el diálogo

    } catch (Exception e) {
        throw new AssertionError("❌ Error al capturar o procesar el número de envío: " + e.getMessage());
    }

    // 3. Leer guías desde el archivo JSON e ingresarlas una por una
    List<String> guias = GuiaDataReader.leerGuiasDesdeJson("src/test/resources/data/guias.json");

    for (String guia : guias) {
        theActorInTheSpotlight().attemptsTo(
            IngresarTextoYEnter.enCampo("//android.widget.EditText[@resource-id='com.coordinadora.timgoo.qa.RecogidasModule:id/unit']", guia)
        );
        PantallaDeLogin.waitTime(500); // pequeña espera entre guías
    }
}

}
