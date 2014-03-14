package Modelo.Controles;

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
            g.drawImage(imagen, 0, 0, getWidth(), getHeight(), this);
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
