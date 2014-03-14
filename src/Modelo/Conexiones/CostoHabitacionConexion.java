/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo.Conexiones;

import Modelo.Entidades.CostoHabitacion;
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
public class CostoHabitacionConexion {
    
    private Connection conexion;
    private Statement sentencia;
    private ResultSet rs; 
    private static Conexion con;
    private String snombre = "costo(s) de habitacion(es)";
    
    public CostoHabitacionConexion(){
        try {
            con = new Conexion();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(CostoHabitacionConexion.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public boolean Existe(CostoHabitacion coshab) throws java.sql.SQLException
    {
        int n;
        boolean existe;
        String query = "";
        con.conectar();
        conexion = con.conexion;
        
        sentencia = conexion.createStatement(
        java.sql.ResultSet.TYPE_SCROLL_INSENSITIVE,
        java.sql.ResultSet.CONCUR_READ_ONLY);
        
        if(coshab.getId() == 0)
            query = "select count(*) from costohabitaciones where nombre like '" + coshab.getNombre() + "' and idhabitacion = " + coshab.getIdHabitacion();
        else
            query = "select count(*) from costohabitaciones where nombre like '" + coshab.getNombre() + "' and idhabitacion = " + coshab.getIdHabitacion() + " and id != " + coshab.getId();
        
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
    
    public Respuesta Insertar(CostoHabitacion coshab) throws java.sql.SQLException
    {
        try{
            String sql;
            con.conectar();
            conexion = con.conexion;

            sql="insert into costoHabitaciones(idhabitacion,fini,ffin,costo,nombre,idUsuarioMod,fechaHora) "
                    + "values(" + coshab.getIdHabitacion() + ",'"
                    + Metodos.CalendarToString(coshab.getFini()) + "','"
                    + Metodos.CalendarToString(coshab.getFfin()) + "',"
                    + coshab.getCosto() + ",'"
                    + coshab.getNombre() + "',"
                    + coshab.getIdUsuarioMod() + ","
                    + "now())";
            sentencia = conexion.createStatement();
            sentencia.execute(sql);
            if(sentencia != null)
                sentencia.close();
            
            Respuesta r = new Respuesta();
            r.exitoso = true;
            r.descripcion = "OK";
            r.descripcion = "Insercion de " + snombre + " exitosa";
            System.out.println(r.descripcion);
            
            con.desconectar();
            return r;
        }catch(Exception e){
            Respuesta r = new Respuesta();
            r.exitoso = false;
            r.descripcion = e.toString();
            r.descripcion = "Error al insertar " + snombre + " " + e.toString();
            System.out.println(r.descripcion);
            
            con.desconectar();
            return r;
        }
    }
    
    public Respuesta Modificar(CostoHabitacion coshab) throws java.sql.SQLException
    {
        try{
            String sql;
            con.conectar();
            conexion = con.conexion;

            sql="update costoHabitaciones set "
                    + "idHabitacion = " + coshab.getIdHabitacion() + ", "
                    + "fini = '" + Metodos.CalendarToString(coshab.getFini()) + "', "
                    + "ffin = '" + Metodos.CalendarToString(coshab.getFfin()) + "', "
                    + "costo = " + coshab.getCosto() + ", "
                    + "nombre = '" + coshab.getNombre() + "', "
                    + "idUsuarioMod = " + coshab.getIdUsuarioMod() + ", "
                    + "fechaHora = now() "
                    + "where id = " + coshab.getId();

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
            sql = "delete from costohabitaciones where id = " + id;
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
        rs = sentencia.executeQuery("select count(*) as total from costohabitaciones");
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
        
    public CostoHabitacion GetOne(int id) throws java.sql.SQLException
    {
        try{
            con.conectar();
            conexion = con.conexion;
            sentencia = conexion.createStatement(
                   java.sql.ResultSet.TYPE_SCROLL_INSENSITIVE,
                   java.sql.ResultSet.CONCUR_READ_ONLY);
            rs = sentencia.executeQuery("select * from costohabitaciones where id = " + id );

            rs.next();
            CostoHabitacion coshab = new CostoHabitacion();

            coshab.setId(rs.getInt(1));
            coshab.setIdHabitacion(rs.getInt(2));
            coshab.setFechaHora(Metodos.StringToCalendarF(rs.getString(3)));
            coshab.setFechaHora(Metodos.StringToCalendarF(rs.getString(4)));
            coshab.setCosto(rs.getFloat(5));
            coshab.setNombre(rs.getString(6));
            coshab.setIdUsuarioMod(rs.getInt(7));
            coshab.setFechaHora(Metodos.StringToCalendarFH(rs.getString(8)));
            System.out.println("Un " + snombre + " retornada");
            
            con.desconectar();
            return coshab;
        }
        catch(Exception e){
            System.out.println("Error al retornar " + snombre + ", puede que no exista (Error: " + e.toString() + ")");
            
            con.desconectar();
            return null;
        }
    }
    
    public ArrayList<CostoHabitacion> Buscar(String pista,int idhabitacion) throws SQLException
    {
        try {
            ArrayList<CostoHabitacion> coshabs = new ArrayList<CostoHabitacion>();
            con.conectar();
            conexion = con.conexion;
            sentencia = conexion.createStatement(
                   java.sql.ResultSet.TYPE_SCROLL_INSENSITIVE,
                   java.sql.ResultSet.CONCUR_READ_ONLY);
            rs = sentencia.executeQuery("select * from costohabitaciones " + 
                                        "where nombre like '%" + pista.toUpperCase() +"%' and idhabitacion = " + idhabitacion + " order by nombre");
            
            while(rs.next())
            {
                    CostoHabitacion coshab = new CostoHabitacion();
                    
                    coshab.setId(rs.getInt(1));
                    coshab.setIdHabitacion(rs.getInt(2));
                    coshab.setFechaHora(Metodos.StringToCalendarF(rs.getString(3)));
                    coshab.setFechaHora(Metodos.StringToCalendarF(rs.getString(4)));
                    coshab.setCosto(rs.getFloat(5));
                    coshab.setNombre(rs.getString(6));
                    coshab.setIdUsuarioMod(rs.getInt(7));
                    coshab.setFechaHora(Metodos.StringToCalendarFH(rs.getString(8)));
                    
                    coshabs.add(coshab);
            }
            
            System.out.println(coshabs.size() + " " + snombre + " retornadas");
            
            con.desconectar();
            return coshabs;
        } catch (SQLException ex) {
            System.out.println("Error al retornar las " + snombre + ", puede que no exista ninguna con la pista dada (Error: " + ex.toString() + ")");
            con.desconectar();
            return null;
        }
    }
    
    public ArrayList<CostoHabitacion> GetAll() throws SQLException
    {//
        try {
            ArrayList<CostoHabitacion> coshabs = new ArrayList<CostoHabitacion>();
            con.conectar();
            conexion = con.conexion;
            sentencia = conexion.createStatement(
                   java.sql.ResultSet.TYPE_SCROLL_INSENSITIVE,
                   java.sql.ResultSet.CONCUR_READ_ONLY);
            rs = sentencia.executeQuery("select * from habitaciones order by nombre");
            
            while(rs.next())
                {
                    CostoHabitacion coshab = new CostoHabitacion();
                    
                    coshab.setId(rs.getInt(1));
                    coshab.setIdHabitacion(rs.getInt(2));
                    coshab.setFechaHora(Metodos.StringToCalendarF(rs.getString(3)));
                    coshab.setFechaHora(Metodos.StringToCalendarF(rs.getString(4)));
                    coshab.setCosto(rs.getFloat(5));
                    coshab.setNombre(rs.getString(6));
                    coshab.setIdUsuarioMod(rs.getInt(7));
                    coshab.setFechaHora(Metodos.StringToCalendarFH(rs.getString(8)));
                    
                    coshabs.add(coshab);
                }
            System.out.println(coshabs.size() + " " + snombre + " retornadas");
            con.desconectar();
            return coshabs;
            
        } catch (SQLException ex) {
            System.out.println("Error al retornar las " + snombre + ", puede que no exista ninguna con la pista dada (Error: " + ex.toString() + ")");
            con.desconectar();
            return null;
        }
    }
}
