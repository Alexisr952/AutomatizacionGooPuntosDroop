package funciones;

import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isClickable;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;

import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Clear;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.targets.Target;
import net.serenitybdd.screenplay.waits.WaitUntil;

import org.openqa.selenium.By;

public class PantallaFPinternacional {

    private PantallaFPinternacional() {
        // Constructor privado para evitar instancias de la clase
        // Puedes dejarlo vacío o lanzar una excepción si deseas
    }
    //***********************************************************************************************************************
//android.widget.Button[@resource-id="com.coordinadora.timv2.debug:id/btn_ok"]

    public static final Target BotonAceptar = Target.the("se utiliza para agregar correo electronico").locatedBy("//android.widget.Button[@resource-id=\"com.coordinadora.timv2.debug:id/btn_ok\"]");
    public static final Target Recogida = Target.the("se utiliza para agregar correo electronico").locatedBy("(//android.widget.ImageView[@resource-id=\"com.coordinadora.timgoo.qa:id/icon\"])[2]");

    public static final Target CrearRecogida = Target.the("se utiliza para pagar con tarjetasz").locatedBy("//android.widget.Button[@resource-id=\"com.coordinadora.timv2.debug:id/btCrear\"]");

    public static final Target Nit = Target.the("se utiliza para pagar con tarjetasy").locatedBy("//android.widget.ListView[@resource-id=\"com.coordinadora.timv2.debug:id/RecOpListView\"]/android.widget.RelativeLayout[1]");

    public static final Target Copiartexto= Target.the("se utiliza para pagar con tarjetasx").locatedBy("//android.widget.EditText[@resource-id=\"com.coordinadora.timv2.debug:id/texto\"]");

    public static final Target Empresa = Target.the("se utiliza para pagar con tarjetasx").locatedBy("//android.widget.ListView[@resource-id=\"com.coordinadora.timv2.debug:id/RecOpListView\"]/android.widget.RelativeLayout[2]");

    public static final Target Direccion = Target.the("se utiliza para pagar con tarjetasx").locatedBy("//android.widget.ListView[@resource-id=\"com.coordinadora.timv2.debug:id/RecOpListView\"]/android.widget.RelativeLayout[3]");

    public static final Target Telefono = Target.the("se utiliza para pagar con tarjetasx").locatedBy("//android.widget.ListView[@resource-id=\"com.coordinadora.timv2.debug:id/RecOpListView\"]/android.widget.RelativeLayout[4]");

    public static final Target EnviarRecogida = Target.the("se utiliza para pagar con tarjetasx").locatedBy("//android.widget.Button[@resource-id=\"com.coordinadora.timv2.debug:id/recOpbtEnviar\"]");

    public static final Target SeleccionarRecogida = Target.the("se utiliza para pagar con tarjetasx").locatedBy("//android.widget.RelativeLayout");

    public static final Target LiquidarGuias = Target.the("se utiliza para pagar con tarjetasx").locatedBy("//android.widget.ListView[@resource-id=\"com.coordinadora.timv2.debug:id/listView\"]/android.widget.RelativeLayout[5]");

    public static final Target NuevasGuias = Target.the("se utiliza para pagar con tarjetasx").locatedBy("//android.widget.Button[@resource-id=\"com.coordinadora.timv2.debug:id/btNuevaGuia\"]");


    public static final Target GuiasInternacionales = Target.the("se utiliza para pagar con tarjetasx").locatedBy("//android.widget.ListView[@resource-id=\"com.coordinadora.timv2.debug:id/listViewGeneric\"]/android.widget.RelativeLayout[2]");

    public static final Target GuiasNacionales = Target.the("se utiliza para pagar con tarjetasx").locatedBy("//android.widget.ListView[@resource-id=\"com.coordinadora.timv2.debug:id/listViewGeneric\"]/android.widget.RelativeLayout[1]");

