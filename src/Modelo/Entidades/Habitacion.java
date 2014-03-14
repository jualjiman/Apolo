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
public class Habitacion {
    private int id;
    private String nombre;
    private int capMax;
    private String desc;
    private boolean vista;
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
     * @return the capMax
     */
    public int getCapMax() {
        return capMax;
    }

    /**
     * @param capMax the capMax to set
     */
    public void setCapMax(int capMax) {
        this.capMax = capMax;
    }

    /**
     * @return the desc
     */
    public String getDesc() {
        return desc;
    }

    /**
     * @param desc the desc to set
     */
    public void setDesc(String desc) {
        this.desc = desc;
    }

    /**
     * @return the vista
     */
    public boolean isVista() {
        return vista;
    }

    /**
     * @param vista the vista to set
     */
    public void setVista(boolean vista) {
        this.vista = vista;
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
