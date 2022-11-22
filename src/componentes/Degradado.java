/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package componentes;

import java.awt.Color;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import javax.swing.JPanel;

/**
 *
 * @author Islas García César Fernando
 */

// Degradado del fondo
public class Degradado extends JPanel {

    @Override
    protected void paintComponent(Graphics g) {
        Graphics2D g2d = (Graphics2D) g;
        g2d.setRenderingHint(RenderingHints.KEY_RENDERING, RenderingHints.VALUE_RENDER_QUALITY);

        Color color1 = new Color(2, 54, 94);
        Color color2 = new Color(6, 100, 144);

        GradientPaint degradado = new GradientPaint(0, 0, color1, super.getWidth(), super.getHeight(), color2);
        g2d.setPaint(degradado);

        g2d.fillRect(0, 0, getWidth(), getHeight());
        
        super.paintChildren(g);
    }

}
