/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo.Controles;

import Modelo.Sistema.Colores;
import Modelo.Sistema.Fuentes;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.JPasswordField;
import javax.swing.border.Border;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.border.MatteBorder;

/**
 *
 * @author Idea
 */
public class TextFieldPassword extends JPasswordField implements KeyListener{
    
    private boolean inactivo = true;
    private Dimension size;
    private final Dimension defaultDimension = new Dimension(228,35);
    
    private final MatteBorder bordern = new MatteBorder(1,1,1,2,Colores.GrisClaro);
    //Border roundedBordern = new LineBorder(Colores.GrisMasClaro, 1, true);
    Border emptyn = new EmptyBorder(0, 4, 0, 0);
    Border borde = new CompoundBorder(bordern, emptyn);
    
    private boolean error = false;
    
    private final MatteBorder bordere = new MatteBorder(1,1,1,2,Colores.RojoError);
    //Border roundedBordere = new LineBorder(Colores.RojoError, 1, true);
    Border emptye = new EmptyBorder(0, 4, 0, 0);
    Border bordeError = new CompoundBorder(bordere, emptye);
    //Border bordeError = new CompoundBorder(intere, bordere);
    
    public TextFieldPassword(){
        inicializar();
        
    }
    
    private void inicializar(){
        super.addKeyListener(this);
        super.setPreferredSize(defaultDimension);
        super.setBackground(Color.white);
        super.setBorder(borde);
        super.setFont(Fuentes.getOpenSans(15));
        super.setForeground(Colores.Gris);
        super.setEchoChar('\u2022');
        super.setText("");
    }
  
    @Override
    protected void paintComponent(Graphics g) {
        size = this.getPreferredSize();
        
        
        this.setPreferredSize(size);
        super.paintComponent(g);
    }
    
    public void setErrorStatus(boolean opc)
    {
        if(opc)
            this.setBorder(bordeError);
        else
            this.setBorder(borde);
        error = opc;
    }

    @Override
    public void keyTyped(KeyEvent e) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void keyPressed(KeyEvent e) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void keyReleased(KeyEvent e) {
        this.setErrorStatus(false);
    }

}
