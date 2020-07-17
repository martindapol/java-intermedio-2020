/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.javaint.gui;

import com.javaint.entidades.Aplicacion;
import com.javaint.servicios.GestorAplicaciones;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author george
 */
public class AppTableModel extends AbstractTableModel {

    private final GestorAplicaciones gestor;
    private static final String[] NOMBRES = {"Aplicación", "Precio ($)"};
    private static final Class[] CLASES = {String.class, Float.class};
    private List<Aplicacion> datos;

    public AppTableModel(GestorAplicaciones gestorApp) {
        this.gestor = gestorApp;
        this.datos = this.gestor.buscarAplicacionesDisponibles();
    }

    
    @Override
    public int getRowCount() {
        return datos.size();
    }

    @Override
    public Object getValueAt(int row, int column) {
        Object resultado = null;
        List<Aplicacion> apps = datos;
        if (row < apps.size()) {
            Aplicacion seleccionada = apps.get(row);
            switch (column) {
                case 0:
                    resultado = seleccionada.getNombre();
                    break;
                case 1:
                    resultado = seleccionada.getPrecio();
                    break;
            }
        }

        return resultado;
    }

    @Override
    public int getColumnCount() {
        return 2;
    }

    @Override
    public String getColumnName(int column) {
        return NOMBRES[column];
    }

    @Override
    public Class<?> getColumnClass(int columnIndex) {
        return CLASES[columnIndex];
    }
    
    public Aplicacion getAplicacion(int row){
        return this.datos.get(row);
    }
    
    public void filtrar(String text){
        this.datos = this.gestor.buscarAplicacionesDisponibles(text);
        this.fireTableDataChanged();
    }
    
    public void limpiar(){
        this.datos = this.gestor.buscarAplicacionesDisponibles();
        this.fireTableDataChanged();
    }

}
