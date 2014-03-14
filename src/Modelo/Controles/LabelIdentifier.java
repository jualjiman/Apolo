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
public class LabelIdentifier extends JLabel{
    
    private Dimension size;
    private final Dimension defaultDimension = new Dimension(150,14);
    
    public LabelIdentifier(){
        inicializar();
    }
    
    private void inicializar(){
        super.setText("Identificador");
        super.setPreferredSize(defaultDimension);
        super.setForeground(Colores.GrisClaro);
        super.setFont(Fuentes.getOpenSans(15));
        super.setPreferredSize(size);
    }
    
    @Override
    protected void paintComponent(Graphics g) {
        size = this.getPreferredSize();
        
        //this.setPreferredSize(size);
        super.paintComponent(g);
    }
}