    public static final Target Producto = Target.the("se utiliza para pagar con tarjetasx").locatedBy("//android.widget.ListView[@resource-id=\"com.coordinadora.timv2.debug:id/campos_guias_list_view\"]/android.widget.RelativeLayout[1]");

    public static final Target Paquete = Target.the("se utiliza para pagar con tarjetasx").locatedBy("//android.widget.ListView[@resource-id=\"com.coordinadora.timv2.debug:id/listViewGeneric\"]/android.widget.RelativeLayout[2]");

    public static final Target TipoFlete = Target.the("se utiliza para pagar con tarjetasx").locatedBy("//android.widget.ListView[@resource-id=\"com.coordinadora.timv2.debug:id/campos_guias_list_view\"]/android.widget.RelativeLayout[2]");

    public static final Target TipoFlet = Target.the("se utiliza para pagar con tarjetasx").locatedBy("//android.widget.ListView[@resource-id=\"com.coordinadora.timv2.debug:id/campos_guias_list_view\"]/android.widget.RelativeLayout[1]");
    public static final Target FP = Target.the("se utiliza para pagar con tarjetasx").locatedBy("//android.widget.RelativeLayout");

    public static final Target FP2 = Target.the("se utiliza para pagar con tarjetasx").locatedBy("//android.widget.ListView[@resource-id=\"com.coordinadora.timv2.debug:id/listViewGeneric\"]/android.widget.RelativeLayout[2]");

    public static final Target FCE = Target.the("se utiliza para pagar con tarjetasx").locatedBy("//android.widget.ListView[@resource-id=\"com.coordinadora.timv2.debug:id/listViewGeneric\"]/android.widget.RelativeLayout[1]");
    public static final Target NitDestinatario = Target.the("se utiliza para pagar con tarjetasx").locatedBy("//android.widget.ListView[@resource-id=\"com.coordinadora.timv2.debug:id/campos_guias_list_view\"]/android.widget.RelativeLayout[9]");

    public static final Target NombreDestinatario = Target.the("se utiliza para pagar con tarjetasx").locatedBy("//android.widget.ListView[@resource-id=\"com.coordinadora.timv2.debug:id/campos_guias_list_view\"]/android.widget.RelativeLayout[10]");

    public static final Target DireccionDestinatario = Target.the("se utiliza para pagar con tarjetasx").locatedBy("//android.widget.ListView[@resource-id=\"com.coordinadora.timv2.debug:id/campos_guias_list_view\"]/android.widget.RelativeLayout[11]");


    public static final Target TelefonoDestinatario = Target.the("se utiliza para pagar con tarjetasx").locatedBy("//android.widget.TextView[@resource-id=\"com.coordinadora.timv2.debug:id/txtTitle\" and @text=\" Telefono Destinatario:\"]");


    public static final Target CiudadOrigen = Target.the("se utiliza para pagar con tarjetasx").locatedBy("//android.widget.TextView[@resource-id=\"com.coordinadora.timv2.debug:id/txtTitle\" and @text=\" *Ciudad Origen:\"]");

    public static final Target CopiarAutocompletar = Target.the("se utiliza para pagar con tarjetasx").locatedBy("//android.widget.AutoCompleteTextView[@resource-id=\"com.coordinadora.timv2.debug:id/autocomplete\"]");


    public static final Target PaisDestino= Target.the("se utiliza para pagar con tarjetasx").locatedBy("//android.widget.TextView[@resource-id=\"com.coordinadora.timv2.debug:id/txtTitle\" and @text=\" *Pais Destino:\"]");



    public static final Target CiudadDestino= Target.the("se utiliza").locatedBy("//android.widget.TextView[@resource-id=\"com.coordinadora.timv2.debug:id/txtTitle\" and @text=\" *Ciudad Destino:\"]");


    public static final Target CodigoPostal= Target.the("se utiliza").locatedBy("//android.widget.TextView[@resource-id=\"com.coordinadora.timv2.debug:id/txtTitle\" and @text=\" *Codigo Postal:\"]");

