/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.javaint.dao;

import com.javaint.entidades.Usuario;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author MARTIN
 */
public class UsuarioDaoJDBC implements UsuarioDao {

   private static final String[] PARAMS = {"jdbc:mysql://localhost:3333/example?serverTimezone=UTC", "111mil", "111mil"};

  @Override
    public boolean create(Usuario u) {
        int rows = 0;
        try (Connection cnn = DriverManager.getConnection(PARAMS[0], PARAMS[1], PARAMS[2]);
                Statement stm = cnn.createStatement()) {
            //Values('admin', '123')...
            rows = stm.executeUpdate("INSERT INTO usuarios (nombre_usuario, password) VALUES('"
                    + u.getNombre() + "','" + u.getPass().getValor() + "')");
        } catch (SQLException sqle) {
            throw new RuntimeException("Error de BD. No se pudo insertar el usuario!", sqle);
        }
        return rows == 1;
    }

    @Override
    public Usuario validate(String nombre, String pass) {
        String query = "SELECT * FROM usuarios WHERE nombre_usuario = ? AND password = ?";
        Usuario aux = null;
        try (Connection cnn = DriverManager.getConnection(PARAMS[0], PARAMS[1], PARAMS[2]);
                PreparedStatement ps = cnn.prepareStatement(query)
               ) {
           
            ps.setString(1, nombre);
            ps.setString(2, pass);
            ResultSet rs = ps.executeQuery();
            if (rs.next())
                aux = new Usuario(rs.getString(2), rs.getString(3));
            rs.close();
        } catch (SQLException sqle) {
            throw new RuntimeException("Error de BD!");
        }
        return aux;
    }

   
   
}
