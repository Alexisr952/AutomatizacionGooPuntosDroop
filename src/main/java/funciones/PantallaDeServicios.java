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
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import net.serenitybdd.screenplay.Actor;
import static net.serenitybdd.screenplay.Tasks.instrumented;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.actions.EnterValue;


import static net.serenitybdd.screenplay.Tasks.instrumented;

/**
 * Esta clase contiene métodos y constantes relacionados con la interacción con la pantalla de servicios
 * de una aplicación móvil.
 */
public final class PantallaDeServicios {

    // Constructor privado para evitar instancias de la clase
    private PantallaDeServicios() {
    }

    // Constantes para los selectores de elementos de la interfaz de usuario
    private static final Target BOTON_SERVICIOS = Target.the("Boton abrir pantalla de servicios").located(By.id("com.coordinadora.timgoo.qa:id/nav_tasks"));
    private static final Target BOTON_BUSCAR_SERVICIOS = Target.the("Boton para activar el filtro de busqueda en la pantalla de servicios").located(By.id("com.coordinadora.timgoo.qa:id/search_button"));
    private static final Target BOTON_ENTREGA_MASIVA = Target.the("Se utiliza para realizar una entrega Masiva").located(By.id("com.coordinadora.timgoo.qa:id/massive_delivery_button"));
    private static final Target CHECKBOX_SELECCION_TODOS_SERVICIOS = Target.the("Se utiliza para agregar varios servicios para una entrega masiva").located(By.id("com.coordinadora.timgoo.qa.EntregasModule:id/checkBoxGlobal"));
    private static final Target BOTON_ACTIVAR_BUSCADOR_ENTREGAS_MASIVAS = Target.the("Se utiliza para activar el buscador de entregas masiva").located(By.id("com.coordinadora.timgoo.qa.EntregasModule:id/searchButton"));
    private static final Target CAMPO_BUSCAR_GUIA_ENTREGAS_MASIVAS = Target.the("Se utiliza para ingresar datos en el campo buscador de guia en entrega masiva").located(By.id("com.coordinadora.timgoo.qa.EntregasModule:id/txtSearchInput"));
    private static final Target BOTON_MAPA = Target.the("Se utiliza presionar el boton del mapa en la pantalla servicios").located(By.id("com.coordinadora.timgoo.qa:id/map_button"));
    private static final Target BOTON_REGRESAR_PANTALLA_SERVICIOS = Target.the("Se utiliza para presionar el boton ver servicios al finalizar una entrega efectiva").located(By.id("com.coordinadora.timgoo.qa.EntregasModule:id/btn_return"));
    private static final Target BOTON_UBICACION = Target.the("Se utiliza presionar el boton del mapa en la pantalla servicios").locatedBy("//android.view.View[@content-desc=\"Google Maps\"]/android.view.View");
    private static final Target BOTON_VER_MAS = Target.the("Se utiliza presionar el boton ver mas en el detalle de la guia en el mapa").locatedBy("//*[contains(@text,'VER MÁS')]");
    private static final Target BOTON_RETROCEDER_PANTALLA_SERVICIOS = Target.the("Boton regresar").located(By.id("com.coordinadora.timgoo.qa.EntregasModule:id/back_button"));
    private static final Target BOTON_REORDENAR = Target.the("Boton reordenar").located(By.id("android:id/title"));
    private static final Target BOTON_COMPARTIR = Target.the("Se utiliza para compartir el codigo qr").located(By.id("com.coordinadora.timgoo.qa.EntregasModule:id/btnShare"));
    private static final Target BOTON_PESTANA_PENDIENTES = Target.the("Boton pestaña pendientes").locatedBy("//android.widget.LinearLayout[@content-desc=\"Fallidas\"]/android.widget.TextView");
    private static final Target BOTON_LLAMAR_EN_MAPA = Target.the("Sirve para presionar el icono llamar del mapa").locatedBy("//*[contains(@text,'Llamar')]");
    private static final Target BOTON_FINALIZAR = Target.the("Sirve Para Presionar el Boton Finalizar").locatedBy("//*[contains(@text,'FINALIZAR')]");
    private static final Target BOTON_ATRAS_METODOS_PAGO = Target.the("Sirve Para Presionar el Boton Atras").locatedBy("//android.widget.LinearLayout/android.widget.ImageButton");
    private static final Target CAMPO_BUSCAR_SERVICIO = Target.the("Se utiliza para buscar servicios").located(By.id("com.coordinadora.timgoo.qa:id/txtSearchInput"));
    private static final Target GUIA_ESTANDAR = Target.the("Este mapeo sirve para presionar una guia sin nivel de servicio").locatedBy("(//android.widget.LinearLayout[@resource-id=\"com.coordinadora.timgoo.qa:id/linearLayout\"])[1]");
    private static final Target GUIA_RCE = Target.the("Esta mapeo sirve para presionar una guia con nivel de servicio RCE").locatedBy("//*[contains(@text,'RCE')]");
    private static final Target METODO_PAGO_WOMPI = Target.the("Seleccion metodo pago wompi").located(By.id("com.coordinadora.timgoo.qa.EntregasModule:id/linearWompi"));
    private static final Target METODO_PAGO_EFECTIVO = Target.the("Seleccion metodo pago efectivo").locatedBy("//*[contains(@text,'Efectivo')]");
    private static final Target METODO_PAGO_CREDITO_CONTRA_ENTREGA = Target.the("Seleccion metodo pago Credito ContraEntrega").located(By.id("com.coordinadora.timgoo.qa.EntregasModule:id/linearCredito"));

