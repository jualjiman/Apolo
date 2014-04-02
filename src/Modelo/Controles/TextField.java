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
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.JTextField;
import javax.swing.border.Border;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.border.MatteBorder;

/**
 *
 * @author Idea
 */
public class TextField extends JTextField implements KeyListener, FocusListener, MouseListener{
    
    private boolean inactivo = true;
    private Dimension size;
    private final Dimension defaultDimension = new Dimension(228,35);
    private String placeholder = "";
    
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
    
    public TextField(){
        inicializar();
        
    }
    
    private void inicializar(){
        super.addKeyListener(this);
        super.addFocusListener(this);
        super.addMouseListener(this);
        super.setPreferredSize(defaultDimension);
        super.setBackground(Color.white);
        super.setBorder(borde);
        super.setFont(Fuentes.getOpenSans(15));
        super.setText(placeholder);
    }
  
    @Override
    protected void paintComponent(Graphics g) {
        size = this.getPreferredSize();
        if(inactivo)
            this.setForeground(Colores.GrisClaro);
        else
            this.setForeground(Colores.Gris);
        
        this.setPreferredSize(size);
        super.paintComponent(g);
    }

    @Override
    public void keyTyped(KeyEvent e) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void keyPressed(KeyEvent e) { 
            if(this.getText().equals(placeholder)){
                if(e.getKeyCode() == 27
                        || e.getKeyCode() == 127
                        || (e.getKeyCode() >= 112 && e.getKeyCode() <=123)
                        || (e.getKeyCode() >= 33 && e.getKeyCode() <=40)
                        || e.getKeyCode() == 10
                        || (e.getKeyCode() >= 16 && e.getKeyCode() <= 18)
                        || e.getKeyCode() == 524
                        || e.getKeyCode() == 525
                        || e.getKeyCode() == 20
                        || e.getKeyCode() == 87
                        || (e.getKeyCode() == 8 && this.getText().equals(placeholder))){
                    inactivo = true;
                    e.consume();
                }
                else{
                    this.setText("");
                }
                this.setCaretPosition(0);
            }
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void keyReleased(KeyEvent e) {
            if(this.getText().isEmpty()){
                this.setText(placeholder);
                this.setCaretPosition(0);
                inactivo = true;
            }else if(this.getText().equals(placeholder)){
                inactivo = true;
            }
            else{
                inactivo = false;
            }
            this.setErrorStatus(false);
    }    
        

    @Override
    public void focusGained(FocusEvent e) {
            if(this.getText().equals(placeholder)){
                this.setCaretPosition(0);
            }
    }

    @Override
    public void focusLost(FocusEvent e) {
            if(this.getText().isEmpty()){
                this.setText(placeholder);
                this.setCaretPosition(0);
            }
    }
    
    public void setErrorStatus(boolean opc)
    {
        if(opc)
            this.setBorder(bordeError);
        else
            this.setBorder(borde);
        error = opc;
    }
        /**
     * @return the placeholder
     */
    
    public String getPlaceholder() {
        return placeholder;
    }
    /**
     * @param placeholder the placeholder to set
     */
    
    public void setPlaceholder(String placeholder) {
        this.inactivo = true;
        this.placeholder = placeholder;
        this.setText(placeholder);
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void mousePressed(MouseEvent e) {
            if(this.getText().equals(placeholder))
                this.setCaretPosition(0);
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void mouseEntered(MouseEvent e) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void mouseExited(MouseEvent e) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
