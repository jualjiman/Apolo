/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo.Controles;

import Modelo.Sistema.Colores;
import Modelo.Sistema.Fuentes;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Graphics;
import javax.swing.JButton;
import javax.swing.border.MatteBorder;

/**
 *
 * @author Idea
 */
public class ButtonNormalR extends JButton{
    
    private Dimension size;
    private final Dimension defaultDimension = new Dimension(100,35);
    private final MatteBorder borde = new MatteBorder(2,2,2,2,Colores.RButtonBorder);    
    private final Cursor manita = Cursor.getPredefinedCursor(Cursor.HAND_CURSOR);
    
    public ButtonNormalR() {
        this(null);
        inicializar();
    }

    public ButtonNormalR(String text) {
        super(text);
        inicializar();
    }
    
    private void inicializar(){
        super.setContentAreaFilled(false);
        super.setFocusPainted(false);
        super.setBorderPainted(true);
        super.setBackground(Colores.RButton);
        super.setForeground(Colores.RButtonForeground);
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
            g.setColor(Colores.RButtonPressed);
            this.setForeground(Colores.RButtonForegroundSelected);
        } else if (getModel().isRollover()) {
            g.setColor(Colores.RButton);
            this.setForeground(Colores.RButtonForeground);
            this.setCursor(manita);
        }else if(!getModel().isEnabled()){
            g.setColor(Colores.WorkspaceBackground);
            this.setForeground(Colores.RButtonBorder);
        }else {
            g.setColor(getBackground());
            this.setForeground(Colores.RButtonForeground);
        }
        g.fillRect(0, 0, getWidth(), getHeight());
        super.paintComponent(g);
        this.setPreferredSize(size);
    }
}
