/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Modelo.Controles;

import Modelo.Sistema.Colores;
import Modelo.Sistema.Fuentes;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import javax.swing.JComboBox;
import javax.swing.border.MatteBorder;

/**
 *
 * @author Betto
 */
public class comboBox extends JComboBox implements ItemListener{
     
    private Dimension size;
    private final Dimension defaultDimension = new Dimension(100,35);
    private final MatteBorder bordeError = new MatteBorder(1,1,1,2,Colores.RojoError);
    private final MatteBorder borde = new MatteBorder(1,1,1,2,Colores.GrisClaro);
    
    private boolean error = false;

    public comboBox() {
        inicializar();
    }
    
    private void inicializar(){
        super.addItemListener(this);
        super.setBounds(20,20,180,30);
        super.setForeground(Colores.Gris);
        super.setPreferredSize(defaultDimension);
        super.setFont(Fuentes.getOpenSans(16));
        super.setBorder(borde);
    }
    
    @Override
    protected void paintComponent(Graphics g) {
        size = this.getPreferredSize();
        g.fillRect(0, 0, getWidth(), getHeight());
        super.paintComponent(g);
        this.setPreferredSize(size);
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
    public void itemStateChanged(ItemEvent e) {
        this.setErrorStatus(false);
    }
}
