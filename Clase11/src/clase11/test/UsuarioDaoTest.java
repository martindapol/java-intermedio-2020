/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clase11.test;

import clase11.dao.DAOException;
import clase11.dao.UsuarioDao;
import clase11.dao.UsuarioDaoFileImp;
import clase11.entidades.Usuario;

/**
 *
 * @author MARTIN
 */
public class UsuarioDaoTest {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
       
        try {
            UsuarioDao dao = new UsuarioDaoFileImp();
            dao.create(new Usuario("Test"));
        } catch (DAOException ex) {
            System.out.println(ex.toString());
        }
    }
    
}
