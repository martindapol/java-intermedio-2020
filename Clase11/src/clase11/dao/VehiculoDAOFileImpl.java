/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clase11.dao;

import clase11.entidades.Vehiculo;
import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author george
 */
public class VehiculoDAOFileImpl implements VehiculoDAO {

    private static final String FILE_NAME = "vehiculos.dat";

    public VehiculoDAOFileImpl() {
        asegurarArchivo();
    }

    private void asegurarArchivo() {

        try (FileInputStream fis = new FileInputStream(FILE_NAME)) {

        } catch (FileNotFoundException fnf) {
            try (FileOutputStream fos = new FileOutputStream(FILE_NAME);
                    ObjectOutputStream oos = new ObjectOutputStream(fos)) {
            } catch (IOException ioe) {
                throw new RuntimeException("No se puede abrir el almacenamiento", ioe);
            }
        } catch (IOException ioe) {
            throw new RuntimeException("No se puede abrir el almacenamiento", ioe);
        }

    }

    private void saveAll(List<Vehiculo> all) throws DAOException {
        try (FileOutputStream fos = new FileOutputStream(FILE_NAME);
                ObjectOutputStream oos = new ObjectOutputStream(fos);) {

            for (Vehiculo v : all) {
                oos.writeObject(v);
            }

        } catch (IOException ioe) {
            throw new DAOException("No se puedo grabar", ioe);
        }
    }

    @Override
    public void store(Vehiculo v) throws DAOException {
        List<Vehiculo> all = findAll();
        all.add(v);
        saveAll(all);

    }

    @Override
    public Vehiculo findByPatente(String patente) throws DAOException {
        try (FileInputStream fis = new FileInputStream(FILE_NAME);
                ObjectInputStream ois = new ObjectInputStream(fis)) {

            while (true) {
                Vehiculo v = (Vehiculo) ois.readObject();
                if (v.getPatente().equalsIgnoreCase(patente)) {
                    return v;
                }
            }

        } catch (EOFException eof) {
            // Condición esperada
        } catch (IOException | ClassNotFoundException ioe) {
            throw new DAOException("No se pudo leer el archivo", ioe);
        }
        return null;
    }

    @Override
    public List<Vehiculo> findAll() throws DAOException {
        List<Vehiculo> resultado = new ArrayList<>();

        try (FileInputStream fis = new FileInputStream(FILE_NAME);
                ObjectInputStream ois = new ObjectInputStream(fis)) {

            while (true) {
                Vehiculo v = (Vehiculo) ois.readObject();
                resultado.add(v);
            }

        } catch (EOFException eof) {
            // Condición esperada
        } catch (IOException | ClassNotFoundException ioe) {
            throw new DAOException("No se pudo leer el archivo", ioe);
        }

        return resultado;
    }

}
