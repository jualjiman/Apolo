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
import static javax.swing.SwingConstants.TOP;

/**
 *
 * @author Idea
 */
public class LabelField extends JLabel{
    
    private Dimension size;
    private final Dimension defaultDimension = new Dimension(150,20);
    
    public LabelField(){
        inicializar();
    }
    
    private void inicializar(){
        super.setText("Identificador");
        super.setPreferredSize(defaultDimension);
        super.setForeground(Colores.Gris);
        super.setVerticalAlignment(TOP);
        super.setVerticalTextPosition(TOP);
        super.setFont(Fuentes.getOpenSans(16));
        super.setPreferredSize(size);
    }
    
    @Override
    protected void paintComponent(Graphics g) {
        size = this.getPreferredSize();
        
        //this.setPreferredSize(size);
        super.paintComponent(g);
    }
}
