/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo.Controles;

import Modelo.Sistema.Colores;
import Modelo.Sistema.Fuentes;
import java.awt.Dimension;
import java.awt.Graphics;
import javax.swing.JButton;
import javax.swing.border.MatteBorder;

/**
 *
 * @author Idea
 */
public class ButtonNormalV extends JButton{
    
    private Dimension size;
    private final Dimension defaultDimension = new Dimension(100,35);
    private final MatteBorder borde = new MatteBorder(2,2,2,2,Colores.NButtonBorder);    
    
    public ButtonNormalV() {
        this(null);
        inicializar();
    }

    public ButtonNormalV(String text) {
        super(text);
        inicializar();
    }
    
    private void inicializar(){
        super.setContentAreaFilled(false);
        super.setFocusPainted(false);
        super.setBorderPainted(true);
        super.setBackground(Colores.NButton);
        super.setForeground(Colores.NButtonForeground);
        super.setText("boton");
        super.setBorder(borde);
        super.setPreferredSize(defaultDimension);
        super.setIconTextGap(10);
        super.setFont(Fuentes.getIcons(16));
    }
    
    @Override
    protected void paintComponent(Graphics g) {
        size = this.getPreferredSize();
        if (getModel().isPressed()) {
            g.setColor(Colores.NButtonPressed);
            this.setForeground(Colores.NButtonForegroundSelected);
        } else if (getModel().isRollover()) {
            g.setColor(Colores.NButton);
            this.setForeground(Colores.NButtonForeground);
        }else if(!getModel().isEnabled()){
            g.setColor(Colores.WorkspaceBackground);
            this.setForeground(Colores.NButtonBorder);
        }else {
            g.setColor(getBackground());
            this.setForeground(Colores.NButtonForeground);
        }
        g.fillRect(0, 0, getWidth(), getHeight());
        super.paintComponent(g);
        this.setPreferredSize(size);
    }
}
