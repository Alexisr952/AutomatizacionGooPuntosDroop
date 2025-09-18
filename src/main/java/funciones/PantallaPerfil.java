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


public final class PantallaPerfil {
    // Constructor privado para evitar instancias de la clase
    private PantallaPerfil() {
    }

    // Constantes para los selectores de elementos de la interfaz de usuario
    private static final Target INGRESAR_PANTALLA_PERFIL = Target.the("Ingresar a la pantalla perfil").locatedBy("//*[contains(@text,'Perfil')]");
    private static final Target CONECTARSE_A_UN_GRUPO_DE_TRABAJO = Target.the("Funciona para conectarse a un grupo de trabajo").located(By.id("com.coordinadora.timgoo.qa:id/butSetWorkgroup"));
    private static final Target INGRESAR_NUMERO_DE_EQUIPO = Target.the("Clic ingresar numero de equipo").located(By.id("com.coordinadora.timgoo.qa:id/txtTeam"));
    private static final Target INGRESAR_MOVIL = Target.the("Ingresar la movil").located(By.id("com.coordinadora.timgoo.qa:id/etxtMobile"));
    private static final Target BOTON_REFRESH = Target.the("Validar boton refresh").located(By.id("com.coordinadora.timgoo.qa.EntregasModule:id/buttonRefresh"));
    private static final Target BOTON_MAS = Target.the("Validar boton Mas").located(By.id("com.coordinadora.timgoo.qa:id/nav_more"));
    private static final Target EXPANDIBLE_CARGA_TRABAJO_NO_AUTORIZADA = Target.the("Se utiliza para expandir el icono").located(By.id("com.coordinadora.timgoo.qa.EntregasModule:id/btnMore"));
    private static final Target TITULO_UNIDADES_ASIGNADAS_NO_AUTORIZADAS = Target.the("Validar titulo").located(By.xpath("//*[contains(@text,'Unidades asignadas')]"));
    private static final Target TITULO_INFORMACION_TECNICA = Target.the("Se utiliza para ingresar al menu de la informacion tecnica").locatedBy("//android.widget.LinearLayout[3]/android.widget.LinearLayout/android.widget.RelativeLayout/android.widget.TextView");
    private static final Target VALIDACION_ICONO_RECIBIR_EN_DROOP = Target.the("Se utiliza para visualizar la existencia del Icono Recibir en Droop").located(By.id("com.coordinadora.timgoo.qa:id/lnDroop"));
    private static final Target PLANB = Target.the("Se utiliza para ingresar a plan b").locatedBy("//android.widget.TextView[@text=\"Plan B recogidas\"]");
    private static final Target CARNETDIGITAL = Target.the("Se utiliza para ingresar al carnet digital").locatedBy("//android.widget.RelativeLayout[@resource-id=\"com.coordinadora.timgoo.qa:id/CardCarnetDigital\"]");
    private static final Target BOTONDESCARGARQR = Target.the("Se utiliza para descargar el QR del Carnet Digital").locatedBy("//android.widget.Button[@resource-id=\"com.coordinadora.timgoo.qa:id/btnDescargarQr\"]");
    private static final Target CERRARCARNETDIGITAL = Target.the("Se utiliza para ingresar al carnet digital").locatedBy("//android.widget.Button[@resource-id=\"com.coordinadora.timgoo.qa:id/btnCerrarCarnetDigital\"]");
    
    private static final Target MENU_HAMBUGUESA = Target.the("Boton para el menu hamburguesa").locatedBy("//android.widget.FrameLayout[@content-desc='Más']");
    private static final Target PUNTO_DROOP = Target.the("Boton para opcion puntos droop").located(By.id("com.coordinadora.timgoo.qa:id/lnDroop"));    

    /**
     * Ingresa un número de equipo de trabajo en el campo correspondiente.
     *
     * @param equipo El número de equipo a ingresar.
     * @return Una tarea que realiza la acción de ingresar el número de equipo.
     */

    public static Performable ingresarEquipoDeTrabajo(String equipo) {
        return Task.where("Ingresar un usuario",
                WaitUntil.the(INGRESAR_NUMERO_DE_EQUIPO, isVisible()),
                WaitUntil.the(INGRESAR_NUMERO_DE_EQUIPO, isClickable()),
                Enter.keyValues(equipo).into(INGRESAR_NUMERO_DE_EQUIPO));
    }