    public static final Target Unidades= Target.the("se utiliza").locatedBy("//android.widget.TextView[@resource-id=\"com.coordinadora.timv2.debug:id/txtTitle\" and @text=\" *Unidades...:\"]");

    public static final Target AdicionarUnidades= Target.the("se utiliza").locatedBy("//android.widget.Button[@resource-id=\"com.coordinadora.timv2.debug:id/btNuevaUnidad\"]");

    public static final Target ValorDeclarado= Target.the("se utiliza").locatedBy("//android.widget.TextView[@resource-id=\"com.coordinadora.timv2.debug:id/txtTitle\" and @text=\" Vr Declarado Aduana:\"]");

    public static final Target Valoracion= Target.the("se utiliza").locatedBy("//android.widget.TextView[@resource-id=\"com.coordinadora.timv2.debug:id/txtTitle\" and @text=\" *Valoracion:\"]");


    public static final Target Empleado= Target.the("se utiliza").locatedBy("//android.widget.TextView[@resource-id=\"com.coordinadora.timv2.debug:id/txtTitle\" and @text=\" Empleado...:\"]");

    public static final Target SeleccionarEmpleado= Target.the("se utiliza").locatedBy("//android.widget.TextView[@resource-id=\"com.coordinadora.timv2.debug:id/txtValue\"]");

    public static final Target Contenido= Target.the("se utiliza").locatedBy("//android.widget.TextView[@resource-id=\"com.coordinadora.timv2.debug:id/txtTitle\" and @text=\" Contenido:\"]");


    public static final Target Liquidarguia= Target.the("se utiliza").locatedBy("//android.widget.Button[@resource-id=\"com.coordinadora.timv2.debug:id/btLiquidarGuia\"]");


    public static final Target Cerrar= Target.the("se utiliza").locatedBy("//android.widget.Button[@resource-id=\"com.coordinadora.timv2.debug:id/valores_liq__btn_ok\"]");

    public static final Target Facturar= Target.the("se utiliza para presionar el boton facturar").locatedBy("//android.widget.ListView[@resource-id=\"com.coordinadora.timv2.debug:id/listView\"]/android.widget.RelativeLayout[6]");

    public static final Target PendientedePago = Target.the("se utiliza para presionar el boton facturar").locatedBy("//android.widget.ListView[@resource-id=\"com.coordinadora.timv2.debug:id/facturar_guias_list_view\"]/android.widget.RelativeLayout[3]");

    public static final Target EnviarPago = Target.the("se utiliza para presionar el boton facturar").locatedBy("//android.widget.Button[@resource-id=\"com.coordinadora.timv2.debug:id/enviar_pago\"]");


    public static final Target Aplazar = Target.the("se utiliza para presionar el boton Aplazar en la pantalla detalle de recogida").locatedBy("//android.widget.ListView[@resource-id=\"com.coordinadora.timv2.debug:id/listView\"]/android.widget.RelativeLayout[1]");

    public static final Target BotonAceptarResultado = Target.the("se utiliza para presionar el aceptar resultado").locatedBy("//android.widget.Button[@resource-id=\"com.coordinadora.timv2.debug:id/alert_btn_yes\"]");


    public static final Target Cancelar = Target.the("se utiliza para presionar el boton cancelar en la pantalla detalle de recogida").locatedBy("//android.widget.ListView[@resource-id=\"com.coordinadora.timv2.debug:id/listView\"]/android.widget.RelativeLayout[2]");


    //***********************************************************************************************************************


