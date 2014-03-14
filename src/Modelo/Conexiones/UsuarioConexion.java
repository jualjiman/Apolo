/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo.Conexiones;

import Modelo.Entidades.Respuesta;
import Modelo.Entidades.Usuario;
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
public class UsuarioConexion {
    
    private Connection conexion;
    private Statement sentencia;
    private ResultSet rs; 
    private static Conexion con;
    private String snombre = "usuario(s)";
    
    public UsuarioConexion(){
        try {
            con = new Conexion();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(UsuarioConexion.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public boolean Existe(Usuario usuario) throws java.sql.SQLException
    {
        int n;
        boolean existe;
        String query = "";
        con.conectar();
        conexion = con.conexion;
        
        sentencia = conexion.createStatement(
        java.sql.ResultSet.TYPE_SCROLL_INSENSITIVE,
        java.sql.ResultSet.CONCUR_READ_ONLY);
        
        if(usuario.getId() == 0)
            query = "select count(*) from usuarios where usuario like '" + usuario.getNick()+ "'";
        else
            query = "select count(*) from usuarios where usuario like '" + usuario.getNick() + "' and id != " + usuario.getId();
        
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
    
    public Respuesta Insertar(Usuario usuario) throws java.sql.SQLException
    {
        try{
            String sql;
            con.conectar();
            conexion = con.conexion;

            sql="insert into usuarios(nombre,ap,am,direccion,email,telefono,nick,password,idUsuarioMod,fechaHora) "
                    + "values('" + usuario.getNombre() + "','"
                    + usuario.getAp() + "','"
                    + usuario.getAm() + "','"
                    + usuario.getDireccion()+ "','"
                    + usuario.getEmail()+ "','"
                    + usuario.getTelefono()+ "','"
                    + usuario.getNick()+ "','"
                    + usuario.getPassword()+ "',"
                    + usuario.getIdUsuarioMod() + ","
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
    
    public Respuesta Modificar(Usuario usuario) throws java.sql.SQLException
    {
        try{
            String sql;
            con.conectar();
            conexion = con.conexion;

            sql="update usuarios set "
                    + "nombre = '" + usuario.getNombre() + "', "
                    + "ap = '" + usuario.getAp() + "', "
                    + "am = '" + usuario.getAm() + "', "
                    + "direccion = '" + usuario.getDireccion() + "', "
                    + "email = '" + usuario.getEmail() + "', "
                    + "telefono = '" + usuario.getTelefono()+ "', "
                    + "nick = '" + usuario.getNick() + "', "
                    + "password = '" + usuario.getPassword()+ "', "
                    + "fechaHora = now() "
                    + "where id = " + usuario.getId();

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
            sql = "delete from usuarios where id = " + id;
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
        rs = sentencia.executeQuery("select count(*) as total from usuarios");
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
        
    public Usuario GetOne(int id) throws java.sql.SQLException
    {
        try{
            con.conectar();
            conexion = con.conexion;
            sentencia = conexion.createStatement(
                   java.sql.ResultSet.TYPE_SCROLL_INSENSITIVE,
                   java.sql.ResultSet.CONCUR_READ_ONLY);
            rs = sentencia.executeQuery("select * from usuarios where id = " + id );

            rs.next();
            Usuario usu = new Usuario();

            usu.setId(rs.getInt(1));
            usu.setNombre(rs.getString(2));
            usu.setAp(rs.getString(3));
            usu.setAm(rs.getString(4));
            usu.setDireccion(rs.getString(5));
            usu.setEmail(rs.getString(6));
            usu.setTelefono(rs.getString(7));
            usu.setNick(rs.getString(8));
            usu.setPassword(rs.getString(9));
            usu.setIdUsuarioMod(rs.getInt(10));
            usu.setFechaHora(Metodos.StringToCalendarFH(rs.getString(10)));
            
            System.out.println("Una " + snombre + " retornada");
            
            con.desconectar();
            return usu;
        }catch(Exception e){
            System.out.println("Error al retornar " + snombre + ", puede que no exista (Error: " + e.toString() + ")");
            
            con.desconectar();
            return null;
        }
    }
    public ArrayList<Usuario> Buscar(String pista) throws SQLException
    {
        try {
            ArrayList<Usuario> usuarios = new ArrayList<Usuario>();
            con.conectar();
            conexion = con.conexion;
            sentencia = conexion.createStatement(
                   java.sql.ResultSet.TYPE_SCROLL_INSENSITIVE,
                   java.sql.ResultSet.CONCUR_READ_ONLY);
            rs = sentencia.executeQuery("select * from usuarios " + 
                                        "where nick like '%" + pista.toUpperCase() +"%' order by nick");
            
            while(rs.next())
                {
                    Usuario usu = new Usuario();
                    
                    usu.setId(rs.getInt(1));
                    usu.setNombre(rs.getString(2));
                    usu.setAp(rs.getString(3));
                    usu.setAm(rs.getString(4));
                    usu.setDireccion(rs.getString(5));
                    usu.setEmail(rs.getString(6));
                    usu.setTelefono(rs.getString(7));
                    usu.setNick(rs.getString(8));
                    usu.setPassword(rs.getString(9));
                    usu.setIdUsuarioMod(rs.getInt(10));
                    usu.setFechaHora(Metodos.StringToCalendarFH(rs.getString(10)));

                    usuarios.add(usu);
                }
            
            System.out.println(usuarios.size() + " " + snombre + " retornadas");
            
            con.desconectar();
            return usuarios;
        } catch (SQLException ex) {
            System.out.println("Error al retornar las " + snombre + ", puede que no exista ninguna con la pista dada (Error: " + ex.toString() + ")");
            
            con.desconectar();
            return null;
        }
    }
    
    public ArrayList<Usuario> GetAll() throws SQLException
    {//
        try {
            ArrayList<Usuario> usuarios = new ArrayList<Usuario>();
            con.conectar();
            conexion = con.conexion;
            sentencia = conexion.createStatement(
                   java.sql.ResultSet.TYPE_SCROLL_INSENSITIVE,
                   java.sql.ResultSet.CONCUR_READ_ONLY);
            rs = sentencia.executeQuery("select * from usuarios order by nick");
            
            while(rs.next())
                {
                    Usuario usu = new Usuario();
                    
                    usu.setId(rs.getInt(1));
                    usu.setNombre(rs.getString(2));
                    usu.setAp(rs.getString(3));
                    usu.setAm(rs.getString(4));
                    usu.setDireccion(rs.getString(5));
                    usu.setEmail(rs.getString(6));
                    usu.setTelefono(rs.getString(7));
                    usu.setNick(rs.getString(8));
                    usu.setPassword(rs.getString(9));
                    usu.setIdUsuarioMod(rs.getInt(10));
                    usu.setFechaHora(Metodos.StringToCalendarFH(rs.getString(10)));

                    usuarios.add(usu);
                }
            
            System.out.println(usuarios.size() + " " + snombre + " retornadas");
            
            con.desconectar();
            return usuarios;
            
        } catch (SQLException ex) {
            System.out.println("Error al retornar las " + snombre + ", puede que no exista ninguna con la pista dada (Error: " + ex.toString() + ")");
            
            con.desconectar();
            return null;
        }
    }
}
