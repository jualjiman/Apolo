/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Modelo.Controles;

import Modelo.Sistema.Colores;
import Modelo.Sistema.Fuentes;
import java.awt.Color;
import javax.swing.JList;
import javax.swing.border.MatteBorder;

/**
 *
 * @author Betto
 */
public class List extends JList{
    
    private final MatteBorder borde = new MatteBorder(0,1,0,0,Colores.NButton);
    
    public List() {
        inicializar();
        
    }
    
    private void inicializar(){
        //super.setFont(Fuentes.getVerdana(11));
        super.setForeground(Colores.Gris);
        super.setFont(Fuentes.getOpenSans(14));
        super.setBorder(borde);
        super.setSelectionBackground(new Color(217,229,254));
        super.setSelectionForeground(Colores.Gris);
        
        //scroll = (JScrollPane) this.getParent();
        //this.setBorder(BorderFactory.createLineBorder(Color.RED,1)); // HERE  
        this.setBorder(null);//
    }
}
