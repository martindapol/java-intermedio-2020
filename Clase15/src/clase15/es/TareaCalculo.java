/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clase15.es;

import java.util.concurrent.Callable;

/**
 *
 * @author george
 */
public class TareaCalculo implements Callable<Double>{
    
    private int cantidad;
    public TareaCalculo(int n){
        this.cantidad = n;
    }
    
    @Override
    public Double call(){
        double total = 0;
        
        for(int i=0;i<this.cantidad;i++){
            total += (double) (Math.random() * 50);
            try{Thread.sleep(10);}catch(InterruptedException ie){}
        }
        
        return total / this.cantidad;
    }
    
}
