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
public class RunnableContador implements Runnable {
    
    private final int desde;
    private final int hasta;
    private int i;
    
    public RunnableContador(int desde, int hasta){
        this.desde = desde;
        this.hasta = hasta;
    }

    @Override
    public void run() {
        for (i = this.desde; i < this.hasta; i++) {
            System.out.println(Thread.currentThread().getName() + ":" + i);
            
        }
    }

}
