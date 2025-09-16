package funciones;

import static drivers.AppiumDriver.driver;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isClickable;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;
import drivers.AppiumDriver;
import io.appium.java_client.PerformsTouchActions;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;
import java.time.Duration;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.targets.Target;
import net.serenitybdd.screenplay.waits.WaitUntil;
import org.openqa.selenium.By;
import org.openqa.selenium.Point;
import org.openqa.selenium.interactions.PointerInput;
import org.openqa.selenium.interactions.Sequence;
import java.util.Arrays;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.touch.offset.PointOption;
import io.appium.java_client.touch.offset.PointOption;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.touch.offset.PointOption;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.touch.offset.PointOption;
import org.openqa.selenium.interactions.PointerInput;
import org.openqa.selenium.interactions.Sequence;
import java.time.Duration;
import java.util.Arrays;

public class Pantallaunidadesinferiores {



    public static final Target Botonunidadesinferiores = Target.the("se utiliza para agregar unidades inferiores").locatedBy("//android.widget.TextView[@resource-id=\"com.coordinadora.timgoo.qa.EntregasModule:id/tvUnitsDelivery\"]");

    public static final Target BotonEvidencia = Target.the("se utiliza para agregar evidencia ").locatedBy("//android.widget.Button[@resource-id=\"com.coordinadora.timgoo.qa.EntregasModule:id/btn_evidencia\"]");


//*******************************************************************************************
    public static Performable Presionarunidadesinferiores() {
        return
                Task.where("se utiliza para presionar el Boton de unidades inferiores",
                        WaitUntil.the(Botonunidadesinferiores, isVisible()),
                        WaitUntil.the(Botonunidadesinferiores, isClickable()),
                        Click.on(Botonunidadesinferiores).afterWaitingUntilEnabled());

    }

    public static Performable Presionarevidencia() {
        return
                Task.where("se utiliza para presionar el Boton de unidades inferiores",
                        WaitUntil.the(BotonEvidencia, isVisible()),
                        WaitUntil.the(BotonEvidencia, isClickable()),
                        Click.on(BotonEvidencia).afterWaitingUntilEnabled());

    }


    public static void click(int x, int y) {
        PointerInput finger = new PointerInput(PointerInput.Kind.TOUCH, "finger");

        Sequence click = new Sequence(finger, 1);
        click.addAction(finger.createPointerMove(Duration.ofMillis(0), PointerInput.Origin.viewport(), x, y));
        click.addAction(finger.createPointerDown(PointerInput.MouseButton.LEFT.asArg()));
        click.addAction(finger.createPointerUp(PointerInput.MouseButton.LEFT.asArg()));

        driver.perform(Arrays.asList(click));
    }

    public static void fotoevidencia(String[] args) {
        // Configuración del controlador de Appium

        // Función que has proporcionado
        performClick();
    }

    public static void performClick() {
        int x = 544; // Coordenada x deseada
        int y = 2041; // Coordenada y deseada
        click(x, y);
    }

    public static void aceptarfoto(String[] args) {
        // Configuración del controlador de Appium

        // Función que has proporcionado
        performClick1();
    }

    public static void performClick1() {
        int x = 858; // Coordenada x deseada
        int y = 2054; // Coordenada y deseada
        click(x, y);
    }
    public static void seleccionnovedad(String[] args) {
        // Configuración del controlador de Appium

        // Función que has proporcionado
        performClick2();
    }

    public static void performClick2() {
        int x = 635; // Coordenada x deseada
        int y = 718; // Coordenada y deseada
        click(x, y);

    }

    public static void Firma(String[] args) {
        // Configuración del controlador de Appium

        // Función que has proporcionado
        performClick3();
    }

    public static void performClick3() {
        int x = 1724; // Coordenada x deseada
        int y = 502; // Coordenada y deseada
        click(x, y);

    }






}
