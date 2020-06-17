/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clase11.dao;

import clase11.entidades.Vehiculo;
import java.util.List;

/**
 *
 * @author george
 */
public interface VehiculoDAO {
    
    public void store(Vehiculo v) throws DAOException;
    
    public Vehiculo findByPatente(String patente) throws DAOException;
    
    public List<Vehiculo> findAll() throws DAOException;
    
}
