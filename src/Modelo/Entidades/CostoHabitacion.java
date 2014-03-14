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
public class CostoHabitacion {
    private int id;
    private int idHabitacion;
    private Calendar fini;
    private Calendar ffin;
    private float costo;
    private String nombre;
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
     * @return the idHabitacion
     */
    public int getIdHabitacion() {
        return idHabitacion;
    }

    /**
     * @param idHabitacion the idHabitacion to set
     */
    public void setIdHabitacion(int idHabitacion) {
        this.idHabitacion = idHabitacion;
    }

    /**
     * @return the fini
     */
    public Calendar getFini() {
        return fini;
    }

    /**
     * @param fini the fini to set
     */
    public void setFini(Calendar fini) {
        this.fini = fini;
    }

    /**
     * @return the ffin
     */
    public Calendar getFfin() {
        return ffin;
    }

    /**
     * @param ffin the ffin to set
     */
    public void setFfin(Calendar ffin) {
        this.ffin = ffin;
    }

    /**
     * @return the costo
     */
    public float getCosto() {
        return costo;
    }

    /**
     * @param costo the costo to set
     */
    public void setCosto(float costo) {
        this.costo = costo;
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
    
}
