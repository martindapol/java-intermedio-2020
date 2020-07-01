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
public class PruebaReserva {
    public static void main(String[] args) {
        AsientoSala asiento1 = new AsientoSala("J3");
        AsientoSala asiento2 = new AsientoSala("H4");
        AsientoSala asiento3 = new AsientoSala("F5");
        AsientoSala asiento4 = new AsientoSala("F1");
        
        Thread usuario1 = new Usuario("Jorge", asiento1);
        Thread usuario2 = new Usuario("Pedro", asiento2);
        Thread usuario3 = new Usuario("Martín", asiento3);
        Thread usuario4 = new Usuario("Pablo", asiento4);
        
        usuario1.start();
        usuario2.start();
        usuario3.start();
        usuario4.start();
    }
}
