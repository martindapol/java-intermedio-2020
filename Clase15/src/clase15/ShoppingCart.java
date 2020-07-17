/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clase15;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.locks.ReentrantLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 *
 * @author george
 */
public class ShoppingCart {

    List<Producto> todos = 
            Collections.synchronizedList(
                    new ArrayList<>()
            );
    
    private ReentrantReadWriteLock rwl = new ReentrantReadWriteLock();

    public void agregar(String producto, double precio) {
        String nombre = Thread.currentThread().getName();
        try {
            
            rwl.writeLock().lock();
            System.out.println(nombre + " -> Agregando: " + producto + " Precio: " + precio);
            todos.add(new Producto(producto, precio));
            try{Thread.sleep(500);}catch(InterruptedException ie){}
        } finally {
            System.out.println(nombre  + " -> Finalizó");
            rwl.writeLock().unlock();
        }
        
    }

    public double getTotal() {
        double total = 0;
        String nombre = Thread.currentThread().getName();
        try {
            rwl.readLock().lock();
            System.out.println(nombre + " -> Entró a GetTotal");
            for (Producto p : todos) {
                total += p.getPrecio();
            }
            try{Thread.sleep(500);}catch(InterruptedException ie){}
        } finally {
            System.out.println(nombre + " -> Salió a GetTotal");
            rwl.readLock().unlock();
        }
        return total;
    }

}
