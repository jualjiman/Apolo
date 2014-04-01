/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Vistas;

import Modelo.Sistema.Colores;
import Modelo.Sistema.MetodosVentana;
import javax.swing.JOptionPane;
import javax.swing.border.MatteBorder;

/**
 *
 * @author Idea
 */
public class AdministrarMedidasCliente extends javax.swing.JDialog {

    /**
     * Creates new form NuevoUsuario
     */
    private final MatteBorder borde = new MatteBorder(1,1,1,1,Colores.MenuShadow);
    public AdministrarMedidasCliente(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        this.setLocationRelativeTo(null);
        this.getContentPane().setBackground( Colores.WorkspaceBackground );
        this.getRootPane().setBorder(borde);
       inicializar();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        menuBar1 = new Modelo.Controles.MenuBar(this);
        labelTitle1 = new Modelo.Controles.LabelTitle();
        labelIdentifier1 = new Modelo.Controles.LabelIdentifier();
        tfNombre = new Modelo.Controles.TextField();
        labelIdentifier2 = new Modelo.Controles.LabelIdentifier();
        tfAlmacen = new Modelo.Controles.TextField();
        labelIdentifier3 = new Modelo.Controles.LabelIdentifier();
        tfDescripcion = new Modelo.Controles.TextField();
        labelIdentifier4 = new Modelo.Controles.LabelIdentifier();
        tfPrecioVenta = new Modelo.Controles.TextField();
        btAceptar = new Modelo.Controles.ButtonNormalV();
        btCancelar = new Modelo.Controles.ButtonNormalR();
        labelIdentifier6 = new Modelo.Controles.LabelIdentifier();
        labelIdentifier8 = new Modelo.Controles.LabelIdentifier();
        tfPrecioCompra = new Modelo.Controles.TextField();
        tfStock = new Modelo.Controles.TextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setUndecorated(true);

        javax.swing.GroupLayout menuBar1Layout = new javax.swing.GroupLayout(menuBar1);
        menuBar1.setLayout(menuBar1Layout);
        menuBar1Layout.setHorizontalGroup(
            menuBar1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        menuBar1Layout.setVerticalGroup(
            menuBar1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 71, Short.MAX_VALUE)
        );

        labelTitle1.setText("NUEVO ARTICULO");

        labelIdentifier1.setText("nombre");

        tfNombre.setNextFocusableComponent(tfAlmacen);

        labelIdentifier2.setText("almacen");

        tfAlmacen.setNextFocusableComponent(tfDescripcion);

        labelIdentifier3.setText("descripción");

        tfDescripcion.setNextFocusableComponent(tfPrecioCompra);

        labelIdentifier4.setText("precio venta");

        btAceptar.setText("5");
        btAceptar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btAceptarActionPerformed(evt);
            }
        });

        btCancelar.setText("6");
        btCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btCancelarActionPerformed(evt);
            }
        });

        labelIdentifier6.setText("stock");

        labelIdentifier8.setText("precio compra");

        tfStock.setNextFocusableComponent(tfDescripcion);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(tfPrecioCompra, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(labelIdentifier8, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(tfPrecioVenta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(labelIdentifier4, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(labelTitle1, javax.swing.GroupLayout.PREFERRED_SIZE, 252, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGroup(layout.createSequentialGroup()
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(labelIdentifier3, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(tfNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(labelIdentifier1, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(tfDescripcion, javax.swing.GroupLayout.PREFERRED_SIZE, 474, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(tfAlmacen, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(labelIdentifier2, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGap(18, 18, 18)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(labelIdentifier6, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(tfStock, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(btCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(btAceptar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                            .addGap(30, 30, 30)))))
            .addComponent(menuBar1, javax.swing.GroupLayout.DEFAULT_SIZE, 534, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(menuBar1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30)
                .addComponent(labelTitle1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(labelIdentifier1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(tfNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 18, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(labelIdentifier4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(tfPrecioVenta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(labelIdentifier8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(tfPrecioCompra, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labelIdentifier2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(labelIdentifier6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tfAlmacen, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tfStock, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(labelIdentifier3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(tfDescripcion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btAceptar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(46, 46, 46))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btCancelarActionPerformed
        this.setVisible(false);
        this.dispose();
    }//GEN-LAST:event_btCancelarActionPerformed

    private void btAceptarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btAceptarActionPerformed
        if(!Validar())
            JOptionPane.showMessageDialog(this, "Incompleto");
    }//GEN-LAST:event_btAceptarActionPerformed

    private void inicializar(){
        this.tfNombre.setPlaceholder("¿Cual es el nombre del articulo?");
        this.tfAlmacen.setPlaceholder("¿Cantidad disponible en almacen?");
        this.tfStock.setPlaceholder("¿Cantidad minima en almacen?");
        this.tfDescripcion.setPlaceholder("Describa el articulo");
        this.tfPrecioVenta.setPlaceholder("¿Cual es el precio de venta?");
        this.tfPrecioCompra.setPlaceholder("¿Cual es el precio de compra?");
    }
    
    private boolean Validar(){
        boolean ok = true;
        if(this.tfNombre.getText().equals(this.tfNombre.getPlaceholder())){
            this.tfNombre.setErrorStatus(true);
            ok = false;
        }
        if(this.tfAlmacen.getText().equals(this.tfAlmacen.getPlaceholder())){
            this.tfAlmacen.setErrorStatus(true);
            ok = false;
        }
        if(this.tfAlmacen.getText().equals(this.tfAlmacen.getPlaceholder())){
            this.tfAlmacen.setErrorStatus(true);
            ok = false;
        }
        if(this.tfStock.getText().equals(this.tfStock.getPlaceholder())){
            this.tfStock.setErrorStatus(true);
            ok = false;
        }
        if(this.tfPrecioVenta.getText().equals(this.tfPrecioVenta.getPlaceholder())){
            this.tfPrecioVenta.setErrorStatus(true);
            ok = false;
        }
        if(this.tfPrecioCompra.getText().equals(this.tfPrecioCompra.getPlaceholder())){
            this.tfPrecioCompra.setErrorStatus(true);
            ok = false;
        }
//        String n = new String(pfContraseña.getPassword());
//        JOptionPane.showMessageDialog(this,n);
        return ok;
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private Modelo.Controles.ButtonNormalV btAceptar;
    private Modelo.Controles.ButtonNormalR btCancelar;
    private Modelo.Controles.LabelIdentifier labelIdentifier1;
    private Modelo.Controles.LabelIdentifier labelIdentifier2;
    private Modelo.Controles.LabelIdentifier labelIdentifier3;
    private Modelo.Controles.LabelIdentifier labelIdentifier4;
    private Modelo.Controles.LabelIdentifier labelIdentifier6;
    private Modelo.Controles.LabelIdentifier labelIdentifier8;
    private Modelo.Controles.LabelTitle labelTitle1;
    private Modelo.Controles.MenuBar menuBar1;
    private Modelo.Controles.TextField tfAlmacen;
    private Modelo.Controles.TextField tfDescripcion;
    private Modelo.Controles.TextField tfNombre;
    private Modelo.Controles.TextField tfPrecioCompra;
    private Modelo.Controles.TextField tfPrecioVenta;
    private Modelo.Controles.TextField tfStock;
    // End of variables declaration//GEN-END:variables
}
