/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo.Sistema;

import javax.swing.JDialog;

/**
 *
 * @author Idea
 */
public class MetodosVentana {
    
    public static void CerrarVentana(JDialog patern){
        patern.setVisible(false);
        patern.dispose();
    }
}
