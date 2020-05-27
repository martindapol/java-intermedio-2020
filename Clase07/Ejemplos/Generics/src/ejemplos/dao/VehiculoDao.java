/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejemplos.dao;

import ejemplos.generics.vehiculos.Vehiculo;
import java.util.List;

/**
 * Esta interface define las operaciones para consultar una
 * lista de vehículos en memoria
 * @author MARTIN
 */
public interface VehiculoDao {
    List<Vehiculo> getAll();
    Vehiculo getByPatente(String patente);
    List<Vehiculo> getPatentesViejas();
    List<Vehiculo> getPatentesNuevas();
}
