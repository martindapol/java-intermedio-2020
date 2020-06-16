/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clase09.exceptions;

/**
 *
 * @author george
 */
public class SaldoInsuficienteException extends Exception {
    
    private final double monto;
    private final double saldoDisponible;
    
    public SaldoInsuficienteException(double monto, double saldoDisponible){
        super(
            String.format(
                "Saldo Insuficiente, Disponible: %6.2f, Se solicitó: %6.2f",
                saldoDisponible, monto
            )
        );
        this.monto = monto;
        this.saldoDisponible = saldoDisponible;
    }
   
    
    public double getMonto() {
        return monto;
    }

    public double getSaldoDisponible() {
        return saldoDisponible;
    }
    
    
    
}
