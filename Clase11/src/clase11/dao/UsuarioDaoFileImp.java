/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clase11.dao;

import clase11.entidades.Usuario;
import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author MARTIN
 */
public class UsuarioDaoFileImp implements UsuarioDao {

    private static final String FILE_USERS = "users.dat";

    public UsuarioDaoFileImp() {
        validateFileExist();
    }

    @Override
    public void create(Usuario user) throws DAOException {
        List<Usuario> all = findAll();
        try (FileOutputStream fis = new FileOutputStream(FILE_USERS);
                ObjectOutputStream oos = new ObjectOutputStream(fis)) {

            if (!all.contains(user)) {
                all.add(user);
                oos.writeObject(all);
            } else {
                throw new DAOException("Usuario existente!", null);
            }

        } catch (IOException ioe) {
            throw new DAOException("Archivo de usuarios no accesible", ioe);
        }
    }

    private List<Usuario> findAll() throws DAOException {
        List<Usuario> all = new ArrayList<>();

        try (FileInputStream fis = new FileInputStream(FILE_USERS);
                ObjectInputStream ois = new ObjectInputStream(fis)) {
            all = (List<Usuario>) ois.readObject();
        } catch (IOException | ClassNotFoundException ioe) {
            if(!(ioe instanceof EOFException))
                throw new DAOException("No se pudo leer el archivo", ioe);
        }
        return all;
    }

    @Override
    public Usuario validateUser(String user, String pass) throws DAOException {
        List<Usuario> all = findAll();
        for (Usuario x : all) {
            if (x.getNombre().equals(user)
                    && x.getPass().validate(pass)) {

                if (!x.getPass().isExpired()) {
                    return x;
                } else {
                    throw new DAOException("Password expirado!", null);
                }
            }
        }
        return null;
    }

    private void validateFileExist() {
        try (FileInputStream fis = new FileInputStream(FILE_USERS)) {
        } catch (IOException e ) {
            try (FileOutputStream fis = new FileOutputStream(FILE_USERS);
                    ObjectOutputStream oos = new ObjectOutputStream(fis)) {
            } catch (IOException ioe) {
                throw new RuntimeException("No se puede acceder al archivo usuarios", ioe);
            }
        }
    }
}
