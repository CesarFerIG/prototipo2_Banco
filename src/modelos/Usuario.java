package modelos;

import javax.swing.JOptionPane;

/**
 *
 * @author Islas García & Villafuerte Suárez
 */
public class Usuario {

    public Servicio servicio;
    public Tarjeta tarjeta;
    public boolean pagoRealizado;

    // Movimientos en efectivo
    public void pagarServicioEfectivo() {
        servicio = new Servicio();

        servicio.ingresarDatos();
        ingresarEfectivo();

        requiereComprobanteServicio();
    }

    public void pagarTarjeta() {
        tarjeta = new Tarjeta();

        tarjeta.ingresarNumTarjeta();
        tarjeta.ingresarAbono();
        ingresarEfectivo();

        if (requiereComprobante()) {
            if (pagoRealizado) {
                tarjeta.imprimirComprobantePago();
            } else {
                JOptionPane.showMessageDialog(null, "Tarjeta no pagada");
            }
        }
    }

    // Movimientos en tarjeta
    public void consultarSaldoTarjeta() {
        tarjeta = new Tarjeta();

        tarjeta.ingresarDatos();
        tarjeta.imprimirSaldo();
        if (requiereComprobante()) {
            tarjeta.imprimirComprobanteSaldo();
        }
    }

    public void retirarEfectivo() {
        tarjeta = new Tarjeta();

        tarjeta.ingresarDatos();
        tarjeta.ingresarMontoRetirar();
        if (tarjeta.validarSaldo()) {
            tarjeta.restarSaldo();
            tarjeta.imprimirTomarEfectivo();
            if (requiereComprobante()) {
                tarjeta.imprimirComprobanteRetiro();
            }
        }
    }

    public void pagarServicioTarjeta() {
        tarjeta = new Tarjeta();
        servicio = new Servicio();

        tarjeta.ingresarDatos();
        tarjeta.imprimirSaldo();

        servicio.ingresarDatos();
        tarjeta.retiro = servicio.importe;

        pagoRealizado = realizarPago();

        requiereComprobanteServicio();
    }

    // Comprobante
    private String preguntarComprobante() {
        return JOptionPane.showInputDialog("¿Desea imprimir comprobante?\n"
                + "\n S) Sí"
                + "\n N) No"
                + "\n\n").toUpperCase();
    }

    public boolean requiereComprobante() {
        switch (preguntarComprobante()) {
            case "S":
                return true;
            case "N":
                return false;
            default:
                opcionNoValida();
                return requiereComprobante();
        }
    }

    public void requiereComprobanteServicio() {
        if (requiereComprobante()) {
            if (pagoRealizado) {
                servicio.imprimirComprobante();
            } else {
                JOptionPane.showMessageDialog(null, "Servicio no pagado");
            }
        }
    }

    // Aceptar pago
    public void ingresarEfectivo() {
        String opciones[] = {"Ok", "Cancelar"};
        pagoRealizado = JOptionPane.showOptionDialog(null, "Ingrese el efectivo...", "", 0, -1, null, opciones, opciones[0]) == 0;
    }

    private String preguntarRealizarPago() {
        return JOptionPane.showInputDialog("¿Desea realizar el pago?\n"
                + "\n S) Sí"
                + "\n N) No"
                + "\n\n").toUpperCase();
    }

    public boolean realizarPago() {
        switch (preguntarRealizarPago()) {
            case "S":
                if (tarjeta.validarSaldo()) {
                    tarjeta.restarSaldo();
                    servicio.imprimirDatos();
                    return true;
                }
                return false;
            case "N":
                return false;
            default:
                opcionNoValida();
                return realizarPago();
        }
    }

    // Errores
    public void opcionNoValida() {
        JOptionPane.showMessageDialog(null, "Opción no válida", "ERROR", 0);
    }

}
