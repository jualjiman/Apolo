package Modelo.Controles;

import java.awt.Graphics2D;
import java.awt.RenderingHints;

public class Image extends javax.swing.JPanel {
    private java.awt.Image imagen=null;

    public void setImagen(java.awt.Image Imagen)
    {
        imagen = Imagen;

        repaint();
    }

    @Override
    public void paint(java.awt.Graphics g) {
        if (imagen != null)
        {
            Graphics2D g2d = (Graphics2D) g;
            RenderingHints rh =
                new RenderingHints(RenderingHints.KEY_ANTIALIASING, 
                RenderingHints.VALUE_ANTIALIAS_ON);

            rh.put(RenderingHints.KEY_RENDERING,
                   RenderingHints.VALUE_RENDER_QUALITY);

            g2d.setRenderingHints(rh);
            g2d.drawImage(imagen, 0, 0, getWidth(), getHeight(), this);
            setOpaque(false);
        }
        else
        {
            setOpaque(true);
        }

        super.paint(g);
    }
//    @Override
//    public void paintComponent(java.awt.Graphics g) {
//        if (imagen != null)
//        {
//            g.drawImage(imagen, 0, 0, getWidth(), getHeight(), this);
//            setOpaque(false);
//        }
//        else
//        {
//            setOpaque(true);
//        }
//
//        super.paintComponent(g);
//    }

}
