/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo.Controles;

import Modelo.Sistema.Colores;
import Modelo.Sistema.Fuentes;
import java.awt.Dimension;
import java.awt.Graphics;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Timer;
import java.util.TimerTask;
import javax.swing.JPanel;
import javax.swing.border.MatteBorder;

/**
 *
 * @author Idea
 */
public class Footer extends JPanel{
    
    private Dimension size;
    private final Dimension defaultDimension = new Dimension(300,30);
    private final MatteBorder borde = new MatteBorder(0,10,0,0,Colores.FooterShadow);
    private Timer temporizador ;
    Calendar rightNow;
    DateFormat dateFormat;
    DateFormat timeFormat;
    TimerTask timerTask;
    private String texto = "Listo";
    private String fecha = "-";
    private String hora = "-";
    
    private int x = 0;
    private String precios = "Mensualidad : $450.00   Visita : $30.00";
    
    private Dimension d;
    
    public Footer(){
        inicializar();
    }
    
    private void inicializar(){
        super.setPreferredSize(defaultDimension);
        super.setBackground(Colores.Footer);
        super.setBorder(borde);
        super.setForeground(Colores.FooterForeground);
        super.setFont(Fuentes.getVerdana(11));
        temporizador = new Timer();
        
        timerTask = new TimerTask() 
        { 
            @Override
            public void run()  
            { 
                redibujarBarra();
            } 
        }; 
        
        temporizador.scheduleAtFixedRate(timerTask, 0, 10000);
    }
    
    public void redibujarBarra(){
        rightNow = Calendar.getInstance();
        dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        fecha = dateFormat.format(rightNow.getTime());

        timeFormat = new SimpleDateFormat("hh:mm aa");
        hora = timeFormat.format(rightNow.getTime());
        x++;
        texto = "Listo";
        this.repaint();
        
    }
    
//    THREAD
//    thread_timer ht = new thread_timer();
//    ht.start();
    
//    public class thread_timer extends Thread {
//      @Override
//      public void run() {

//           
//      }
//    }
    
    @Override
    protected void paintComponent(Graphics g) {
        size = this.getPreferredSize();
        
        d = this.getSize();
        super.paintComponent(g);
        g.drawString(getTexto(),33, 20);
        g.drawString(getPrecios(),d.width - 400, 20);
        g.drawString(getHora(),d.width - 155, 20);
        g.drawString(getFecha(),d.width - 80, 20);
        
        this.setPreferredSize(size);
    }

    /**
     * @return the texto
     */
    public String getTexto() {
        return texto;
    }

    /**
     * @param texto the texto to set
     */
    public void setTexto(String texto) {
        this.texto = texto;
        this.x = 0;
        this.repaint();
    }

    /**
     * @return the fecha
     */
    public String getFecha() {
        return fecha;
    }

    /**
     * @param fecha the fecha to set
     */
    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    /**
     * @return the hora
     */
    public String getHora() {
        return hora;
    }

    /**
     * @param hora the hora to set
     */
    public void setHora(String hora) {
        this.hora = hora;
    }

    /**
     * @return the cambio
     */
    public String getPrecios() {
        return precios;
    }

    /**
     * @param cambio the cambio to set
     */
    public void setPrecios(String precios) {
        this.precios = precios;
    }
    
}