    public static Performable presionarrecogida() {
        return
                Task.where("se utiliza para presionar el Boton mas que se encuentra en la parte inferior",
                        WaitUntil.the(Recogida, isVisible()),
                        WaitUntil.the(Recogida, isClickable()),
                        Click.on(Recogida));

    }
    public static Performable PresionarCrearRecogida() {
        return
                Task.where("se utiliza para presionar el Boton mas que se encuentra en la parte inferior",
                        WaitUntil.the(CrearRecogida, isVisible()),
                        WaitUntil.the(CrearRecogida, isClickable()),
                        Click.on(CrearRecogida).afterWaitingUntilEnabled());

    }
    public static Performable PresionarNit() {
        return
                Task.where("se utiliza para presionar el Boton mas que se encuentra en la parte inferior",
                        WaitUntil.the(Nit, isVisible()),
                        WaitUntil.the(Nit, isClickable()),
                        Click.on(Nit).afterWaitingUntilEnabled());

    }

    public static Performable PresionarEmpresa() {
        return
                Task.where("se utiliza para presionar el Boton mas que se encuentra en la parte inferior",
                        WaitUntil.the(Empresa, isVisible()),
                        WaitUntil.the(Empresa, isClickable()),
                        Click.on(Empresa).afterWaitingUntilEnabled());

    }

    public static Performable PresionarDireccion() {
        return
                Task.where("se utiliza para presionar el Boton mas que se encuentra en la parte inferior",
                        WaitUntil.the(Direccion, isVisible()),
                        WaitUntil.the(Direccion, isClickable()),
                        Click.on(Direccion).afterWaitingUntilEnabled());

    }

    public static Performable PresionarTelefono() {
        return
                Task.where("se utiliza para presionar el Boton mas que se encuentra en la parte inferior",
                        WaitUntil.the(Telefono, isVisible()),
                        WaitUntil.the(Telefono, isClickable()),
                        Click.on(Telefono).afterWaitingUntilEnabled());

    }

     public static Performable CopiarTexto(String nit) {
        return
                Task.where("se utiliza para presionar el Boton mas que se encuentra en la parte inferior",
                        WaitUntil.the(Copiartexto, isVisible()),
                        WaitUntil.the(Copiartexto, isClickable()),
                        Click.on(Copiartexto).afterWaitingUntilEnabled(),
                        Clear.field(Copiartexto),
                        Enter.keyValues(nit).into(Copiartexto));


    }

    public static Performable PresionarBotonAceptar() {
        return
                Task.where("se utiliza para presionar el Boton mas que se encuentra en la parte inferior",
                        WaitUntil.the(BotonAceptar, isVisible()),
                        WaitUntil.the(BotonAceptar, isClickable()),
                        Click.on(BotonAceptar).afterWaitingUntilEnabled());
    }

    public static Performable PresionarEnviarRecogida() {
        return
                Task.where("se utiliza para presionar el Boton mas que se encuentra en la parte inferior",
                        WaitUntil.the(EnviarRecogida, isVisible()),
                        WaitUntil.the(EnviarRecogida, isClickable()),
                        Click.on(EnviarRecogida).afterWaitingUntilEnabled());
    }

    public static Performable PresionarSeleccionarRecogida() {
        return
                Task.where("se utiliza para presionar el Boton mas que se encuentra en la parte inferior",
                        WaitUntil.the(SeleccionarRecogida, isVisible()),
                        WaitUntil.the(SeleccionarRecogida, isClickable()),
                        Click.on(SeleccionarRecogida).afterWaitingUntilEnabled());
    }

    public static Performable PresionarLiquidarGuias() {
        return
                Task.where("se utiliza para presionar el Boton mas que se encuentra en la parte inferior",
                        WaitUntil.the(LiquidarGuias, isVisible()),
                        WaitUntil.the(LiquidarGuias, isClickable()),
                        Click.on(LiquidarGuias).afterWaitingUntilEnabled());
    }

    public static Performable PresionarNuevasGuias() {
        return
                Task.where("se utiliza para presionar el Boton mas que se encuentra en la parte inferior",
                        WaitUntil.the(NuevasGuias, isVisible()),
                        WaitUntil.the(NuevasGuias, isClickable()),
                        Click.on(NuevasGuias).afterWaitingUntilEnabled());
    }