    private static final Target PRESIONARTARJETAFALLIDAS = Target.the("Presionar tarjeta en fallidas ").locatedBy("//android.widget.LinearLayout[@resource-id=\"com.coordinadora.timgoo.qa:id/task_delivery_layout\"])[1]/android.widget.LinearLayout");

    private static final Target PRESIONARREINTENTAR = Target.the("Presionar reintentar en la pantalla fallidas").locatedBy("//android.widget.TextView[@text=\"Reintentar\"]");




    /**
     * Presiona el botón para retroceder a la pantalla de servicios.
     *
     * @return Una tarea que realiza la acción de presionar el botón para retroceder.
     */
    public static Performable presionarRetrocederPantallaServicios() {
        return Task.where("Retroceder desde el modulo de la pantalla perfil hasta la pantalla servicios",
                WaitUntil.the(BOTON_RETROCEDER_PANTALLA_SERVICIOS, isVisible()),
                WaitUntil.the(BOTON_RETROCEDER_PANTALLA_SERVICIOS, isClickable()),
                Click.on(BOTON_RETROCEDER_PANTALLA_SERVICIOS));
    }

    /**
     * Activa el campo de búsqueda de servicios.
     *
     * @return Una tarea que realiza la acción de activar el campo de búsqueda.
     */
    public static Performable botonBusquedaDeServicios() {
        return Task.where("Activar el campo de buscar servicios",
                WaitUntil.the(BOTON_BUSCAR_SERVICIOS, isVisible()),
                WaitUntil.the(BOTON_BUSCAR_SERVICIOS, isClickable()),
                Click.on(BOTON_BUSCAR_SERVICIOS));
    }

    /**
     * Ingresa un número de guía en el buscador de servicios.
     *
     * @param numeroGuia El número de guía a ingresar.
     * @return Una tarea que realiza la acción de ingresar el número de guía.
     */
    public static Performable ingresarNumeroDeGuiaEnBuscadorDeServicios(String numeroGuia) {
        return Task.where("Ingresar numero de guia en el buscador de servicios",
                WaitUntil.the(CAMPO_BUSCAR_SERVICIO, isVisible()),
                WaitUntil.the(CAMPO_BUSCAR_SERVICIO, isClickable()),
                Click.on(CAMPO_BUSCAR_SERVICIO),
                Enter.keyValues(numeroGuia).into(CAMPO_BUSCAR_SERVICIO));
    }

