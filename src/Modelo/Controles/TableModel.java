/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Modelo.Controles;

/**
 *
 * @author PACO
 */
public class TableModel extends javax.swing.table.AbstractTableModel
{
private String[] columnNames;
    private Object[][] data;

    public TableModel(String col[],Object d[][],int x,int y)
    {
        //java.lang.System.arraycopy( col, 0, columnNames, 0, col.length);

        columnNames = new String[col.length];
        for(int i=0;i<col.length;i++)
            columnNames[i]=col[i];
        data = new Object[x][y];
        for(int i=0; i<x;i++)
        {
            for(int j=0;j<y;j++)
            {
                data[i][j]=d[i][j];
            }
        }
    }
    //únicamente retornamos el numero de elementos del
    //array de los nombres de las columnas
    public int getColumnCount() {
        return columnNames.length;
    }

    //retormanos el numero de elementos
    //del array de datos
    public int getRowCount() {
        return data.length;
    }

    //retornamos el elemento indicado
    public String getColumnName(int col) {
        return columnNames[col];
    }

    //y lo mismo para las celdas
    public Object getValueAt(int row, int col) {
        return data[row][col];
    }

    /*
     * Este metodo sirve para determinar el editor predeterminado
     * para cada columna de celdas
     */
    public Class getColumnClass(int c) {
        return getValueAt(0, c).getClass();
    }

    /*
     * No tienes que implementar este método a menos que
     * las celdas de tu tabla sean Editables
     */
    /*public boolean isCellEditable(int row, int col) {
            return true;
    }*/

    /*
     * No tienes que implementar este método a menos que
     * los datos de tu tabla cambien
     */
    public void setValueAt(Object value, int row, int col) {
        data[row][col] = value;
        fireTableCellUpdated(row, col);
    }

}
