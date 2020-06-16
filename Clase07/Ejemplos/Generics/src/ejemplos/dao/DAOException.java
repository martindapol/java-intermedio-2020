/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejemplos.dao;

/**
 *
 * @author george
 */
public class DAOException extends Exception {

    public DAOException(String msg, Throwable t) {
        super(msg, t);
    }

}
