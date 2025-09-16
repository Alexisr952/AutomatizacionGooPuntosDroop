package funciones;
import static drivers.AppiumDriver.driver;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isClickable;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;

import drivers.AppiumDriver;
import io.appium.java_client.PerformsTouchActions;
import io.appium.java_client.TouchAction;
import io.appium.java_client.touch.offset.PointOption;
import java.util.concurrent.TimeUnit;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.targets.Target;
import net.serenitybdd.screenplay.waits.WaitUntil;
import org.openqa.selenium.By;


/**
 * Esta clase contiene métodos y constantes relacionados con la pantalla de inicio de sesión
 * de una aplicación móvil.
 */
public final class PantallaDeLogin {

    // Constructor privado para evitar instancias de la clase
    private PantallaDeLogin() {
    }

    // Constantes para los selectores de elementos de la interfaz de usuario
    private static final Target CAMPO_INGRESAR_USUARIO = Target.the("Campo para ingresar el usuario").locatedBy("//android.widget.EditText[@resource-id=\"com.coordinadora.timgoo.qa:id/etxtEmail\"]");
    private static final Target PASSWORD1 = Target.the("Ingresar primer numero de la contraseña").located(By.id("com.coordinadora.timgoo.qa:id/etxtPassword1"));
    private static final Target PASSWORD2 = Target.the("Ingresar segundo numero de la contraseña").located(By.id("com.coordinadora.timgoo.qa:id/etxtPassword2"));
    private static final Target PASSWORD3 = Target.the("Ingresar tercer numero de la contraseña").located(By.id("com.coordinadora.timgoo.qa:id/etxtPassword3"));
    private static final Target PASSWORD4 = Target.the("Ingresar cuarto numero de la contraseña").located(By.id("com.coordinadora.timgoo.qa:id/etxtPassword4"));
    private static final Target BOTON_CONTINUAR_GLOBAL = Target.the("Boton Continuar global en la app").locatedBy("//*[contains(@text,'CONTINUAR')]");
    private static final Target BOTON_CONFIRMAR_GLOBAL = Target.the("Boton CONFIRMAR global en la app").locatedBy("//*[contains(@text,'CONFIRMAR')]");
    private static final Target BOTON_CERRAR_SESION = Target.the("Boton cerrar sesion global en la app").locatedBy("//*[contains(@text,'Cerrar sesión')]");
    private static final Target BOTON_ACEPTAR_GLOBAL = Target.the("Boton aceptar global en la app").locatedBy("//*[contains(@text,'ACEPTAR')]");
    private static final Target BOTON_ENTENDIDO_GLOBAL = Target.the("Boton entendido global en la app").locatedBy("//*[contains(@text,'ENTENDIDO')]");

    private static final Target BOTON_CANCELAR_GLOBAL = Target.the("Presionar boton cancelar global en la app").locatedBy("//*[contains(@text,'CANCELAR')]");
    private static final Target BOTON_RETROCEDER = Target.the("Boton regresar").located(By.id("com.coordinadora.timgoo.qa:id/go_back_button"));
    private static final Target MENU_3_PUNTOS = Target.the("Boton para hacer apertura del menu de los 3 puntos").locatedBy("//android.widget.TextView[@content-desc=\"More\"]");
    private static final Target PLAN_B = Target.the("Boton acceder a plan B desde la pantalla de inicio").locatedBy("//android.widget.TextView[@resource-id=\"com.coordinadora.timgoo.qa:id/txtPlanB\"]");

    private static final Target FLECHA_ATRAS_PLAN_B = Target.the("Flecha atras bonton plan b").locatedBy("//android.widget.ImageButton[@content-desc=\"Flecha atrás\"]");




    /**
     * Ingresa un usuario en el campo correspondiente.
     *
     * @param usuario El nombre de usuario a ingresar.
     * @return Una tarea que realiza la acción de ingresar el usuario.
     */
    public static Performable ingresoUsuario(String usuario) {
        return Task.where("Ingresar un usuario",
                WaitUntil.the(CAMPO_INGRESAR_USUARIO, isVisible()),
                WaitUntil.the(CAMPO_INGRESAR_USUARIO, isClickable()),
                Click.on(CAMPO_INGRESAR_USUARIO),
                Enter.keyValues(usuario).into(CAMPO_INGRESAR_USUARIO));
    }

    /**
     * Ingresa una contraseña en los campos correspondientes.
     *
     * @param contrasena1 El primer dígito de la contraseña.
     * @param contrasena2 El segundo dígito de la contraseña.
     * @param contrasena3 El tercer dígito de la contraseña.
     * @param contrasena4 El cuarto dígito de la contraseña.
     * @return Una tarea que realiza la acción de ingresar la contraseña.
     */
    public static Performable ingresoPassword(String contrasena1, String contrasena2, String contrasena3, String contrasena4) {
        return Task.where("Ingresar una Contrasena",
                WaitUntil.the(PASSWORD1, isVisible()),
                WaitUntil.the(PASSWORD1, isClickable()),
                Enter.keyValues(contrasena1).into(PASSWORD1),
                WaitUntil.the(PASSWORD2, isVisible()),
                WaitUntil.the(PASSWORD2, isClickable()),
                Enter.keyValues(contrasena2).into(PASSWORD2),
                WaitUntil.the(PASSWORD3, isVisible()),
                WaitUntil.the(PASSWORD3, isClickable()),
                Enter.keyValues(contrasena3).into(PASSWORD3),
                WaitUntil.the(PASSWORD4, isVisible()),
                WaitUntil.the(PASSWORD4, isClickable()),
                Enter.keyValues(contrasena4).into(PASSWORD4));
    }

