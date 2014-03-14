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
import javax.swing.SwingConstants;
import javax.swing.border.MatteBorder;

/**
 *
 * @author Idea
 */
public class ButtonMenu extends JButton{
    
    private Dimension size;
    private final Dimension defaultDimension = new Dimension(110,70);
    private final MatteBorder borde = new MatteBorder(0,1,0,0,Colores.MButtonBorder);
    
    
    public ButtonMenu() {
        this(null);
        inicializar();
    }

    public ButtonMenu(String text) {
        super(text);
        inicializar();
    }
    
    private void inicializar(){
        super.setFont(Fuentes.getOpenSans(15));
        super.setContentAreaFilled(false);
        super.setFocusPainted(false);
        super.setBorderPainted(true);
        super.setBackground(Colores.MButton);
        super.setForeground(Colores.MButtonForeground);
        super.setText("titulo");
        super.setBorder(borde);
        super.setPreferredSize(defaultDimension);
        super.setHorizontalTextPosition(SwingConstants.CENTER);
        super.setIconTextGap(5);
        super.setVerticalTextPosition(SwingConstants.BOTTOM);
        //super.setFont(Fuentes.getVerdana(10));
    }
    
    @Override
    protected void paintComponent(Graphics g) {
        size = super.getPreferredSize();
        if (getModel().isPressed()) {
            g.setColor(Colores.MButtonPressed);
            super.setForeground(Colores.MButtonForegrounSelected);
            
//        } if (!getModel().isPressed()) {
//            g.setColor(getBackground());
//            super.setForeground(Colores.MButtonForeground);
        } else if(getModel().isRollover()) {
            g.setColor(Colores.MButton);
            this.setForeground(Colores.MButtonForeground);
        }else if(!getModel().isEnabled()){
            g.setColor(Colores.MButtonDisabled);
            super.setForeground(Colores.MButtonForegrounSelected);
        }
        else {
            g.setColor(getBackground());
            super.setForeground(Colores.MButtonForeground);
        }
        g.fillRect(0, 0, getWidth(), getHeight());
        
        super.setText(this.getText().toLowerCase());
        super.setPreferredSize(size);
        super.paintComponent(g);
    }
}