    /**
     * Ingresa un número de móvil en el campo correspondiente.
     *
     * @param movil El número de móvil a ingresar.
     * @return Una tarea que realiza la acción de ingresar el número de móvil.
     */
    public static Performable ingresarLaMovil(String movil) {
        return Task.where("Ingresar movil",
                WaitUntil.the(INGRESAR_MOVIL, isVisible()),
                WaitUntil.the(INGRESAR_MOVIL, isClickable()),
                Click.on(INGRESAR_MOVIL),
                Enter.keyValues(movil).into(INGRESAR_MOVIL));
    }
    public static Performable ingresarACarnetDigital() {
        return Task.where("Ingresar a la pantalla de equipo de trabajo",
                WaitUntil.the(CARNETDIGITAL, isVisible()),
                WaitUntil.the(CARNETDIGITAL, isClickable()),
                Click.on(CARNETDIGITAL));
    }
    public static Performable descargarCarnetDigital() {
        return Task.where("Ingresar a la pantalla de equipo de trabajo",
                WaitUntil.the(BOTONDESCARGARQR, isVisible()),
                WaitUntil.the(BOTONDESCARGARQR, isClickable()),
                Click.on(BOTONDESCARGARQR));
    }
    public static Performable cerrarCarnetDigital() {
        return Task.where("Ingresar a la pantalla de equipo de trabajo",
                WaitUntil.the(CERRARCARNETDIGITAL, isVisible()),
                WaitUntil.the(CERRARCARNETDIGITAL, isClickable()),
                Click.on(CERRARCARNETDIGITAL));
    }
    /**
     * Ingresa a la pantalla de equipo de trabajo.
     *
     * @return Una tarea que realiza la acción de ingresar a la pantalla de equipo de trabajo.
     */
    public static Performable ingresarAlaPantallaDeEquipoDeTrabajo() {
        return Task.where("Ingresar a la pantalla de equipo de trabajo",
                WaitUntil.the(CONECTARSE_A_UN_GRUPO_DE_TRABAJO, isVisible()),
                WaitUntil.the(CONECTARSE_A_UN_GRUPO_DE_TRABAJO, isClickable()),
                Click.on(CONECTARSE_A_UN_GRUPO_DE_TRABAJO));
    }

    /**
     * Ingresa a la pantalla de unidades no autorizadas.
     *
     * @return Una tarea que realiza la acción de ingresar a la pantalla de unidades no autorizadas.
     */
    public static Performable ingresarAlaPantalladeUnidadesNoAutorizadas() {
        return Task.where("Ingresar a la pantalla de unidades sin asignar",
                WaitUntil.the(TITULO_UNIDADES_ASIGNADAS_NO_AUTORIZADAS, isVisible()),
                WaitUntil.the(TITULO_UNIDADES_ASIGNADAS_NO_AUTORIZADAS, isClickable()),
                Click.on(TITULO_UNIDADES_ASIGNADAS_NO_AUTORIZADAS));
    }

    /**
     * Presiona el icono expandible de carga de trabajo no autorizada.
     *
     * @return Una tarea que realiza la acción de presionar el icono expandible.
     */
    public static Performable presionarIconoExpandible() {
        return Task.where("Presionar el icono de la carga de trabajo no autorizada",
                WaitUntil.the(EXPANDIBLE_CARGA_TRABAJO_NO_AUTORIZADA, isVisible()),
                WaitUntil.the(EXPANDIBLE_CARGA_TRABAJO_NO_AUTORIZADA, isClickable()),
                Click.on(EXPANDIBLE_CARGA_TRABAJO_NO_AUTORIZADA));
    }

    /**
     * Presiona el botón "Más" en la pantalla de perfil.
     *
     * @return Una tarea que realiza la acción de presionar el botón "Más".
     */
    public static Performable presionarBotonMas() {
        return Task.where("Presionar el Boton mas en la parte inferior de la pantalla perfil",
                WaitUntil.the(BOTON_MAS, isVisible()),
                WaitUntil.the(BOTON_MAS, isClickable()),
                Click.on(BOTON_MAS));
    }

    /**
     * Presiona el botón "Recibir en Droop".
     *
     * @return Una tarea que realiza la acción de presionar el botón "Recibir en Droop".
     */
    public static Performable presionarBotonRecibirEnDroop() {
        return Task.where("Presionar el Boton Recibir en Droop",
                WaitUntil.the(VALIDACION_ICONO_RECIBIR_EN_DROOP, isVisible()),
                WaitUntil.the(VALIDACION_ICONO_RECIBIR_EN_DROOP, isClickable()),
                Click.on(VALIDACION_ICONO_RECIBIR_EN_DROOP));
    }

    /**
     * Presiona el botón de actualización (refresh).
     *
     * @return Una tarea que realiza la acción de presionar el botón de actualización.
     */
    public static Performable presionarBotonRefresh() {
        return Task.where("Presionar el icono refresh de trabajo no autorizada",
                WaitUntil.the(BOTON_REFRESH, isClickable()),
                WaitUntil.the(BOTON_REFRESH, isVisible()),
                Click.on(BOTON_REFRESH));
    }

    /**
     * Presiona el botón de información técnica.
     *
     * @return Una tarea que realiza la acción de presionar el botón de información técnica.
     */
    public static Performable presionarBotonInformacionTecnica() {
        return Task.where("Acceder al menu de informacion tecnica",
                WaitUntil.the(TITULO_INFORMACION_TECNICA, isClickable()),
                WaitUntil.the(TITULO_INFORMACION_TECNICA, isVisible()),
                Click.on(TITULO_INFORMACION_TECNICA));
    }

