/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.dao;

import com.example.entidades.Usuario;

/**
 *
 * @author MARTIN
 */
public interface UsuarioDao {
    public boolean create(Usuario u);
    public Usuario validate(String nombre, String pass);
}
