/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.javaint;
import com.javaint.dao.UsuarioDao;
import com.javaint.dao.UsuarioDaoJDBC;
import com.javaint.entidades.Usuario;
import com.javaint.gui.JFLogin;

/**
 *
 * @author MARTIN
 */
public class Ejecutable {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws ClassNotFoundException {
        new JFLogin().setVisible(true);
    }
    
}
