/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo.Controles;

import Modelo.Sistema.Colores;
import java.awt.Dimension;
import java.awt.Graphics;
import javax.swing.JPanel;

/**
 *
 * @author Idea
 */
public class Panel extends JPanel{
    private Dimension size;
    private final Dimension defaultDimension = new Dimension(100,100);
    
    public Panel(){
        inicializar();
    }
    
    private void inicializar(){
        super.setPreferredSize(defaultDimension);
    }
    
    @Override
    protected void paintComponent(Graphics g) {
        size = this.getPreferredSize();
        this.setBackground(Colores.WorkspaceBackground);
        super.paintComponent(g);
        this.setPreferredSize(size);
    }
    
}
