/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clase09;

import clase09.exceptions.SaldoInsuficienteException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author george
 */
public class Clase09 {

    public static void main(String[] args) {

        CajaAhorros c = new CajaAhorros("AA-1234/5");
        System.out.printf("Saldo anterior: $ %6.2f.-\n", c.getSaldo());

        try {
            c.depositar(9_000);
            c.retirar(10_000);
            System.out.println("Operación exitosa!");

        } catch (SaldoInsuficienteException miEx) {
            // Sólo se llama si saltó una excepción
            System.err.println("Ud. No tiene saldo para realizar la operación");
            System.err.println("Detalle: " + miEx.getMessage());
        } catch (IllegalArgumentException | NullPointerException ia) {

            System.err.println(ia.getMessage());

        } finally {
            System.out.printf("Saldo posterior: $ %6.2f.-\n", c.getSaldo());
        }

    }

   
}
