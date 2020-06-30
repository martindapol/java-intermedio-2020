/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.servicios;

import com.example.dao.UsuarioDao;
import com.example.dao.UsuarioDaoFile;
import com.example.entidades.Usuario;

/**
 *
 * @author MARTIN Una clase de servicios que nos conecte con los datos y no
 * resuelva la lógica de negocio.
 */
public class Gestor {

    private UsuarioDao dao;
    private Usuario userLog;

    public Usuario getUserLog() {
        return userLog;
    }

    public Gestor() {
        dao = new UsuarioDaoFile();
    }

    public boolean login(String user, String pass) {
        userLog = dao.validate(user, pass);      
        return userLog != null;
    }
}
