/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clase09;

/**
 *
 * @author george
 */
public class RecursoCerrable implements AutoCloseable {

    public RecursoCerrable(){
        System.out.println("Abriendo el recurso...");
    }
    
    @Override
    public void close() throws Exception {
        System.out.println("Cerrando el recurso...");
    }
    
}
