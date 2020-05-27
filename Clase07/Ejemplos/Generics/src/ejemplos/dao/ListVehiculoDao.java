/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejemplos.dao;

import ejemplos.generics.vehiculos.Automovil;
import ejemplos.generics.vehiculos.Colectivo;
import ejemplos.generics.vehiculos.Motocicleta;
import ejemplos.generics.vehiculos.Vehiculo;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author MARTIN
 */
public class ListVehiculoDao implements VehiculoDao{

    private List<Vehiculo> lst;

    public ListVehiculoDao() {
        lst = new ArrayList<>();
        lst.add(new Automovil(1994, "Ford Fiesta", "ZQR 123"));
        lst.add(new Motocicleta(2015, "Honda Biz", "099 XCC"));
        lst.add(new Automovil(2000, "Fiat Siena", "AC 755 AD"));
        lst.add(new Colectivo(2009, "WV Gol", "QR 877 SD"));
        lst.add(new Automovil(2019, "Renualt Clio", "AD 999"));
    }  
    
    @Override
    public List<Vehiculo> getAll() {
        return lst;
    }

    @Override
    public Vehiculo getByPatente(String patente) {
        for (Vehiculo v : lst) {
            if(v != null && v.getPatente().equals(patente))
                return v;
        }
        return null;
    }

    @Override
    public List<Vehiculo> getPatentesViejas() {
        //completar...
        return null;
    }

    @Override
    public List<Vehiculo> getPatentesNuevas() {
         return null;
    }

   
}
