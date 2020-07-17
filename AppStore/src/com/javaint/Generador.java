/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.javaint;

import com.javaint.dao.UsuarioDao;
import com.javaint.dao.UsuarioDaoFile;
import com.javaint.entidades.Usuario;

/**
 *
 * @author george
 */
public class Generador {

    public static void main(String[] args) {
        UsuarioDao dao = new UsuarioDaoFile();

        Usuario u = new Usuario(1, "nuevo", "nuevo");
        dao.create(u);
    }

}
