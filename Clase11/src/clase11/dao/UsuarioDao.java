/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clase11.dao;

import clase11.entidades.Usuario;

/**
 *
 * @author MARTIN
 */
public interface UsuarioDao {
    public void create(Usuario user) throws DAOException;
    public Usuario validateUser(String user, String pass) throws DAOException;
}