    /**
     * Presiona el botón para regresar a la pantalla de servicios.
     *
     * @return Una tarea que realiza la acción de presionar el botón para regresar.
     */
    public static Performable presionarBotonVerServicios() {
        return Task.where("Presionar ver servicios",
                WaitUntil.the(BOTON_REGRESAR_PANTALLA_SERVICIOS, isVisible()),
                WaitUntil.the(BOTON_REGRESAR_PANTALLA_SERVICIOS, isClickable()),
                Click.on(BOTON_REGRESAR_PANTALLA_SERVICIOS));
    }

    /**
     * Ingresa al apartado de entregas masivas.
     *
     * @return Una tarea que realiza la acción de ingresar al apartado de entregas masivas.
     */
    public static Performable botonIngresoAlaPantallaEntregasMasivas() {
        return Task.where("Ingresar al apartado de masivas",
                WaitUntil.the(BOTON_ENTREGA_MASIVA, isVisible()),
                WaitUntil.the(BOTON_ENTREGA_MASIVA, isClickable()),
                Click.on(BOTON_ENTREGA_MASIVA));
    }

    /**
     * Ingresa un número de guía en el campo de búsqueda de la pantalla de entregas masivas.
     *
     * @param guia El número de guía a ingresar.
     * @return Una tarea que realiza la acción de ingresar el número de guía.
     */
    public static Performable campoBuscarGuiaEnLaPantallaMasivas(String guia) {
        return Task.where("Ingresar caracteres en el campo Buscar guia de la entrega masiva",
                WaitUntil.the(CAMPO_BUSCAR_GUIA_ENTREGAS_MASIVAS, isClickable()),
                WaitUntil.the(CAMPO_BUSCAR_GUIA_ENTREGAS_MASIVAS, isVisible()),
                Click.on(CAMPO_BUSCAR_GUIA_ENTREGAS_MASIVAS),
                Enter.keyValues(guia).into(CAMPO_BUSCAR_GUIA_ENTREGAS_MASIVAS));
    }

    /**
     * Activa el buscador en el apartado de entregas masivas.
     *
     * @return Una tarea que realiza la acción de activar el buscador.
     */
    public static Performable botonLupaEnElApartadoDeMasivas() {
        return Task.where("Activar el buscador en la pantalla de masivas",
                WaitUntil.the(BOTON_ACTIVAR_BUSCADOR_ENTREGAS_MASIVAS, isVisible()),
                WaitUntil.the(BOTON_ACTIVAR_BUSCADOR_ENTREGAS_MASIVAS, isClickable()),
                Click.on(BOTON_ACTIVAR_BUSCADOR_ENTREGAS_MASIVAS));
    }

    /**
     * Selecciona todas las guías en la pantalla de entregas masivas.
     *
     * @return Una tarea que realiza la acción de seleccionar todas las guías.
     */
    public static Performable seleccionarTodasLasGuias() {
        return Task.where("Seleccionar todas las guias en la pantalla de masivas",
                WaitUntil.the(CHECKBOX_SELECCION_TODOS_SERVICIOS, isVisible()),
                WaitUntil.the(CHECKBOX_SELECCION_TODOS_SERVICIOS, isClickable()),
                Click.on(CHECKBOX_SELECCION_TODOS_SERVICIOS));
    }

    /**
     * Presiona una guía estándar.
     *
     * @return Una tarea que realiza la acción de presionar una guía estándar.
     */
    public static Performable presionarGuiaEstandar() {
        return Task.where("Seleccionar una guia Estandar",
                WaitUntil.the(GUIA_ESTANDAR, isVisible()),
                WaitUntil.the(GUIA_ESTANDAR, isClickable()),
                Click.on(GUIA_ESTANDAR));
    }

    /**
     * Presiona una guía RCE (Recaudo Contra Entrega).
     *
     * @return Una tarea que realiza la acción de presionar una guía RCE.
     */
    public static Performable presionarGuiaRCE() {
        return Task.where("Seleccionar una guia recaudo contra entrega",
                WaitUntil.the(GUIA_RCE, isVisible()),
                WaitUntil.the(GUIA_RCE, isClickable()),
                Click.on(GUIA_RCE));
    }

