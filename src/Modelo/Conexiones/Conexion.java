/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo.Conexiones;

import Modelo.Entidades.Respuesta;
import java.sql.DriverManager;

/**
 *
 * @author Idea
 */
public class Conexion {
    
    public java.sql.Connection conexion;
    private String servidor = "jdbc:mysql://localhost/gym";
    private String usuarioDB="root";
    private String passwordDB="12345";
    
    public Conexion() throws ClassNotFoundException{
        Class.forName("com.mysql.jdbc.Driver");
    }
    
    public Respuesta conectar() throws java.sql.SQLException
    {
        try{
            conexion= DriverManager.getConnection(servidor,usuarioDB,passwordDB);
            Respuesta r = new Respuesta();
            r.exitoso = true;
            r.descripcion = "Conexion exitosa";
            System.out.println(r.descripcion);
            return r;
        }catch(Exception e){
            Respuesta r = new Respuesta();
            r.exitoso = false;
            r.descripcion = "Error al conectarse" + e.toString();
            System.out.println(r.descripcion);
            return r;
        }
    }
    
    public Respuesta ProbarConexion() throws java.sql.SQLException
    {
        return conectar();
    }

    public void desconectar() throws java.sql.SQLException
    {
        try{
            if(conexion !=null) 
                conexion.close();
            System.out.println("Desconectado correctamente");
        }catch(Exception e){
            System.out.println("Error al desconectarse");
        }
    }
    
}
