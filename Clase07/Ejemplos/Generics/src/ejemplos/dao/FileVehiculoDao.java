/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejemplos.dao;

import ejemplos.generics.vehiculos.Automovil;
import ejemplos.generics.vehiculos.Vehiculo;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author MARTIN
 */
public class FileVehiculoDao implements VehiculoDao {

    private List<Vehiculo> lst;
    private static final String SOURCE = "datos.txt";

    public FileVehiculoDao() {
        //recuperar los vehículos desde el archivo indicado 
        //en SOURCE:
        lst = loadFile();
    }

    @Override
    public List<Vehiculo> getAll() {
       return lst;
    }

    @Override
    public Vehiculo getByPatente(String patente) {
        Pattern pattern = Pattern.compile(patente);
        for (Vehiculo v : lst) {
              Matcher matcher = pattern.matcher(v.getPatente());
              if(matcher.find())
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
        //completar...
        return null;
    }
    

    private List<Vehiculo> loadFile() {
        List<Vehiculo> aux = new ArrayList<>();
        Vehiculo v = null;
        int anio = 0;
        
        try {
            Scanner sca = new Scanner(new FileInputStream(SOURCE));
            sca.useDelimiter("\n");
            while (sca.hasNext()) {
                String data = sca.nextLine();
                String [] vec = data.split(", ");
                v = new Automovil(Integer.parseInt(vec[0]),vec[1], vec[2]);
                aux.add(v);
            }

        } catch (FileNotFoundException ex) {
            //Si el archivo no existe, retornamos 'null'
            aux = null;
        }

        return aux;
    }
}
