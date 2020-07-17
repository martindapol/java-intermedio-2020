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
public class Comprador extends Thread{
    
    private ShoppingCart s;
    
    public Comprador(ShoppingCart s){
        this.s = s;
    }
    
    @Override
    public void run(){
        for(int i=0;i<5;i++){
            s.agregar(String.format("Prod: %d", 1), i * 12.5);
        }
    }
}
