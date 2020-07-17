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
public class Facturador extends Thread {

    private ShoppingCart s;

    public Facturador(ShoppingCart s) {
        this.s = s;
    }

    @Override
    public void run() {
        for (int i = 0; i < 5; i++) {
            System.out.println("Total: " + s.getTotal());
        }
    }
}
