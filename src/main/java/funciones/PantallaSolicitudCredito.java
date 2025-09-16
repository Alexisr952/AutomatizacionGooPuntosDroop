package funciones;

import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isClickable;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.targets.Target;
import net.serenitybdd.screenplay.waits.WaitUntil;
import org.openqa.selenium.By;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;


public class PantallaSolicitudCredito {

    private PantallaSolicitudCredito() {
        // Constructor privado para evitar instancias de la clase
        // Puedes dejarlo vacío o lanzar una excepción si deseas
    }
    //***********************************************************************************************************************

    public static final Target Correoelectronico = Target.the("se utiliza para agregar correo electronico").locatedBy("//android.webkit.WebView[@text=\"Wompi\"]/android.view.View[2]/android.widget.EditText[1]");

    public static final Target Pagcontarjeta = Target.the("se utiliza para pagar con tarjetas").locatedBy("//android.view.View[@content-desc=\"logo logo logo Paga con tus tarjetas\"]");

    //***********************************************************************************************************************


    public static Performable presionacorreoelectronico(String usuario) {
        return
                Task.where("se utiliza para presionar el Boton mas que se encuentra en la parte inferior",
                        WaitUntil.the(Correoelectronico, isVisible()),
                        WaitUntil.the(Correoelectronico, isClickable()),
                        Click.on(Correoelectronico),
                        Enter.keyValues(usuario).into(Correoelectronico));
    }


    public static Performable pagarcontajeta() {
        return
                Task.where("se utiliza para presionar el Boton mas que se encuentra en la parte inferior",
                        WaitUntil.the(Pagcontarjeta, isVisible()),
                        WaitUntil.the(Pagcontarjeta, isClickable()),
                        Click.on(Pagcontarjeta).afterWaitingUntilEnabled());

    }
}






