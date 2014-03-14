/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo.Sistema;

import java.awt.Font;
import java.awt.FontFormatException;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;

/**
 *
 * @author Idea
 */
public class Fuentes {
    private static Font icons;
    private static Font verdana;
    private static Font verdanaBold;
    private static Font openSansB;
    private static Font openSans;

    /**
     * @return the champagne
     */
    public static Font getIcons(float size) {
        try {
            File fil = new File("src/Fonts/icomoon.ttf");
            icons = Font.createFont(Font.TRUETYPE_FONT, fil);
            icons = icons.deriveFont(size);
            return icons;
        } catch (FontFormatException ex) {
            System.out.println("No se pudo cargar la fuente Error: " + ex.toString());
            return null;
        } catch (IOException ex) {
            System.out.println("No se pudo cargar la fuente Error: " + ex.toString());
            return null;
        }
    }

    /**
     * @return the Verdana
     */
    public static Font getVerdana(int size) {
        verdana = new Font("Verdana", Font.PLAIN, size);
        return verdana;
    }
    
    /**
     * @return the Verdana
     */
    public static Font getVerdanaBold(int size) {
        verdanaBold = new Font("Verdana", Font.BOLD, size);
        return verdanaBold;
    }

    /**
     * @return the openSansBold
     */
    public static Font getOpenSansB(float size) {
        try {
            File fil = new File("src/Fonts/opensansb.ttf");
            openSansB = Font.createFont(Font.TRUETYPE_FONT, fil);
            openSansB = openSansB.deriveFont(size);
            return openSansB;
        } catch (FontFormatException ex) {
            System.out.println("No se pudo cargar la fuente Error: " + ex.toString());
            return null;
        } catch (IOException ex) {
            System.out.println("No se pudo cargar la fuente Error: " + ex.toString());
            return null;
        }
    }

    /**
     * @return the openSans
     */    
    public static Font getOpenSans(float size) {
        try {
            File fil = new File("src/Fonts/opensans.ttf");
            openSans = Font.createFont(Font.TRUETYPE_FONT, fil);
            openSans = openSans.deriveFont(size);
            return openSans;
        } catch (FontFormatException ex) {
            System.out.println("No se pudo cargar la fuente Error: " + ex.toString());
            return null;
        } catch (IOException ex) {
            System.out.println("No se pudo cargar la fuente Error: " + ex.toString());
            return null;
        }
    }

}
