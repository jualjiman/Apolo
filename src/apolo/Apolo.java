/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package apolo;

import Vistas.Principal;
import javax.swing.UIManager;
import javax.swing.UIManager.LookAndFeelInfo;

/**
 *
 * @author Idea
 */
public class Apolo {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        try
        {
            
            javax.swing.UIManager.setLookAndFeel(javax.swing.UIManager.getSystemLookAndFeelClassName());


            //FPrincipal principal = new FPrincipal();
           // principal.setVisible(true);
 

            //CIntro inicio = new CIntro();
            Principal au = new Principal();
            au.setVisible(true);

        }
        catch(Exception e)
        {
            System.out.println("No se pudo establecer el aspecto deseado" +  e);
        }
    }
}