    /**
     * Cierra la sesión actual.
     *
     * @return Una tarea que realiza la acción de cerrar la sesión.
     */
    public static Performable finalizarSession() {
        return Task.where("Cerrar Sesion",
                WaitUntil.the(BOTON_CERRAR_SESION, isVisible()),
                WaitUntil.the(BOTON_CERRAR_SESION, isClickable()),
                Click.on(BOTON_CERRAR_SESION));
    }

    /**
     * Presiona el botón "Aceptar" global en la aplicación.
     *
     * @return Una tarea que realiza la acción de presionar el botón "Aceptar".
     */
    public static Performable botonaceptarglobal() {
        return Task.where("Aceptar",
                WaitUntil.the(BOTON_ACEPTAR_GLOBAL, isVisible()),
                WaitUntil.the(BOTON_ACEPTAR_GLOBAL, isClickable()),
                Click.on(BOTON_ACEPTAR_GLOBAL));
    }

    /**
     * Presiona el botón "Cancelar" global en la aplicación.
     *
     * @return Una tarea que realiza la acción de presionar el botón "Cancelar".
     */
    public static Performable botoncancelarglobal() {
        return Task.where("Cancelar",
                WaitUntil.the(BOTON_CANCELAR_GLOBAL, isVisible()),
                WaitUntil.the(BOTON_CANCELAR_GLOBAL, isClickable()),
                Click.on(BOTON_CANCELAR_GLOBAL));
    }
    public static Performable botonentendidoglobal() {
        return Task.where("Cancelar",
                WaitUntil.the(BOTON_ENTENDIDO_GLOBAL, isVisible()),
                WaitUntil.the(BOTON_ENTENDIDO_GLOBAL, isClickable()),
                Click.on(BOTON_ENTENDIDO_GLOBAL));
    }

    /**
     * Presiona el botón "Continuar" global en la aplicación.
     *
     * @return Una tarea que realiza la acción de presionar el botón "Continuar".
     */
    public static Performable botoncontinuarglobal() {
        return Task.where("Continuar",
                WaitUntil.the(BOTON_CONTINUAR_GLOBAL, isVisible()),
                WaitUntil.the(BOTON_CONTINUAR_GLOBAL, isClickable()).forNoMoreThan(10).seconds(),
                Click.on(BOTON_CONTINUAR_GLOBAL).afterWaitingUntilEnabled());
    }

    public static Performable botonConfirmar() {
        return
                Task.where("se utiliza para Continuar",
                        WaitUntil.the(BOTON_CONFIRMAR_GLOBAL, isVisible()),
                        WaitUntil.the(BOTON_CONFIRMAR_GLOBAL, isClickable()),
                        Click.on(BOTON_CONFIRMAR_GLOBAL)
                );
    }

    public static Performable botonRetrocederLogin() {
        return
                Task.where("se utiliza para retroceder en la pantalla servicios",
                        WaitUntil.the(BOTON_RETROCEDER, isVisible()),
                        WaitUntil.the(BOTON_RETROCEDER, isClickable()).forNoMoreThan(30).seconds(),
                        Click.on(BOTON_RETROCEDER).afterWaitingUntilEnabled()
                );
    }

    public static Performable aperturaMenuDe3Puntos() {
        return
                Task.where("se utiliza para abrir el menu para cerrar la session",
                        WaitUntil.the(MENU_3_PUNTOS, isVisible()),
                        WaitUntil.the(MENU_3_PUNTOS, isClickable()),
                        Click.on(MENU_3_PUNTOS)
                );
    }
    /**
     * ESTA FUNCION SE USA PARA SELECCIONAR UN ITEM DE COORDENADAS ESPECIFICAS
     *SIRVE PARA SELECCIONAR LAS OPCIONES DE LOS CAMPOS AUTO COMPLETABLES QUE NO SE DEJAN MAPEAR PERO ES UNA OPCION
     * @param data1 recibe el valor x para hacer un touch action
     * @param data2 recibe el valor y para hacer touch action
     */
    public static void seleccionDeUnItemEnCoordenadasEspecificas(int data1, int data2) {
        TouchAction touchAction = new TouchAction((PerformsTouchActions) AppiumDriver.driver);
        touchAction.tap(PointOption.point(data1, data2)).perform();
    }

    public static void waitTime(long time) {
        try {
            TimeUnit.MILLISECONDS.sleep(time);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            e.printStackTrace();
        }
    }

    public static Performable accederplanb() {
        return
                Task.where("se utiliza para acceder a plan b desde la pantalla de inicio",
                        WaitUntil.the(PLAN_B, isVisible()),
                        WaitUntil.the(PLAN_B, isClickable()),
                        Click.on(PLAN_B)
                );
    }

    public static Performable Botonatrasplanb() {
        return
                Task.where("se utiliza para ir atras en la pantalla de plan b",
                        WaitUntil.the(FLECHA_ATRAS_PLAN_B, isVisible()),
                        WaitUntil.the(FLECHA_ATRAS_PLAN_B, isClickable()),
                        Click.on(FLECHA_ATRAS_PLAN_B)
                );
    }
}