    public static Performable PresionarGuiasInternacionales() {
        return
                Task.where("se utiliza para presionar el Boton mas que se encuentra en la parte inferior",
                        WaitUntil.the(GuiasInternacionales, isVisible()),
                        WaitUntil.the(GuiasInternacionales, isClickable()),
                        Click.on(GuiasInternacionales).afterWaitingUntilEnabled());
    }

    public static Performable PresionarGuiasNacionales() {
        return
                Task.where("se utiliza para presionar el Boton mas que se encuentra en la parte inferior",
                        WaitUntil.the(GuiasNacionales, isVisible()),
                        WaitUntil.the(GuiasNacionales, isClickable()),
                        Click.on(GuiasNacionales).afterWaitingUntilEnabled());
    }

    public static Performable PresionarProducto() {
        return
                Task.where("se utiliza para presionar el Boton mas que se encuentra en la parte inferior",
                        WaitUntil.the(Producto, isVisible()),
                        WaitUntil.the(Producto, isClickable()),
                        Click.on(Producto).afterWaitingUntilEnabled());
    }

    public static Performable PresionarPaquete() {
        return
                Task.where("se utiliza para presionar el Boton mas que se encuentra en la parte inferior",
                        WaitUntil.the(Paquete, isVisible()),
                        WaitUntil.the(Paquete, isClickable()),
                        Click.on(Paquete).afterWaitingUntilEnabled());
    }

    public static Performable PresionarTipoFlete() {
        return
                Task.where("se utiliza para presionar el Boton mas que se encuentra en la parte inferior",
                        WaitUntil.the(TipoFlete, isVisible()),
                        WaitUntil.the(TipoFlete, isClickable()),
                        Click.on(TipoFlete).afterWaitingUntilEnabled());
    }

    public static Performable PresionarFCE() {
        return
                Task.where("se utiliza para presionar el Boton mas que se encuentra en la parte inferior",
                        WaitUntil.the(FCE, isVisible()),
                        WaitUntil.the(FCE, isClickable()),
                        Click.on(FCE).afterWaitingUntilEnabled());
    }

    public static Performable PresionarFP() {
        return
                Task.where("se utiliza para presionar el Boton mas que se encuentra en la parte inferior",
                        WaitUntil.the(FP, isVisible()),
                        WaitUntil.the(FP, isClickable()),
                        Click.on(FP).afterWaitingUntilEnabled());
    }

    public static Performable PresionarFP2() {
        return
                Task.where("se utiliza para presionar el Boton mas que se encuentra en la parte inferior",
                        WaitUntil.the(FP2, isVisible()),
                        WaitUntil.the(FP2, isClickable()),
                        Click.on(FP2).afterWaitingUntilEnabled());
    }

    public static Performable PresionarDestinatario() {
        return
                Task.where("se utiliza para presionar el Boton mas que se encuentra en la parte inferior",
                        WaitUntil.the(NitDestinatario, isVisible()),
                        WaitUntil.the(NitDestinatario, isClickable()),
                        Click.on(NitDestinatario).afterWaitingUntilEnabled());
    }

    public static Performable PresionarNombreDestinatario() {
        return
                Task.where("se utiliza para presionar el Boton mas que se encuentra en la parte inferior",
                        WaitUntil.the(NombreDestinatario, isVisible()),
                        WaitUntil.the(NombreDestinatario, isClickable()),
                        Click.on(NombreDestinatario).afterWaitingUntilEnabled());
    }

    public static Performable PresionarDireccionDestinatario() {
        return
                Task.where("se utiliza para presionar el Boton mas que se encuentra en la parte inferior",
                        WaitUntil.the(DireccionDestinatario, isClickable()), //isVisible()),
                        WaitUntil.the(DireccionDestinatario, isClickable()), //get,
                        Click.on(DireccionDestinatario).afterWaitingUntilEnabled());
    }

