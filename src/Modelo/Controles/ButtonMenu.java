/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo.Controles;

import Modelo.Sistema.Colores;
import Modelo.Sistema.Fuentes;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Graphics;
import javax.swing.JButton;
import javax.swing.SwingConstants;
import javax.swing.border.Border;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.border.MatteBorder;

/**
 *
 * @author Idea
 */
public class ButtonMenu extends JButton{
    
    private Dimension size;
    private final Dimension defaultDimension = new Dimension(110,70);
    private final MatteBorder borde = new MatteBorder(0,1,0,0,Colores.MButtonBorder);
    private final Cursor manita = Cursor.getPredefinedCursor(Cursor.HAND_CURSOR);
    
    private final MatteBorder bordern = new MatteBorder(0,0,5,0,Colores.MButtonSelected);
    Border bordeR = new CompoundBorder(bordern, borde);
    
    private boolean seleccionado = false;
    
    
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
            g.setColor(Colores.MButtonHover);
            this.setForeground(Colores.MButtonForeground);
            this.setCursor(manita);
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

    /**
     * @return the seleccionado
     */
    public boolean isSeleccionado() {
        return seleccionado;
    }

    /**
     * @param seleccionado the seleccionado to set
     */
    public void setSeleccionado(boolean seleccionado) {
        this.seleccionado = seleccionado;
        if(seleccionado)
            this.setBorder(this.bordeR);
        else
            this.setBorder(this.borde);
    }
}
