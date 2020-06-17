/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clase11.view;

import clase11.dao.DAOException;
import clase11.dao.VehiculoDAO;
import clase11.entidades.Vehiculo;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author george
 */
public class VehiculosTableModel extends AbstractTableModel {

    private final VehiculoDAO dao;

    public VehiculosTableModel(VehiculoDAO dao) {
        this.dao = dao;
    }

    @Override
    public int getRowCount() {
        try {
            return this.dao.findAll().size();
        } catch (DAOException de) {
            throw new RuntimeException("Problemas con los datos", de);
        }
    }

    @Override
    public int getColumnCount() {
        return 3;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        try {
            List<Vehiculo> todos = dao.findAll();
            Vehiculo v = todos.get(rowIndex);
            if (v != null) {
                switch (columnIndex) {
                    case 0:
                        return v.getPatente();
                    case 1:
                        return v.getModelo();
                    case 2:
                        return v.getDescripcion();
                }
            }

        } catch (DAOException e) {
            throw new RuntimeException("Problemas con los datos", e);
        }
        return null;
    }

    @Override
    public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
        super.setValueAt(aValue, rowIndex, columnIndex); //To change body of generated methods, choose Tools | Templates.
    }

    
    
    @Override
    public String getColumnName(int column) {
        switch (column) {
            case 0:
                return "Patente";
            case 1:
                return "Modelo";
            case 2:
                return "Descripción";
        }
        return null;
    }

    @Override
    public boolean isCellEditable(int rowIndex, int columnIndex) {
        if(columnIndex == 0){
            return false;
        }
        return true;
    }
    
    

}
