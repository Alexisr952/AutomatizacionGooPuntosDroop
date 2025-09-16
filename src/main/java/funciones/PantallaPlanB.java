package funciones;

import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isClickable;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;

import static drivers.GmailDriver.driver;
import static funciones.PantallaPerfil.click;

import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.targets.Target;
import net.serenitybdd.screenplay.waits.WaitUntil;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;

import javax.swing.Action;

import io.appium.java_client.TouchAction;
import io.appium.java_client.touch.offset.PointOption;

public class PantallaPlanB {




    private static final Target CAMPOLECTORUNIDADES = Target.the("Sirve para ingresar la lectura de unidades plan B").locatedBy("//android.widget.EditText[@resource-id=\"com.coordinadora.timgoo.qa:id/unit\"]");
    private static final Target BOTONENTENDIDO = Target.the("Sirve para Presionar boton entendido").locatedBy("//android.widget.Button[@resource-id=\"android:id/button1\"]");
    private static final Target BOTONENVIAR = Target.the("Sirve para Presionar boton enviar pantalla plan B").locatedBy("//android.widget.Button[@resource-id=\"com.coordinadora.timgoo.qa:id/btn_effective\"]");



    /**
     * Ingresa un número de equipo de trabajo en el campo correspondiente.
     *
     * @param equipo El número de equipo a ingresar.
     * @return Una tarea que realiza la acción de ingresar el número de equipo.
     */
    public static Performable campolectorunidades(String equipo) {
        return Task.where("Sirve para ingresar la lectura de unidades plan B",
                WaitUntil.the(CAMPOLECTORUNIDADES, isVisible()),
                WaitUntil.the(CAMPOLECTORUNIDADES, isClickable()),
                Click.on(CAMPOLECTORUNIDADES),
                Enter.keyValues(equipo).into(CAMPOLECTORUNIDADES));
    }

    public static Performable botonentendido() {
        return Task.where("Sirve para ingresar la lectura de unidades plan B",
                WaitUntil.the(BOTONENTENDIDO, isVisible()),
                WaitUntil.the(BOTONENTENDIDO, isClickable()),
                Click.on(BOTONENTENDIDO));
    }

    public static Performable botonenviar() {
        return Task.where("Sirve para presionar boton enviar plan B",
                WaitUntil.the(BOTONENVIAR, isVisible()),
                WaitUntil.the(BOTONENVIAR, isClickable()),
                Click.on(BOTONENVIAR));
    }

    public static void mainhorizontal1(String[] args) {
        // Configuración del controlador de Appium

        // Función que has proporcionado
        performClick();
    }

    public static void performClick() {
        int x = 451; // Coordenada x deseada
        int y =683; // Coordenada y deseada
        click(x, y);
    }

}







