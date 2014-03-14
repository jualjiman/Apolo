/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo.Entidades;

import java.util.Calendar;

/**
 *
 * @author Idea
 */
public class Usuario {
    private int id;
    private String nombre;
    private String ap;
    private String am;
    private String direccion;
    private String email;
    private String telefono;
    private String nick;
    private String password;
    private int idUsuarioMod;
    private Calendar fechaHora;

    /**
     * @return the id
     */
    public int getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * @return the nombre
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * @param nombre the nombre to set
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * @return the ap
     */
    public String getAp() {
        return ap;
    }

    /**
     * @param ap the ap to set
     */
    public void setAp(String ap) {
        this.ap = ap;
    }

    /**
     * @return the am
     */
    public String getAm() {
        return am;
    }

    /**
     * @param am the am to set
     */
    public void setAm(String am) {
        this.am = am;
    }

    /**
     * @return the direccion
     */
    public String getDireccion() {
        return direccion;
    }

    /**
     * @param direccion the direccion to set
     */
    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    /**
     * @return the email
     */
    public String getEmail() {
        return email;
    }

    /**
     * @param email the email to set
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * @return the telefono
     */
    public String getTelefono() {
        return telefono;
    }

    /**
     * @param telefono the telefono to set
     */
    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    /**
     * @return the nick
     */
    public String getNick() {
        return nick;
    }

    /**
     * @param nick the nick to set
     */
    public void setNick(String nick) {
        this.nick = nick;
    }

    /**
     * @return the password
     */
    public String getPassword() {
        return password;
    }

    /**
     * @param password the password to set
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * @return the idUsuarioMod
     */
    public int getIdUsuarioMod() {
        return idUsuarioMod;
    }

    /**
     * @param idUsuarioMod the idUsuarioMod to set
     */
    public void setIdUsuarioMod(int idUsuarioMod) {
        this.idUsuarioMod = idUsuarioMod;
    }

    /**
     * @return the fechaHora
     */
    public Calendar getFechaHora() {
        return fechaHora;
    }

    /**
     * @param fechaHora the fechaHora to set
     */
    public void setFechaHora(Calendar fechaHora) {
        this.fechaHora = fechaHora;
    }
    
}
