/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo.Conexiones;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Idea
 */
public class GeneralConexion {
    
    private Connection conexion;
    private Statement sentencia;
    private ResultSet rs; 
    private static Conexion con;
    
    public GeneralConexion(){
        try {
            con = new Conexion();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(HabitacionConexion.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public String QueryGeneralUnResultado(String query) throws java.sql.SQLException
    {
        String res;
        con.conectar();
        conexion = con.conexion;
        
        sentencia = conexion.createStatement(
        java.sql.ResultSet.TYPE_SCROLL_INSENSITIVE,
        java.sql.ResultSet.CONCUR_READ_ONLY);
        
        rs = sentencia.executeQuery(query);
        rs.next();
        
        res = rs.getString(1);
        
        con.desconectar();
        return res;
    }
    
        public int lastID() throws java.sql.SQLException
    {
        int id;
        con.conectar();
        conexion = con.conexion;
        
        sentencia = conexion.createStatement(
        java.sql.ResultSet.TYPE_SCROLL_INSENSITIVE,
        java.sql.ResultSet.CONCUR_READ_ONLY);
        
        rs = sentencia.executeQuery("select last_insert_id()");
        rs.next();
        
        id = rs.getInt(1);
        
        con.desconectar();
        return id;
    }
}
