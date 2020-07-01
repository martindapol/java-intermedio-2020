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
public class PruebaDetencion {
    public static void main(String[] args) {
        ThreadReloj t = new ThreadReloj();
        
        t.start();
        try{Thread.sleep(5000);}catch(InterruptedException ie){}
        t.interrupt();
    }
}
