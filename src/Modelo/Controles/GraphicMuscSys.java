package Modelo.Controles;

import Modelo.Sistema.Colores;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;

public class GraphicMuscSys extends javax.swing.JPanel implements MouseMotionListener {
    private java.awt.Image imagen=null;
    private int sexo = 0;//por default en masculino
    private String fuente = "M";
    private String path = "/Images/assets/sm" + fuente + ".png";

    public void setImagen(java.awt.Image Imagen)
    {
        imagen = Imagen;
        repaint();
    }
    
    public GraphicMuscSys(){
        imagen= new javax.swing.ImageIcon(getClass().getResource("/Images/assets/smM.png")).getImage();
        this.setImagen(imagen);
    }
    
    public GraphicMuscSys(int sexo){
        this.setSexo(sexo);
    }

    @Override
    public void paint(java.awt.Graphics g) {
        if (getImagen() != null)
        {
            Graphics2D g2d = (Graphics2D) g;
            RenderingHints rh =
                new RenderingHints(RenderingHints.KEY_ANTIALIASING, 
                RenderingHints.VALUE_ANTIALIAS_ON);

            rh.put(RenderingHints.KEY_RENDERING,
                   RenderingHints.VALUE_RENDER_QUALITY);

            g2d.setRenderingHints(rh);
            g2d.drawImage(getImagen(), 0, 0, getWidth(), getHeight(), this);
            
            g2d.setColor(Colores.NButtonBorder);
            g2d.fillOval(61, 89, 12, 12);//pecho
            g2d.setColor(Colores.GrisMasClaro);
            g2d.drawOval(61, 89, 12, 12);
            
            g2d.setColor(Colores.NButtonBorder);
            g2d.fillOval(30, 77, 12, 12);//hombro
            g2d.setColor(Colores.GrisMasClaro);
            g2d.drawOval(30, 77, 12, 12);
            
            g2d.setColor(Colores.NButtonBorder);
            g2d.fillOval(112, 74, 12, 12);//hombro
            g2d.setColor(Colores.GrisMasClaro);
            g2d.drawOval(112, 74, 12, 12);
            
            g2d.setColor(Colores.NButtonBorder);
            g2d.fillOval(30, 119, 12, 12);//bisep izquierdo
            g2d.setColor(Colores.GrisMasClaro);
            g2d.drawOval(30, 119, 12, 12);
            
            g2d.setColor(Colores.NButtonBorder);
            g2d.fillOval(108, 119, 12, 12);//bisep derecho
            g2d.setColor(Colores.GrisMasClaro);
            g2d.drawOval(108, 119, 12, 12);
            
            g2d.setColor(Colores.NButtonBorder);
            g2d.fillOval(38, 223, 12, 12);//pierna izquierda
            g2d.setColor(Colores.GrisMasClaro);
            g2d.drawOval(38, 223, 12, 12);
            
            g2d.setColor(Colores.NButtonBorder);
            g2d.fillOval(90, 223, 12, 12);//pierna derecha
            g2d.setColor(Colores.GrisMasClaro);
            g2d.drawOval(90, 223, 12, 12);
            
            g2d.setColor(Colores.NButtonBorder);
            g2d.fillOval(218, 292, 12, 12);//pantorrilla izquierda
            g2d.setColor(Colores.GrisMasClaro);
            g2d.drawOval(218, 292, 12, 12);
            
            g2d.setColor(Colores.NButtonBorder);
            g2d.fillOval(259, 292, 12, 12);//pantorrilla derecha
            g2d.setColor(Colores.GrisMasClaro);
            g2d.drawOval(259, 292, 12, 12);
            
            g2d.setColor(Colores.NButtonBorder);
            g2d.fillOval(240, 182, 12, 12);//gluteos
            g2d.setColor(Colores.GrisMasClaro);
            g2d.drawOval(240, 182, 12, 12);
            
            g2d.setColor(Colores.NButtonBorder);
            g2d.fillOval(63, 171, 12, 12);//cintura
            g2d.setColor(Colores.GrisMasClaro);
            g2d.drawOval(63, 171, 12, 12);
            
            setOpaque(false);
        }
        else
        {
            setOpaque(true);
        }

        super.paint(g);
    }
    
    public java.awt.Image getImagen() {
        return imagen;
    }

    /**
     * @return the sexo
     */
    public int getSexo() {
        return sexo;
    }

    /**
     * @param sexo the sexo to set
     */
    public void setSexo(int sexo) {
        this.sexo = sexo;
        
        if(sexo == 0)
            fuente = "M";
        else if(sexo == 1)
            fuente = "F";
        
        imagen= new javax.swing.ImageIcon(getClass().getResource("/Images/assets/sm" + fuente + ".png")).getImage();
        this.setImagen(imagen);
    }

    @Override
    public void mouseDragged(MouseEvent e) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void mouseMoved(MouseEvent e) {

    }

}
