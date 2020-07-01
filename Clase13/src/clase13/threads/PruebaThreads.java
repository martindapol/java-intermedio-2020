/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clase13.threads;

/**
 *
 * @author george
 */
public class PruebaThreads {

    public static void main(String[] args) {
        Runnable r0 = new RunnableContador(100, 200);
        
        Thread t0 = new Thread(r0);
        Thread t1 = new Thread(r0);
        Thread t2 = new Thread(r0);
        
        t0.start();
        t1.start();
        t2.start();
    }

}
