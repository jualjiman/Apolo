/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo.Controles;

import Modelo.Sistema.Colores;
import Modelo.Sistema.Fuentes;
import java.awt.Dimension;
import java.awt.Frame;
import static java.awt.Frame.MAXIMIZED_BOTH;
import java.awt.Graphics;
import java.awt.GraphicsConfiguration;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowStateListener;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import sun.java2d.SunGraphicsEnvironment;

/**
 *
 * @author Idea
 */
public class ButtonAdmWindow extends JButton{
    
    private JFrame parentf;
    private JDialog parentd;
    
    private Dimension size;
    private final Dimension defaultDimension = new Dimension(25,20);
    private String[] tipos = {"minimizar","maximizar","restaurar","cerrar"};
    private int tipo = 0;
    private boolean activo = false;
    //0 - minimizar
    //1 - maximizar
    //2 - restaurar
    //3 - cerrar
    private int otipo = 0;//el tipo original
    
    public ButtonAdmWindow() {
        inicializar();
    }

    public ButtonAdmWindow(String text) {
        super(text);
        inicializar();
    }
    
    public ButtonAdmWindow(final JFrame parent){
        this.parentf = parent;
        inicializar();
        
        parentf.addWindowStateListener(new WindowStateListener(){

            @Override
            public void windowStateChanged(WindowEvent e) {
                int oldstate = e.getOldState();
                int newstate = e.getNewState();
                if(oldstate != JFrame.ICONIFIED){
                    if(newstate == JFrame.MAXIMIZED_BOTH)
                    {
                        if(otipo == 2 || otipo == 1)
                        tipo = 2;
                    }
                    else if(newstate == JFrame.NORMAL){
                        if(otipo == 2 || otipo == 1)
                        tipo = 1;
                    }
                }
                else{
                    GraphicsConfiguration config = parentf.getGraphicsConfiguration();
                    Rectangle usableBounds = SunGraphicsEnvironment.getUsableBounds(config.getDevice());
                    parentf.setMaximizedBounds(usableBounds);
                    parentf.setExtendedState(MAXIMIZED_BOTH);
                }
            }
            
        });
        
        this.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(tipo == 0){//minimizar
                    parentf.setExtendedState(Frame.ICONIFIED);
                }else if(tipo == 1){//maximizar
                    parentf.setExtendedState(JFrame.MAXIMIZED_BOTH);////<--------covers taskbar
                    //alternative way
                    //Dimension d = Toolkit.getDefaultToolkit().getScreenSize();  
                    //parentf.setSize(d.width, d.height-40);//<---take 40 off the height  
                    tipo = 2;
                }else if(tipo == 2){//restaurar
                    parentf.setExtendedState(JFrame.NORMAL);
                    tipo = 1;
                }else if(tipo == 3){//cerrar
                    parentf.setVisible(false);
                    parentf.dispose();
                    System.exit(0);
                }
            }
        });
    }
    
    public ButtonAdmWindow(final JDialog parent){
        this.parentd = parent;
        inicializar();
        
        if(tipo != 3 && activo)
            System.out.println("Los JDialog solamente deberian llevar un boton para cerrar la ventana");
        parentd.addWindowStateListener(new WindowStateListener(){

            @Override
            public void windowStateChanged(WindowEvent e) {
                int newstate = e.getNewState();
                if(newstate == JFrame.MAXIMIZED_BOTH)
                {
                    if(otipo == 2 || otipo == 1)
                    tipo = 2;
                }
                else if(newstate == JFrame.NORMAL){
                    if(otipo == 2 || otipo == 1)
                    tipo = 1;
                }
            }  
        });
        
        this.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //Al ser un JDialog no debe poderse minimizar ni maximizar solo cerrarse
                parentd.setVisible(false);
                    parentd.dispose();
            }
        });
    }
    
    private void inicializar(){
        super.setContentAreaFilled(false);
        super.setFocusPainted(false);
        super.setBorderPainted(true);
        super.setBackground(Colores.VButton);
        super.setForeground(Colores.VButtonForeground);
        super.setText("F");
        super.setPreferredSize(defaultDimension);
        super.setFont(Fuentes.getVerdana(10));
    }
    
    @Override
    protected void paintComponent(Graphics g) {
        size = this.getPreferredSize();
        if (getModel().isPressed()) {
            if(tipo == 3){//cerrar
                g.setColor(Colores.VButtonExitPressed);
                this.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/icons/btcW.png")));
            }else if(tipo == 2){//restaurar
                g.setColor(Colores.VButtonPressed);
                this.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/icons/btrW.png")));
            }else if(tipo == 1){//maximizar
                g.setColor(Colores.VButtonPressed);
                this.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/icons/btmaxW.png")));
            }else if(tipo == 0){//minimizar
                g.setColor(Colores.VButtonPressed);
                this.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/icons/btmW.png")));
            }
            
        } else if (getModel().isRollover()) {
            if(tipo == 3){
                g.setColor(Colores.VButtonHoverExit);
            }
            else if(tipo == 2){
                g.setColor(Colores.VButtonHover);
                this.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/icons/btrB.png")));
            }
            else if(tipo == 1){
                g.setColor(Colores.VButtonHover);
                this.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/icons/btmaxB.png")));
            }
            else if(tipo == 0){
                g.setColor(Colores.VButtonHover);
                this.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/icons/btmB.png")));
            }
        }else {            
            if(tipo == 3){
                g.setColor(getBackground());
                this.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/icons/btcW.png")));
            }else if(tipo == 2){
                g.setColor(getBackground());
                this.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/icons/btrW.png")));
            }else if(tipo == 1){
                g.setColor(getBackground());
                this.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/icons/btmaxW.png")));
            }else if(tipo == 0){
                g.setColor(getBackground());
                this.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/icons/btmW.png")));
            }
        }
        g.fillRect(0, 0, getWidth(), getHeight());
        
        this.setPreferredSize(size);
        super.paintComponent(g);
    }

    /**
     * @return the tipo
     */
    public String getSTipo() {
        return tipos[tipo];
    }
    
        /**
     * @return the tipo
     */
    public int getTipo() {
        return tipo;
    }

    /**
     * @param tipo the tipo to set
     */
    public void setTipo(int tipo) {
        this.tipo = tipo;
        this.otipo = tipo;
        this.activo = true;
    }
}
