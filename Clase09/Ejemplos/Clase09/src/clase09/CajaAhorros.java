/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clase09;

import clase09.exceptions.SaldoInsuficienteException;

/**
 *
 * @author george
 */
public class CajaAhorros {

    private final String nroCuenta;

    private double saldo;

    public CajaAhorros(String nroCuenta) {
        this.nroCuenta = nroCuenta;
    }

    public double getSaldo() {
        return saldo;
    }

    public void retirar(double monto) throws SaldoInsuficienteException {

        if (monto < 0) {
            throw new IllegalArgumentException("Saldo no puede ser negativo!");
        }

        if (monto <= saldo) {
            // Tiene saldo, todo OK!
            this.saldo -= monto;
        } else {
            // Por favor, te notifico que algo no está bien
            throw new SaldoInsuficienteException(monto, this.saldo);
        }

    }

    public void depositar(double monto) {
        this.saldo += monto;
    }

}
