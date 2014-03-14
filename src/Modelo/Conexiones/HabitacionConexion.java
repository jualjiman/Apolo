/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo.Conexiones;

import Modelo.Entidades.Habitacion;
import Modelo.Entidades.Respuesta;
import Modelo.Sistema.Metodos;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Idea
 */
public class HabitacionConexion {
    
    private Connection conexion;
    private Statement sentencia;
    private ResultSet rs; 
    private static Conexion con;
    private String snombre = "habitacion(es)";
    
    public HabitacionConexion(){
        try {
            con = new Conexion();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(HabitacionConexion.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public boolean Existe(Habitacion habitacion) throws java.sql.SQLException
    {
        int n;
        boolean existe;
        String query = "";
        con.conectar();
        conexion = con.conexion;
        
        sentencia = conexion.createStatement(
        java.sql.ResultSet.TYPE_SCROLL_INSENSITIVE,
        java.sql.ResultSet.CONCUR_READ_ONLY);
        
        if(habitacion.getId() == 0)
            query = "select count(*) from habitaciones where nombre like '" + habitacion.getNombre() + "'";
        else
            query = "select count(*) from habitaciones where nombre like '" + habitacion.getNombre() + "' and id != " + habitacion.getId();
        
        rs = sentencia.executeQuery(query);
        rs.next();
        
        n = rs.getInt(1);
        if(n == 0){
            existe = false;
            System.out.println(snombre + " no existente");
        }
        else{
            existe = true;
            System.out.println(snombre + " existente");
        }
        con.desconectar();
        return existe;
    }
    
    public Respuesta Insertar(Habitacion habitacion) throws java.sql.SQLException
    {
        try{
            String sql;
            int vista = 0;
            con.conectar();
            conexion = con.conexion;

            if(habitacion.isVista())
                vista = 1;

            sql="insert into habitaciones(nombre,capMax,descripcion,vista,idUsuarioMod,fechaHora) "
                    + "values('" + habitacion.getNombre() + "',"
                    + habitacion.getCapMax() + ",'"
                    + habitacion.getDesc() + "',"
                    + vista + ","
                    + habitacion.getIdUsuarioMod() + ","
                    + "now())";
            sentencia = conexion.createStatement();
            sentencia.execute(sql);
            if(sentencia != null)
                sentencia.close();
            
            Respuesta r = new Respuesta();
            r.exitoso = true;
            r.descripcion = "Insercion de " + snombre + " exitosa";
            System.out.println(r.descripcion);
            
            con.desconectar();
            return r;
        }catch(Exception e){
            Respuesta r = new Respuesta();
            r.exitoso = false;
            r.descripcion = "Error al insertar " + snombre + " " + e.toString();
            System.out.println(r.descripcion);
            
            con.desconectar();
            return r;
        }
    }
    
    public Respuesta Modificar(Habitacion habitacion) throws java.sql.SQLException
    {
        try{
            String sql;
            int vista = 0;
            con.conectar();
            conexion = con.conexion;

            if(habitacion.isVista())
                vista = 1;

            sql="update habitaciones set "
                    + "nombre = '" + habitacion.getNombre() + "', "
                    + "capMax = " + habitacion.getCapMax() + ", "
                    + "descripcion = '" + habitacion.getDesc() + "', "
                    + "vista = " + vista + ", "
                    + "idUsuarioMod = " + habitacion.getIdUsuarioMod() + ", "
                    + "fechaHora = now() "
                    + "where id = " + habitacion.getId();

            sentencia = conexion.createStatement();
            sentencia.execute(sql);
            if(sentencia != null)
                sentencia.close();
            
            Respuesta r = new Respuesta();
            r.exitoso = true;
            r.descripcion = "Modificacion de " + snombre + " exitosa";
            System.out.println(r.descripcion);
            
            con.desconectar();
            return r;
        }catch(Exception e){
            Respuesta r = new Respuesta();
            r.exitoso = false;
            r.descripcion = "Error al insertar " + snombre + " " + e.toString();
            System.out.println(r.descripcion);
            
            con.desconectar();
            return r;
        }
    }
    
    public Respuesta Eliminar(int id) throws java.sql.SQLException
    {
        try{
            String sql;
            con.conectar();
            conexion = con.conexion;
            sql = "delete from habitaciones where id = " + id;
            sentencia = conexion.createStatement();
            sentencia.execute(sql);
            if(sentencia != null)
                sentencia.close();
            
                   Respuesta r = new Respuesta();
            r.exitoso = true;
            r.descripcion = "Eliminacion de " + snombre + " exitosa";
            System.out.println(r.descripcion);
            
            con.desconectar();
            return r;
        }catch(Exception e){
            Respuesta r = new Respuesta();
            r.exitoso = false;
            r.descripcion = "Error al eliminar " + snombre + " " + e.toString();
            System.out.println(r.descripcion);
            
            con.desconectar();
            return r;
        }
    }
    
    public int Total() throws java.sql.SQLException
    {
        int total;
        con.conectar();
        conexion = con.conexion;
        sentencia = conexion.createStatement(
               java.sql.ResultSet.TYPE_SCROLL_INSENSITIVE,
               java.sql.ResultSet.CONCUR_READ_ONLY);
        rs = sentencia.executeQuery("select count(*) as total from habitaciones");
        rs.next();
        total = rs.getInt(1);
        System.out.println(total + " " + snombre + " existentes");
        if(rs != null)
            rs.close();
        if(sentencia != null)
            sentencia.close();
        
        con.desconectar();
        return total;
    }
        
    public Habitacion GetOne(int id) throws java.sql.SQLException
    {
        try{
            con.conectar();
            conexion = con.conexion;
            sentencia = conexion.createStatement(
                   java.sql.ResultSet.TYPE_SCROLL_INSENSITIVE,
                   java.sql.ResultSet.CONCUR_READ_ONLY);
            rs = sentencia.executeQuery("select * from habitaciones where id = " + id );

            rs.next();
            Habitacion hab = new Habitacion();

            hab.setId(rs.getInt(1));
            hab.setNombre(rs.getString(2));
            hab.setCapMax(rs.getInt(3));
            hab.setDesc(rs.getString(4));
                if(rs.getInt(5) == 1)
                    hab.setVista(true);
                else
                    hab.setVista(false);
            hab.setIdUsuarioMod(rs.getInt(6));
            hab.setFechaHora(Metodos.StringToCalendarFH(rs.getString(7)));
            
            System.out.println("Una " + snombre + " retornada");
            
            con.desconectar();
            return hab;
        }catch(Exception e){
            System.out.println("Error al retornar " + snombre + ", puede que no exista (Error: " + e.toString() + ")");
            
            con.desconectar();
            return null;
        }
    }
    public ArrayList<Habitacion> Buscar(String pista) throws SQLException
    {
        try {
            ArrayList<Habitacion> habitaciones = new ArrayList<Habitacion>();
            con.conectar();
            conexion = con.conexion;
            sentencia = conexion.createStatement(
                   java.sql.ResultSet.TYPE_SCROLL_INSENSITIVE,
                   java.sql.ResultSet.CONCUR_READ_ONLY);
            rs = sentencia.executeQuery("select * from habitaciones " + 
                                        "where nombre like '%" + pista.toUpperCase() +"%' order by nombre");
            
            while(rs.next())
                {
                    Habitacion habitacion = new Habitacion();
                    
                    habitacion.setId(rs.getInt(1));
                    habitacion.setNombre(rs.getString(2));
                    habitacion.setCapMax(rs.getInt(3));
                    habitacion.setDesc(rs.getString(4));
                        if(rs.getInt(5) == 1)
                            habitacion.setVista(true);
                        else
                            habitacion.setVista(false);
                    habitacion.setIdUsuarioMod(rs.getInt(6));
                    habitacion.setFechaHora(Metodos.StringToCalendarFH(rs.getString(7)));
                    
                    habitaciones.add(habitacion);
                }
            
            System.out.println(habitaciones.size() + " " + snombre + " retornadas");
            
            con.desconectar();
            return habitaciones;
        } catch (SQLException ex) {
            System.out.println("Error al retornar las " + snombre + ", puede que no exista ninguna con la pista dada (Error: " + ex.toString() + ")");
            
            con.desconectar();
            return null;
        }
    }
    
    public ArrayList<Habitacion> GetAll() throws SQLException
    {//
        try {
            ArrayList<Habitacion> habitaciones = new ArrayList<Habitacion>();
            con.conectar();
            conexion = con.conexion;
            sentencia = conexion.createStatement(
                   java.sql.ResultSet.TYPE_SCROLL_INSENSITIVE,
                   java.sql.ResultSet.CONCUR_READ_ONLY);
            rs = sentencia.executeQuery("select * from habitaciones order by nombre");
            
            while(rs.next())
                {
                    Habitacion habitacion = new Habitacion();
                    
                    habitacion.setId(rs.getInt(1));
                    habitacion.setNombre(rs.getString(2));
                    habitacion.setCapMax(rs.getInt(3));
                    habitacion.setDesc(rs.getString(4));
                        if(rs.getInt(5) == 1)
                            habitacion.setVista(true);
                        else
                            habitacion.setVista(false);
                    habitacion.setIdUsuarioMod(rs.getInt(6));
                    habitacion.setFechaHora(Metodos.StringToCalendarFH(rs.getString(7)));
                    
                    habitaciones.add(habitacion);
                }
            
            System.out.println(habitaciones.size() + " " + snombre + " retornadas");
            
            con.desconectar();
            return habitaciones;
            
        } catch (SQLException ex) {
            System.out.println("Error al retornar las " + snombre + ", puede que no exista ninguna con la pista dada (Error: " + ex.toString() + ")");
            
            con.desconectar();
            return null;
        }
    }
}
