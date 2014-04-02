/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Modelo.Controles;

import Modelo.Sistema.Colores;
import Modelo.Sistema.Fuentes;
import com.toedter.calendar.JDateChooser;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import javax.swing.border.Border;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.border.MatteBorder;

/**
 *
 * @author Betto
 */
public class dateChooser extends JDateChooser{
    
    private boolean inactivo = true;
    private Dimension size;
    private final Dimension defaultDimension = new Dimension(150,35);
    
    public dateChooser(){
        inicializar();
    }
    
    private void inicializar(){
        super.setPreferredSize(defaultDimension);
        super.setBackground(Color.white);
    }
  
    @Override
    protected void paintComponent(Graphics g) {
        size = this.getPreferredSize();
        if(inactivo)
            this.setForeground(Colores.GrisClaro);
        else
            this.setForeground(Colores.Gris);
        this.setFont(Fuentes.getOpenSans(15));
        this.setPreferredSize(size);
        super.paintComponent(g);
    }
}
