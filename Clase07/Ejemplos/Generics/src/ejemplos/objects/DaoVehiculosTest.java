/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejemplos.objects;

import ejemplos.dao.FileVehiculoDao;
import ejemplos.dao.VehiculoDao;
import ejemplos.generics.vehiculos.Vehiculo;
import java.util.List;

/**
 *
 * @author MARTIN
 */
public class DaoVehiculosTest {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        //Crear el dao:
        VehiculoDao dao = new FileVehiculoDao();
        List<Vehiculo> lst = dao.getAll();
        if (lst != null) {
            for (Vehiculo v : lst) {
                System.out.println(v.toString());
            }
        } else {
            System.out.println("Sin datos de vehículos!");
        }

    }
}