    /**
     * Presiona el botón de finalizar.
     *
     * @return Una tarea que realiza la acción de presionar el botón de finalizar.
     */
    public static Performable presionarBotonFinalizar() {
        return Task.where("Presionar boton finalizar",
                WaitUntil.the(BOTON_FINALIZAR, isVisible()),
                WaitUntil.the(BOTON_FINALIZAR, isClickable()),
                Click.on(BOTON_FINALIZAR));
    }

    /**
     * Ingresa a la pantalla de servicios.
     *
     * @return Una tarea que realiza la acción de ingresar a la pantalla de servicios.
     */
    public static Performable ingresoAlaPantallaDeServicios() {
        return Task.where("Ingresar a la pantalla de servicios",
                WaitUntil.the(BOTON_SERVICIOS, isVisible()),
                WaitUntil.the(BOTON_SERVICIOS, isClickable()),
                Click.on(BOTON_SERVICIOS));
    }

    /**
     * Presiona el botón del mapa en la pantalla de servicios.
     *
     * @return Una tarea que realiza la acción de presionar el botón del mapa.
     */
    public static Performable presionarBotonMapa() {
        return Task.where("Presionar el boton del mapa",
                WaitUntil.the(BOTON_MAPA, isVisible()),
                WaitUntil.the(BOTON_MAPA, isClickable()),
                Click.on(BOTON_MAPA));
    }


    /**
     * Presiona el icono para realizar una llamada desde el mapa.
     *
     * @return Una tarea que realiza la acción de presionar el icono de llamada.
     */
    public static Performable presionarIconoLlamarEnElMapa() {
        return Task.where("Realizar la llamada desde el mapa",
                WaitUntil.the(BOTON_LLAMAR_EN_MAPA, isVisible()),
                WaitUntil.the(BOTON_LLAMAR_EN_MAPA, isClickable()),
                Click.on(BOTON_LLAMAR_EN_MAPA));
    }

    /**
     * Presiona la ubicación del servicio en el mapa.
     *
     * @return Una tarea que realiza la acción de presionar la ubicación del servicio.
     */
    public static Performable presionarUbicacionDelServicio() {
        return Task.where("Presionar la ubicacion del servicio en el mapa",
                WaitUntil.the(BOTON_UBICACION, isVisible()),
                WaitUntil.the(BOTON_UBICACION, isClickable()),
                Click.on(BOTON_UBICACION));
    }

    /**
     * Presiona el botón "Ver Más" en el detalle de la guía en el mapa.
     *
     * @return Una tarea que realiza la acción de presionar el botón "Ver Más".
     */
    public static Performable presionarBotonVerMas() {
        return Task.where("Presionar el boton ver mas en el detalle de la guia en el mapa",
                WaitUntil.the(BOTON_VER_MAS, isVisible()),
                WaitUntil.the(BOTON_VER_MAS, isClickable()),
                Click.on(BOTON_VER_MAS));
    }

    /**
     * Presiona la pestaña de servicios fallidos/pendientes.
     *
     * @return Una tarea que realiza la acción de presionar la pestaña de servicios fallidos/pendientes.
     */
    public static Performable presionarPestanaFallida() {
        return Task.where("Presionar la pestaña de servicios fallidos/pendientes",
                WaitUntil.the(BOTON_PESTANA_PENDIENTES, isVisible()),
                WaitUntil.the(BOTON_PESTANA_PENDIENTES, isClickable()),
                Click.on(BOTON_PESTANA_PENDIENTES));
    }

    /**
     * Presiona el botón de reordenar.
     *
     * @return Una tarea que realiza la acción de presionar el botón de reordenar.
     */
    public static Performable presionarBotonReordenar() {
        return Task.where("Presionar la opcion de reordenar",
                WaitUntil.the(BOTON_REORDENAR, isVisible()),
                WaitUntil.the(BOTON_REORDENAR, isClickable()),
                Click.on(BOTON_REORDENAR));
    }

