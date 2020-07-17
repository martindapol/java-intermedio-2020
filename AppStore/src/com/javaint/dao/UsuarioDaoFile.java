/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.javaint.dao;

import com.javaint.entidades.Usuario;
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
 * @author MARTIN
 */
public class UsuarioDaoFile implements UsuarioDao {

    private static final String FILE_USERS = "users.dat";

    public UsuarioDaoFile() {
        validateExistFile();
    }

    @Override
    public boolean create(Usuario u) {
        List<Usuario> lst = getAll();
        if (!lst.contains(u)) {
            lst.add(u);
            save(lst);
            return true;
        }
        return false;
    }

    @Override
    public Usuario validate(String nombre, String pass) {
        List<Usuario> lst = getAll();
        for (Usuario x : lst) {
            if (x.getNombre().equals(nombre) && x.validatePass(pass)) {
                return x;
            }
        }
        return null;
    }

    private void validateExistFile() {
        try (FileInputStream fis = new FileInputStream(FILE_USERS)) {

        } catch (FileNotFoundException fnf) {
            try (FileOutputStream fos = new FileOutputStream(FILE_USERS);
                    ObjectOutputStream oos = new ObjectOutputStream(fos)) {
            } catch (IOException ioe) {
                throw new RuntimeException("No se puede abrir el almacenamiento", ioe);
            }
        } catch (IOException ioe) {
            throw new RuntimeException("No se puede abrir el almacenamiento", ioe);
        }
    }

    private void save(List<Usuario> lst) {
        try (FileOutputStream fos = new FileOutputStream(FILE_USERS);
                ObjectOutputStream oos = new ObjectOutputStream(fos)) {
            oos.writeObject(lst);
        } catch (IOException ex) {
            throw new RuntimeException("No se puede abrir el almacenamiento", ex);
        }
    }

    private List<Usuario> getAll() {
        List<Usuario> lst;

        try (FileInputStream fis = new FileInputStream(FILE_USERS);
                ObjectInputStream ois = new ObjectInputStream(fis)) {
            lst = (List<Usuario>) ois.readObject();

        } catch (IOException | ClassNotFoundException e) {
            lst = new ArrayList<>();
        }
        return lst;
    }

}
