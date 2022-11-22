package modelos;

import javax.swing.JOptionPane;

/**
 *
 * @author Islas García & Villafuerte Suárez
 */
public class Tarjeta {

    public long numTarjeta, nip;
    public double saldo = 16190, abono, retiro;

    // Ingreso de datos
    public void ingresarNumTarjeta() {
        numTarjeta = Long.parseLong(JOptionPane.showInputDialog("Ingrese el número de tarjeta:"));
    }

    public void ingresarNIP() {
        nip = Long.parseLong(JOptionPane.showInputDialog("Ingrese el NIP:"));
    }

    public void ingresarDatos() {
        ingresarNumTarjeta();
        ingresarNIP();
        if (!(numTarjeta == nip)) {
            JOptionPane.showMessageDialog(null, "Los datos no coinciden, por favor, vuelva a intentarlo", "ERROR", 2);
            ingresarDatos();
        }
    }

    public void ingresarAbono() {
        abono = Double.parseDouble(JOptionPane.showInputDialog("Ingrese el total a pagar:"));
        if (abono <= 0) {
            imprimirErrorValorNegativo();
            ingresarAbono();
        }
    }

    public void ingresarMontoRetirar() {
        retiro = Double.parseDouble(JOptionPane.showInputDialog("Dispone de $" + saldo
                + "\n"
                + "\n¿Cuánto desea retirar?"));
        if (retiro <= 0) {
            imprimirErrorValorNegativo();
            ingresarMontoRetirar();
        }
    }

    // Impresiones
    public void imprimirSaldo() {
        JOptionPane.showMessageDialog(null, "Usted dispone de:"
                + "\n$ " + saldo);
    }

    public void imprimirTomarEfectivo() {
        JOptionPane.showMessageDialog(null, "Se esta preparando su efectivo...");
        JOptionPane.showMessageDialog(null, "Ya puede tomar su dinero.");
    }

    // Procesos
    public void restarSaldo() {
        saldo -= retiro;
    }

    // Comprobantes
    public void imprimirComprobantePago() {
        JOptionPane.showMessageDialog(null, "Tarjeta: " + numTarjeta
                + "\nCantidad abonada: $" + abono,
                "PAGO EXITOSO", 1);
    }

    public void imprimirComprobanteSaldo() {
        JOptionPane.showMessageDialog(null, "SU SALDO ES: $" + saldo,
                "ESTADO DE CUENTA", 1);
    }

    public void imprimirComprobanteRetiro() {
        JOptionPane.showMessageDialog(null, "USTED A RETIRADO: $" + retiro
                + "\nSU SALDO AHORA ES: $" + saldo,
                "ESTADO DE CUENTA", 1);
    }

    // Validaciones
    public boolean validarSaldo() {
        if (saldo > retiro) {
            return true;
        } else {
            JOptionPane.showMessageDialog(null, "Fondos insuficientes", "ERROR", 0);
            return false;
        }
    }

    // Errores
    private void imprimirErrorValorNegativo() {
        JOptionPane.showMessageDialog(null, "El valor no puede ser menor a $1", "ERROR", 2);
    }
}