    /**
     * Presiona el método de pago Wompi.
     *
     * @return Una tarea que realiza la acción de presionar el método de pago Wompi.
     */
    public static Performable presionarMetodoDePagoWompi() {
        return Task.where("Seleccionar el metodo de pago wompi",
                WaitUntil.the(METODO_PAGO_WOMPI, isVisible()),
                WaitUntil.the(METODO_PAGO_WOMPI, isClickable()),
                Click.on(METODO_PAGO_WOMPI));
    }

    /**
     * Presiona el método de pago en efectivo.
     *
     * @return Una tarea que realiza la acción de presionar el método de pago en efectivo.
     */
    public static Performable metodoDePagoEfectivo() {
        return Task.where("Seleccionar el metodo de pago Efectivo",
                WaitUntil.the(METODO_PAGO_EFECTIVO, isVisible()),
                WaitUntil.the(METODO_PAGO_EFECTIVO, isClickable()),
                Click.on(METODO_PAGO_EFECTIVO));
    }

    /**
     * Presiona el método de pago crédito contra entrega.
     *
     * @return Una tarea que realiza la acción de presionar el método de pago crédito contra entrega.
     */
    public static Performable metodoDePagoCreditoContraentrega() {
        return Task.where("Seleccionar el metodo de pago Credito ContraEntrega",
                WaitUntil.the(METODO_PAGO_CREDITO_CONTRA_ENTREGA, isVisible()),
                WaitUntil.the(METODO_PAGO_CREDITO_CONTRA_ENTREGA, isClickable()),
                Click.on(METODO_PAGO_CREDITO_CONTRA_ENTREGA));
    }

    /**
     * Presiona el botón "Atrás" en la pantalla de métodos de pago.
     *
     * @return Una tarea que realiza la acción de presionar el botón "Atrás".
     */
    public static Performable botonAtrasEnMetodosDePago() {
        return Task.where("Presionar el boton atras en la pantalla metodo de pago",
                WaitUntil.the(BOTON_ATRAS_METODOS_PAGO, isVisible()),
                WaitUntil.the(BOTON_ATRAS_METODOS_PAGO, isClickable()),
                Click.on(BOTON_ATRAS_METODOS_PAGO));
    }

    /**
     * Presiona el botón para compartir el código QR.
     *
     * @return Una tarea que realiza la acción de presionar el botón de compartir.
     */
    public static Performable presionarBotonCompartir() {
        return Task.where("Presionar el boton compartir en la pantalla de wompi",
                WaitUntil.the(BOTON_COMPARTIR, isVisible()),
                WaitUntil.the(BOTON_COMPARTIR, isClickable()),
                Click.on(BOTON_COMPARTIR));
    }

    public static Performable presionartarjetafallidas() {
        return Task.where("Presionar el boton compartir en la pantalla de wompi",
                WaitUntil.the(PRESIONARTARJETAFALLIDAS, isVisible()),
                WaitUntil.the(PRESIONARTARJETAFALLIDAS, isClickable()),
                Click.on(PRESIONARTARJETAFALLIDAS));
    }

    public static Performable presionarreintentar() {
        return Task.where("Presionar el boton compartir en la pantalla de wompi",
                WaitUntil.the(PRESIONARREINTENTAR, isVisible()),
                WaitUntil.the(PRESIONARREINTENTAR, isClickable()),
                Click.on(PRESIONARREINTENTAR));
    }



    public static class SimulateBarcodeScan implements Task {

        private final String barcodeValue;

        // Constructor que recibe el valor del código de barras
        public SimulateBarcodeScan(String barcodeValue) {
            this.barcodeValue = barcodeValue;
        }

        // Método para inicializar la tarea
        public SimulateBarcodeScan with(String barcodeValue) {
            return new SimulateBarcodeScan(barcodeValue);
        }

        @Override
        public <T extends Actor> void performAs(T actor) {
            actor.attemptsTo(
                    Enter.theValue(barcodeValue).into(
                            By.xpath("//androidx.recyclerview.widget.RecyclerView[@resource-id=\"com.coordinadora.timgoo.qa:id/recyclerView\"]//android.widget.EditText")
                    )
            );
        }
    }



}