    public static Performable PresionarTelefonoDestinatario() {
        return
                Task.where("se utiliza para presionar el Boton mas que se encuentra en la parte inferior",
                        WaitUntil.the(TelefonoDestinatario, isClickable()), //isVisible()),
                        WaitUntil.the(TelefonoDestinatario, isClickable()), //get,
                        Click.on(TelefonoDestinatario).afterWaitingUntilEnabled());
    }

    public static Performable PresionarCiudadOrigen() {
        return
                Task.where("se utiliza para presionar el Boton mas que se encuentra en la parte inferior",
                        WaitUntil.the(CiudadOrigen, isClickable()), //isVisible()),
                        WaitUntil.the(CiudadOrigen, isClickable()), //get,
                        Click.on(CiudadOrigen).afterWaitingUntilEnabled());
    }

    public static Performable CopiarAutocompletar(String ciudad) {
        return
                Task.where("se utiliza para presionar el Boton mas que se encuentra en la parte inferior",
                        WaitUntil.the(CopiarAutocompletar, isClickable()),
                        WaitUntil.the(CopiarAutocompletar, isClickable()),
                        Click.on(CopiarAutocompletar).afterWaitingUntilEnabled(),
                        Enter.keyValues(ciudad).into(CopiarAutocompletar));

    }


    public static Performable PresionarPaisDestino() {
        return
                Task.where("se utiliza para presionar el Boton mas que se encuentra en la parte inferior",
                        WaitUntil.the(PaisDestino, isClickable()), //isVisible()),
                        WaitUntil.the(PaisDestino, isClickable()), //get,
                        Click.on(PaisDestino).afterWaitingUntilEnabled());
    }

    public static Performable PresionarCiudadDestino() {
        return
                Task.where("se utiliza para presionar el Boton mas que se encuentra en la parte inferior",
                        WaitUntil.the(CiudadDestino, isClickable()), //isVisible()),
                        WaitUntil.the(CiudadDestino, isClickable()), //get,
                        Click.on(CiudadDestino).afterWaitingUntilEnabled());
    }

    public static Performable PresionarCodigoPostal() {
        return
                Task.where("se utiliza para presionar el Boton mas que se encuentra en la parte inferior",
                        WaitUntil.the(CodigoPostal, isClickable()), //isVisible()),
                        WaitUntil.the(CodigoPostal, isClickable()), //get,
                        Click.on(CodigoPostal).afterWaitingUntilEnabled());
    }

    public static Performable PresionarUnidades() {
        return
                Task.where("se utiliza para presionar el Boton mas que se encuentra en la parte inferior",
                        WaitUntil.the(Unidades, isClickable()), //isVisible()),
                        WaitUntil.the(Unidades, isClickable()), //get,
                        Click.on(Unidades).afterWaitingUntilEnabled());
    }

    public static Performable PresionarAdicionarUnidades() {
        return
                Task.where("se utiliza para presionar el Boton mas que se encuentra en la parte inferior",
                        WaitUntil.the(AdicionarUnidades, isClickable()), //isVisible()),
                        WaitUntil.the(AdicionarUnidades, isClickable()), //get,
                        Click.on(AdicionarUnidades).afterWaitingUntilEnabled());
    }

    public static Performable PresionarValorDeclarado() {
        return
                Task.where("se utiliza para presionar el Boton mas que se encuentra en la parte inferior",
                        WaitUntil.the(ValorDeclarado, isClickable()), //isVisible()),
                        WaitUntil.the(ValorDeclarado, isClickable()), //get,
                        Click.on(ValorDeclarado).afterWaitingUntilEnabled());
    }

    public static Performable PresionarValoracion() {
        return
                Task.where("se utiliza para presionar el Boton mas que se encuentra en la parte inferior",
                        WaitUntil.the(Valoracion, isClickable()), //isVisible()),
                        WaitUntil.the(Valoracion, isClickable()), //get,
                        Click.on(Valoracion).afterWaitingUntilEnabled());
    }


