/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Modelo.Controles;

import Modelo.Sistema.Colores;
import Modelo.Sistema.Fuentes;
import javax.swing.JCheckBox;

/**
 *
 * @author Betto
 */
public class Checkbox extends JCheckBox{
    
    public Checkbox() {
        
        super.setFont(Fuentes.getVerdana(11));
        super.setBackground(Colores.WorkspaceBackground);
        super.setForeground(Colores.GrisClaro);
        super.setFont(Fuentes.getOpenSans(15));
        inicializar();
    }
    
    private void inicializar(){
        super.setText("checkBox");
    }
}
