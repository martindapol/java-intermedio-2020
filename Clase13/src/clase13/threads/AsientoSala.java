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
public class AsientoSala {

    private final String butaca;
    private boolean reservado = false;

    private static final Object lock = new Object();

    public AsientoSala(String butaca) {
        this.butaca = butaca;
    }

    public void reservar(Usuario u) {
        synchronized (lock) {
            System.out.println(u.getNombre() + " Quiere reservar!");

            try {
                Thread.sleep(5_000);
            } catch (InterruptedException ie) {
            }

            if (this.reservado) {
                throw new RuntimeException("Ya está reservado");
            }
            this.reservado = true;
        }

        System.out.println(u.getNombre() + " Reservó " + this.butaca);
    }

}
