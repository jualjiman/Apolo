/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo.Controles;

import Modelo.Sistema.Colores;
import Modelo.Sistema.Fuentes;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 *
 * @author Idea
 */
public class TitleBar extends JPanel{
    private Point initialClick;
    private JFrame parentf;
    private JDialog parentd;
    private Dimension size;
    private final Dimension defaultDimension = new Dimension(200,25);
    private String titulo = "Title bar";
    
    
    public TitleBar(){
        inicializar();
    }
    
    public TitleBar(final JDialog parent){
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
    
    public TitleBar(final JFrame parent){
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
        super.setBackground(Colores.MButtonBorder);
        super.setFont(Fuentes.getVerdana(11));
    }
    
    @Override
    protected void paintComponent(Graphics g) {
        size = this.getPreferredSize();
        super.paintComponent(g);
        g.setColor(Colores.TitleBarForeground);
        g.drawString(getTitulo(),20, 17);
        super.setPreferredSize(size);
    }

    /**
     * @return the titulo
     */
    public String getTitulo() {
        return titulo;
    }

    /**
     * @param titulo the titulo to set
     */
    public void setTitulo(String titulo) {
        this.titulo = titulo;
        this.paintComponent(this.getGraphics());
    }
    
}
