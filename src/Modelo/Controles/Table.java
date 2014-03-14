/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Modelo.Controles;

import Modelo.Sistema.Colores;
import java.awt.Color;
import javax.swing.JTable;
import javax.swing.border.MatteBorder;
import javax.swing.table.JTableHeader;

/**
 *
 * @author Betto
 */
public class Table extends JTable{
    
    private final MatteBorder borde = new MatteBorder(0,1,0,0,Colores.NButton);
    private JTableHeader header;
    
    public Table() {
        inicializar();
    }
    
    private void inicializar(){
        //super.setFont(Fuentes.getVerdana(11));
        super.setGridColor(Colores.GrisClaro);
        super.getTableHeader().setReorderingAllowed(false);  
        super.setRowHeight(23);
        super.setBorder(borde);
        super.setSelectionBackground(new Color(217,229,254));
        header = this.getTableHeader();
        header.setForeground(Colores.GrisIntermedio);
        //scroll = (JScrollPane) this.getParent();
        //this.setBorder(BorderFactory.createLineBorder(Color.RED,1)); // HERE  
        this.setBorder(null);//
    }
}
