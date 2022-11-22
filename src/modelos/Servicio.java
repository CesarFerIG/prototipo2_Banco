package modelos;

import javax.swing.JOptionPane;

/**
 *
 * @author Islas García & Villafuerte Suárez
 */
public class Servicio {

    public String concepto;
    public long numConvenio;
    public double importe;

    // Ingreso de datos
    private String imprimirServicios() {
        return JOptionPane.showInputDialog("¿Que servicio desea pagar?"
                + "\n"
                + "\n I. Agua\n"
                + "\n II. Luz\n"
                + "\n III. Teléfono\n"
                + "\n IV. Otro\n"
                + "\n"
                + "\nElija:").toUpperCase();
    }

    public void ingresarNumConvenio() {
        numConvenio = Long.parseLong(JOptionPane.showInputDialog("Ingrese el número de convenio:"));
    }

    public void ingresarImporte() {
        importe = Double.parseDouble(JOptionPane.showInputDialog("Ingrese el importe a pagar:"));
        if (importe <= 0) {
            imprimirErrorImporte();
            ingresarImporte();
        }
    }

    public void ingresarServicio() {
        switch (imprimirServicios()) {
            case "I":
                concepto = "Agua";
                break;
            case "II":
                concepto = "Luz";
                break;
            case "III":
                concepto = "Teléfono";
                break;
            case "IV":
                concepto = JOptionPane.showInputDialog("Especifique:");
                break;
            default:
                imprimirErrorOpcion();
                ingresarServicio();
                break;
        }
    }

    public void ingresarDatos() {
        ingresarServicio();
        ingresarNumConvenio();
        ingresarImporte();
    }

    // Impresiones
    public void imprimirDatos() {
        JOptionPane.showMessageDialog(null, "PAGO DE SERVICIO DE: " + concepto.toUpperCase()
                + "\nNúmero de convenio: " + numConvenio
                + "\nImporte pagado: $" + importe);
    }

    public void imprimirComprobante() {
        JOptionPane.showMessageDialog(null, "Concepto: PAGO DE SERVICIO DE " + concepto.toUpperCase()
                + "\nNúmero de convenio: " + numConvenio
                + "\nImporte pagado: $" + importe,
                "COMPROBANTE DE PAGO", 1);
    }

    // Errores
    private void imprimirErrorOpcion() {
        JOptionPane.showMessageDialog(null, "Opción no válida", "ERROR", 0);
    }

    private void imprimirErrorImporte() {
        JOptionPane.showMessageDialog(null, "El importe no puede ser menor a $1", "ERROR", 2);
    }
}
