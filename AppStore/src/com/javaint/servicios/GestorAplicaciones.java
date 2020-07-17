/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.javaint.servicios;

import com.javaint.dao.AplicacionDao;
import com.javaint.dao.AplicacionDaoJDBC;
import com.javaint.entidades.Aplicacion;
import com.javaint.entidades.Usuario;
import java.util.List;

/**
 *
 * @author george
 */
public class GestorAplicaciones {

    private final Usuario usuario;
    private final AplicacionDao appDAO;

    public GestorAplicaciones(Usuario usuario) {
        this.appDAO = new AplicacionDaoJDBC();
        this.usuario = usuario;
    }
    
    public List<Aplicacion> buscarAplicacionesDisponibles(){
        return this.appDAO.getAplicacionesDisponibles(this.usuario.getId());
    }
    
    public List<Aplicacion> buscarAplicacionesDisponibles(String name){
        return this.appDAO.getAplicacionesDisponiblesFiltradas(this.usuario.getId(), name);
    }
    

}
