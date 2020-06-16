/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejemplos.dao;

import ejemplos.generics.vehiculos.Vehiculo;
import java.io.FileNotFoundException;
import java.util.List;

/**
 * Esta interface define las operaciones para consultar una
 * lista de vehículos en memoria
 * @author MARTIN
 */
public interface VehiculoDao {
    List<Vehiculo> getAll() throws DAOException;
    Vehiculo getByPatente(String patente) throws DAOException;
    List<Vehiculo> getPatentesViejas() throws DAOException;
    List<Vehiculo> getPatentesNuevas() throws DAOException;
}
