/*
 * 
 */
package ejercicio0301.modelo;

/**
 *
 * @author george
 */
public class CajaAhorrosBasica extends CajaAhorros{
    
    public CajaAhorrosBasica(String nroCuenta) {
        super(nroCuenta);
    }

    /**
     * Depositar dinero en la cuenta, con un costo del 0.75%
     * en concepto de comisión
     * @param monto monto a depositar
     * @return true si la operación fue exitosa, false en caso contrario
     */
    @Override
    public boolean depositar(float monto) {
        // Se descuenta la comisión
        float montoADepositar =  monto * 0.9925f; 
        // Se realiza el depósito
        return super.depositar(montoADepositar); 
    }

    /**
     * Extraer de la cuenta, con una comisión del 2%
     * @param monto monto a extraer
     * @return true si la operación fue exitosa, false en caso contrario
     */
    @Override
    public boolean extraer(float monto) {
        // Se calcula la comisión del 2%
        float montoAExtraer = monto * 1.02f;
        // Se extrae el monto + la comisión
        return super.extraer(montoAExtraer);
    }

    /**
     * Realizar una compra, con un 2% de descuento
     * @param monto monto de la compra
     * @return true si la operación fue exitosa, false en caso contrario
     */
    @Override
    public boolean compra(float monto) {
        // Se realiza un 2% de descuento
        float montoConDescuento = monto * 0.98f;
        // Se realiza la compra
        return super.compra(montoConDescuento); 
    }

    @Override
    public String toString() {
        return this.getNroCuenta() + " (Básica)";
    }
    
    
    
}
