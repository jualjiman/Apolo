/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Modelo.Controles;

import Modelo.Sistema.Colores;
import Modelo.Sistema.Fuentes;
import java.awt.Color;
import javax.swing.JRadioButton;

/**
 *
 * @author Betto
 */
public class RadioButton extends JRadioButton {
    
    public RadioButton() {
        inicializar();
    }
    
    private void inicializar(){
        super.setContentAreaFilled(false);
        super.setFocusPainted(false);
        super.setBackground(Colores.WorkspaceBackground);
        super.setForeground(Colores.GrisIntermedio);
        super.setText("radioButton");
        super.setFont(Fuentes.getVerdana(11));
        //super.setBorderPainted(true);
    }
}
