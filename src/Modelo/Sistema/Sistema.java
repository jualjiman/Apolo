/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Modelo.Sistema;

/**
 *
 * @author Betto
 */
public class Sistema {
    
    //sistema
    public static final String sysName = "Apolo";
    public static final String sysVersion = "1.0";
    public static final String sysAuthor = "SESI";
    
    //gym
    public static final String gymName = "";
    
    //bd
    public static final String controladorbd = "org.firebirdsql.jdbc.FBDriver";
    public static final String rutabd = "jdbc:firebirdsql:";////localhost/C://BDSIAF//BDSIAF.FDB
    public static final String usuariobd = "sysdba";
    public static final String contraseñabd = "masterkey";
    
    //ficheros
    public static String archivoconexon = "config.dat";
}
