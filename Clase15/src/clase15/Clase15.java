/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clase15;

/**
 *
 * @author george
 */
public class Clase15 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        ShoppingCart s = new ShoppingCart();
        
        Comprador c1 = new Comprador(s);
        Comprador c2 = new Comprador(s);
        Comprador c3 = new Comprador(s);
        
        Facturador f = new Facturador(s);
        Facturador f2 = new Facturador(s);
        
        c1.start();
        c2.start();
        c3.start();
        
        f.start();
        f2.start();
        
    }
    
}
