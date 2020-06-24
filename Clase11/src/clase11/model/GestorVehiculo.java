/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clase11.model;

import clase11.dao.DAOException;
import clase11.dao.UsuarioDao;
import clase11.dao.UsuarioDaoFileImp;
import clase11.dao.VehiculoDAO;
import clase11.dao.VehiculoDAOFileImpl;
import clase11.entidades.Usuario;

/**
 *
 * @author MARTIN
 */
public class GestorVehiculo {
    private VehiculoDAO daoVehiculo;
    private UsuarioDao daoUsuario;

    //User login
    private Usuario user;
    
    
    public GestorVehiculo() {
        daoVehiculo = new VehiculoDAOFileImpl();
        daoUsuario = new UsuarioDaoFileImp();
        
    }
    
    public Usuario login(String user, String pass)throws DAOException{ 
        return daoUsuario.validateUser(user, pass);    
    }
    
    public void createUsuario(String nombre) throws DAOException{
        Usuario user = new Usuario(nombre);
        daoUsuario.create(user);
    }

    public Usuario getUser() {
        return user;
    }

    public void setUser(Usuario user) {
        this.user = user;
    }
    
    
    
}
