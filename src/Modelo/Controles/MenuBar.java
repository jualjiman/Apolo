/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo.Controles;

import Modelo.Sistema.Colores;
import Modelo.Sistema.Fuentes;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.RenderingHints;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.Border;
import javax.swing.border.CompoundBorder;
import javax.swing.border.MatteBorder;

/**
 *
 * @author Idea
 */
public class MenuBar extends JPanel{
    private Dimension size;
    private Point initialClick;
    private JFrame parentf;
    private JDialog parentd;
    private final Dimension defaultDimension = new Dimension(200,75);
    
    private boolean mostrarusuario = false;
    private String usuario = "-";
    
    private Dimension d;
    private final MatteBorder borde = new MatteBorder(0,0,4,0,Colores.MenuShadow);
    
    public MenuBar(){
        inicializar();
    }
    
    public MenuBar(final JDialog parent){
        this.parentd = parent;
        inicializar();

        addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                initialClick = e.getPoint();
                getComponentAt(initialClick);
            }
        });

        addMouseMotionListener(new MouseMotionAdapter() {
            @Override
            public void mouseDragged(MouseEvent e) {

                // get location of Window
                int thisX = parentd.getLocation().x;
                int thisY = parentd.getLocation().y;

                // Determine how much the mouse moved since the initial click
                int xMoved = (thisX + e.getX()) - (thisX + initialClick.x);
                int yMoved = (thisY + e.getY()) - (thisY + initialClick.y);

                // Move window to this position
                int X = thisX + xMoved;
                int Y = thisY + yMoved;
                parentd.setLocation(X, Y);
            }
        });
    }
    
    public MenuBar(final JFrame parent){
        this.parentf = parent;
        inicializar();

        addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                initialClick = e.getPoint();
                getComponentAt(initialClick);
            }
        });

        addMouseMotionListener(new MouseMotionAdapter() {
            @Override
            public void mouseDragged(MouseEvent e) {

                // get location of Window
                int thisX = parentf.getLocation().x;
                int thisY = parentf.getLocation().y;

                // Determine how much the mouse moved since the initial click
                int xMoved = (thisX + e.getX()) - (thisX + initialClick.x);
                int yMoved = (thisY + e.getY()) - (thisY + initialClick.y);

                // Move window to this position
                int X = thisX + xMoved;
                int Y = thisY + yMoved;
                parentf.setLocation(X, Y);
            }
        });
    }
    
    private void inicializar(){
        super.setPreferredSize(defaultDimension);
        super.setForeground(Colores.BlancoSenizo);
        super.setBackground(Colores.MenuBackground);
        super.setBorder(borde);
    }
    
    @Override
    protected void paintComponent(Graphics g) {
        size = this.getPreferredSize();
        d = this.getSize();
        super.paintComponent(g);
        
        Graphics2D g2d = (Graphics2D) g;
        
        RenderingHints rh =
            new RenderingHints(RenderingHints.KEY_ANTIALIASING, 
            RenderingHints.VALUE_ANTIALIAS_ON);

        rh.put(RenderingHints.KEY_RENDERING,
               RenderingHints.VALUE_RENDER_QUALITY);

        g2d.setRenderingHints(rh);
        
        if(mostrarusuario){
            int margin = ((getUsuario().length() * 7));

            g2d.setColor(Colores.BlancoSenizo);
            g2d.setFont(Fuentes.getOpenSans(14));
            g2d.drawString("usuario",d.width - margin, 43);

            g2d.setColor(Colores.Blanco);
            g2d.setFont(Fuentes.getOpenSans(17));
            g2d.drawString(getUsuario(),d.width - margin, 60);
        }
        super.setPreferredSize(size);
    }

    /**
     * @return the usuario
     */
    public String getUsuario() {
        return usuario;
    }

    /**
     * @param usuario the usuario to set
     */
    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    /**
     * @return the mostrarusuario
     */
    public boolean isMostrarusuario() {
        return mostrarusuario;
    }

    /**
     * @param mostrarusuario the mostrarusuario to set
     */
    public void setMostrarusuario(boolean mostrarusuario) {
        this.mostrarusuario = mostrarusuario;
    }
    
}