    public static Performable PresionarEmpleado() {
        return
                Task.where("se utiliza para presionar el Boton mas que se encuentra en la parte inferior",
                        WaitUntil.the(Empleado, isClickable()), //isVisible()),
                        WaitUntil.the(Empleado, isClickable()), //get,
                        Click.on(Empleado).afterWaitingUntilEnabled());
    }

    public static Performable SeleccionarEmpleado() {
        return
                Task.where("se utiliza para presionar el Boton mas que se encuentra en la parte inferior",
                        WaitUntil.the(SeleccionarEmpleado, isClickable()), //isVisible()),
                        WaitUntil.the(SeleccionarEmpleado, isClickable()), //get,
                        Click.on(SeleccionarEmpleado).afterWaitingUntilEnabled());
    }

    public static Performable PresionarContenido() {
        return
                Task.where("se utiliza para presionar el Boton mas que se encuentra en la parte inferior",
                        WaitUntil.the(Contenido, isClickable()), //isVisible()),
                        WaitUntil.the(Contenido, isClickable()), //get,
                        Click.on(Contenido).afterWaitingUntilEnabled());
    }

    public static Performable PresionarLiquidarGuia() {
        return
                Task.where("se utiliza para presionar el Boton mas que se encuentra en la parte inferior",
                        WaitUntil.the(Liquidarguia, isClickable()), //isVisible()),
                        WaitUntil.the(Liquidarguia, isClickable()), //get,
                        Click.on(Liquidarguia).afterWaitingUntilEnabled());
    }
    public static Performable PresionarCerrar() {
        return
                Task.where("se utiliza para presionar el Boton mas que se encuentra en la parte inferior",
                        WaitUntil.the(Cerrar, isClickable()), //isVisible()),
                        WaitUntil.the(Cerrar, isClickable()), //get,
                        Click.on(Cerrar).afterWaitingUntilEnabled());
    }

    public static Performable Presionarfacturar() {
        return
                Task.where("se utiliza para presionar el Boton facturar",
                        WaitUntil.the(Facturar, isClickable()), //isVisible()),
                        WaitUntil.the(Facturar, isClickable()), //get,
                        Click.on(Facturar).afterWaitingUntilEnabled());
    }

    public static Performable PresionarValorPendiente() {
        return
                Task.where("se utiliza para presionar el Boton valor pendiente de pago",
                        WaitUntil.the(PendientedePago, isClickable()), //isVisible()),
                        WaitUntil.the(PendientedePago, isClickable()), //get,
                        Click.on(PendientedePago).afterWaitingUntilEnabled());
    }

    public static Performable PresionarEnviarPago() {
        return
                Task.where("se utiliza para presionar el Boton valor pendiente de pago",
                        WaitUntil.the(EnviarPago, isClickable()), //isVisible()),
                        WaitUntil.the(EnviarPago, isClickable()), //get,
                        Click.on(EnviarPago).afterWaitingUntilEnabled());
    }

    public static Performable PresionarAplazar() {
        return
                Task.where("se utiliza para presionar el boton Aplazar en la pantalla detalle de recogida",
                        WaitUntil.the(Aplazar, isClickable()), //isVisible()),
                        WaitUntil.the(Aplazar, isClickable()), //get,
                        Click.on(Aplazar).afterWaitingUntilEnabled());
    }

    public static Performable PresionarBotonaceptarresultado() {
        return
                Task.where("se utiliza para presionar el boton Aplazar en la pantalla detalle de recogida",
                        WaitUntil.the(BotonAceptarResultado, isClickable()), //isVisible()),
                        WaitUntil.the(BotonAceptarResultado, isClickable()), //get,
                        Click.on(BotonAceptarResultado).afterWaitingUntilEnabled());
    }

    public static Performable Presionarcancelar() {
        return
                Task.where("se utiliza para presionar el boton cancelar en la pantalla detalle de recogida",
                        WaitUntil.the(Cancelar, isClickable()), //isVisible()),
                        WaitUntil.the(Cancelar, isClickable()), //get,
                        Click.on(Cancelar).afterWaitingUntilEnabled());
    }
}