    /**
     * Realiza un gesto de deslizamiento (swipe) en la pantalla.
     *
     * @param startX Coordenada X inicial del deslizamiento.
     * @param startY Coordenada Y inicial del deslizamiento.
     * @param endX   Coordenada X final del deslizamiento.
     * @param endY   Coordenada Y final del deslizamiento.
     */
    public static void swipe(int startX, int startY, int endX, int endY) {
        TouchAction touchAction = new TouchAction(driver);
        touchAction.press(PointOption.point(startX, startY))
                .waitAction(WaitOptions.waitOptions(Duration.ofMillis(2000)))
                .moveTo(PointOption.point(endX, endY))
                .release()
                .perform();
    }


    public static void mainhorizontal(String[] args) {
        // Configuración del controlador de Appium

        // Función que has proporcionado
        performSwipehorizontal();
    }
    public static void performSwipehorizontal() {
        var finger = new PointerInput(PointerInput.Kind.TOUCH, "finger");
        var start = new Point(1047, 2004);
        var end = new Point(12, 2004);
        var swipe = new Sequence(finger, 1);
        swipe.addAction(finger.createPointerMove(Duration.ofMillis(0),
                PointerInput.Origin.viewport(), start.getX(), start.getY()));
        swipe.addAction(finger.createPointerDown(PointerInput.MouseButton.LEFT.asArg()));
        swipe.addAction(finger.createPointerMove(Duration.ofMillis(1000),
                PointerInput.Origin.viewport(), end.getX(), end.getY()));
        swipe.addAction(finger.createPointerUp(PointerInput.MouseButton.LEFT.asArg()));

        // Ejecutar la secuencia de acciones en el controlador de Appium
        driver.perform(Arrays.asList(swipe));
    }

    public static void mainvertical(String[] args) {
        // Configuración del controlador de Appium

        // Función que has proporcionado
        performSwipevertical();
    }
    public static void performSwipevertical() {
        var finger = new PointerInput(PointerInput.Kind.TOUCH, "finger");
        var start = new Point(1043, 2000);
        var end = new Point (1039, 318);
        var swipe = new Sequence(finger, 1);
        swipe.addAction(finger.createPointerMove(Duration.ofMillis(0),
                PointerInput.Origin.viewport(), start.getX(), start.getY()));
        swipe.addAction(finger.createPointerDown(PointerInput.MouseButton.LEFT.asArg()));
        swipe.addAction(finger.createPointerMove(Duration.ofMillis(1000),
                PointerInput.Origin.viewport(), end.getX(), end.getY()));
        swipe.addAction(finger.createPointerUp(PointerInput.MouseButton.LEFT.asArg()));

        // Ejecutar la secuencia de acciones en el controlador de Appium
        driver.perform(Arrays.asList(swipe));

    }

    public static void seleccionDeUnItemEnCoordenadasEspecificas(int data1, int data2) {
        TouchAction touchAction = new TouchAction((PerformsTouchActions) AppiumDriver.driver);
        touchAction.tap(PointOption.point(data1, data2)).perform();
    }

    public static void click(int x, int y) {
        PointerInput finger = new PointerInput(PointerInput.Kind.TOUCH, "finger");

        Sequence click = new Sequence(finger, 1);
        click.addAction(finger.createPointerMove(Duration.ofMillis(0), PointerInput.Origin.viewport(), x, y));
        click.addAction(finger.createPointerDown(PointerInput.MouseButton.LEFT.asArg()));
        click.addAction(finger.createPointerUp(PointerInput.MouseButton.LEFT.asArg()));

        driver.perform(Arrays.asList(click));
    }

    public static void mainhorizontal1(String[] args) {
        // Configuración del controlador de Appium

        // Función que has proporcionado
        performClick();
    }

    public static void performClick() {
        int x = 462; // Coordenada x deseada
        int y = 1398; // Coordenada y deseada
        click(x, y);
    }



    public static Performable presionarplanb() {
        return Task.where("Acceder a la Opcion plan b",
                WaitUntil.the(PLANB, isClickable()),
                WaitUntil.the(PLANB, isVisible()),
                Click.on(PLANB));
    }

     public static Performable presionarMenuHamburguesa() {
        return Task.where("Acceder al menu hamburguesa",
                WaitUntil.the(MENU_HAMBUGUESA, isClickable()),
                WaitUntil.the(MENU_HAMBUGUESA, isVisible()),
                Click.on(MENU_HAMBUGUESA));
    }

      public static Performable presionarPuntosDroop() {
        return Task.where("Acceder a opcion Puntos Droop",
                WaitUntil.the(PUNTO_DROOP, isClickable()),
                WaitUntil.the(PUNTO_DROOP, isVisible()),
                Click.on(PUNTO_DROOP));
    }

    public static Performable presionarBotonPerfil() {
        return Task.where("Acceder a opcion Perfil",
                WaitUntil.the(INGRESAR_PANTALLA_PERFIL, isClickable()),
                WaitUntil.the(INGRESAR_PANTALLA_PERFIL, isVisible()),
                Click.on(INGRESAR_PANTALLA_PERFIL));
    }

    
}















