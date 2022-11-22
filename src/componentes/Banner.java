package componentes;

import java.awt.Dimension;
import java.awt.Graphics;
import javax.swing.ImageIcon;
import javax.swing.JPanel;

/**
 *
 * @author Islas García César Fernando
 */
public class Banner extends JPanel {

    String src;

    public Banner(String src) {
        this.src = src;
    }

    @Override
    public void paint(Graphics g) {
        Dimension dimensiones = super.getSize();

        ImageIcon imagen = new ImageIcon(getClass().getResource(src));
        double proporcion = (double) imagen.getIconHeight() / imagen.getIconWidth();

        int ancho = dimensiones.width;
        int alto = 0;

        if (proporcion == 0.5) {
            alto = dimensiones.width / 2;
        }
        
        int distanciaParaCentrar = -((alto - dimensiones.height) / 2);
        g.drawImage(imagen.getImage(), 0, distanciaParaCentrar, ancho, alto, null);
        
        super.paintChildren(g);
    }

}
