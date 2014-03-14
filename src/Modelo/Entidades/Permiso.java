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
public class Permiso {
    private int id;
    private int idusuario;
    private int modulo;
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
     * @return the idusuario
     */
    public int getIdusuario() {
        return idusuario;
    }

    /**
     * @param idusuario the idusuario to set
     */
    public void setIdusuario(int idusuario) {
        this.idusuario = idusuario;
    }

    /**
     * @return the modulo
     */
    public int getModulo() {
        return modulo;
    }

    /**
     * @param modulo the modulo to set
     */
    public void setModulo(int modulo) {
        this.modulo = modulo;
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
