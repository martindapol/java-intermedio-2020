/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.javaint.dao;

import com.javaint.entidades.Aplicacion;
import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

/**
 *
 * @author MARTIN
 */
public class AplicacionDaoJDBC implements AplicacionDao {

    private static final String[] PARAMS = {"jdbc:mysql://localhost:3333/example?serverTimezone=UTC", "111mil", "111mil"};

    @Override
    public List<Aplicacion> getAplicacionesDisponibles(int idUsuario) {
        List<Aplicacion> aux = new LinkedList<>();
        String query = "SELECT t.* "
                + " FROM aplicaciones  t,  aplicaciones_usuario t1"
                + " WHERE t1.id_aplicacion = t.id_aplicacion"
                + " AND t1.id_usuario <> ?";

        try(Connection cnn = DriverManager.getConnection(PARAMS[0],PARAMS[1],PARAMS[2]);
                PreparedStatement  ps= cnn.prepareStatement(query)) {
                
                ps.setInt(1, idUsuario);
                ResultSet rs =  ps.executeQuery();
               
                Aplicacion app = null;
                while(rs.next()){
                    app = new Aplicacion(rs.getInt(1), rs.getString(2),rs.getFloat(3));
                    aux.add(app);
                }
                rs.close();
            
        } catch (SQLException e) {
            throw new RuntimeException("Error al recuperar las aplicaciones disponibles!");
        }
   
        return aux;
    }

    @Override
    public Aplicacion getAplicacionById(int id) {
        return null;
    }

}
