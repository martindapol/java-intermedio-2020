/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clase11.test;

import clase11.dao.DAOException;
import clase11.dao.VehiculoDAO;
import clase11.dao.VehiculoDAOFileImpl;
import clase11.entidades.Automovil;
import clase11.entidades.Vehiculo;
import java.util.List;

/**
 *
 * @author george
 */
public class PruebaDAO {

    public static void main(String[] args) {
        VehiculoDAO dao = new VehiculoDAOFileImpl();

        try {

            for (Vehiculo v : dao.findAll()) {
                System.out.println(v);
            }
        } catch (DAOException de) {
            System.err.println("Error en DAO");
            de.printStackTrace();
        }
    }
}
