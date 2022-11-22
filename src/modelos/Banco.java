package modelos;

import vistas.PanelSeleccionOperacion;

/**
 *
 * @author Islas García & Villafuerte Suárez
 */
public class Banco {

    private String nombre = "CATI";
    
    vistas.PanelSeleccionOperacion panelSeleccionOpcEfectivo = new PanelSeleccionOperacion();
    vistas.PanelSeleccionOperacion panelSeleccionOpcTarjeta = new PanelSeleccionOperacion();

    private Object[][] tiposOperaciones = {
        {"Operaciones en efectivo", "/recursos/img/Efectivo_128px.png", panelSeleccionOpcEfectivo},
        {"Operaciones con tarjeta", "/recursos/img/Tarjeta_128px.png", panelSeleccionOpcTarjeta}
    };
    
    private Object[][] operacionesEfectivo = {
        {"Pagar servicios", "/recursos/img/Efectivo_128px.png", panelSeleccionOpcEfectivo},
        {"Pagar tarjetas de credito", "/recursos/img/Tarjeta_128px.png", panelSeleccionOpcTarjeta}
    };
    
    private Object[][] operacionesTareta = {
        {"Consultar saldo", "/recursos/img/Efectivo_128px.png", panelSeleccionOpcEfectivo},
        {"Retirar efectivo", "/recursos/img/Tarjeta_128px.png", panelSeleccionOpcTarjeta},
        {"Pagar servicios", "/recursos/img/Efectivo_128px.png", panelSeleccionOpcEfectivo},
    };
    
    // Getters
    public String getNombre() {
        return nombre;
    }

    public Object[][] getTiposOperaciones() {
        return tiposOperaciones;
    }

}
