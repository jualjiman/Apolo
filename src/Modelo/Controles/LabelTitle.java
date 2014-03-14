/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo.Controles;

import Modelo.Sistema.Colores;
import Modelo.Sistema.Fuentes;
import java.awt.Dimension;
import java.awt.Graphics;
import javax.swing.JLabel;

/**
 *
 * @author Idea
 */
public class LabelTitle extends JLabel{
    
    private Dimension size;
    private final Dimension defaultDimension = new Dimension(100,20);
    
    public LabelTitle(){
        inicializar();
    }
    
    private void inicializar(){
        super.setText("Titulo");
        super.setPreferredSize(defaultDimension);
        super.setFont(Fuentes.getOpenSans(24));
    }
    
    @Override
    protected void paintComponent(Graphics g) {
        size = this.getPreferredSize();
        super.setForeground(Colores.Gris);
        //super.setFont(Fuentes.getVerdana(17));
        //this.setPreferredSize(size);
        super.paintComponent(g);
    }
}
