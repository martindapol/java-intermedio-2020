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
public class Usuario extends Thread {

    private final String nombre;
    private final AsientoSala asiento;

    public Usuario(String nombre, AsientoSala asiento) {
        this.nombre = nombre;
        this.asiento = asiento;
    }

    @Override
    public void run() {
        try {
            System.out.println(getNombre() + " esperando para reservar");
            asiento.reservar(this);
            
        } catch (RuntimeException e) {
            e.printStackTrace();
        }
    }

    public String getNombre() {
        return nombre;
    }
    
    
}
