/*
 * 
 */
package ejercicio0301.modelo;

/**
 *
 * @author george
 */
public class CajaAhorrosPlatinum extends CajaAhorros {

    public CajaAhorrosPlatinum(String nroCuenta) {
        super(nroCuenta);
    }

    /**
     * Realizar una compra, con descuentso de acuerdo al monto
     *
     * @param monto monto de la compra
     * @return true si la operación fue exitosa, false en caso contrario
     */
    @Override
    public boolean compra(float monto) {
        // Se realiza un 10% de descuento
        float montoConDescuento = monto;
        // Si el monto es superior a $3000, 25%
        if (monto > 3_000) {
            montoConDescuento *= 0.75f;
        } else if (monto > 1_500) {
            montoConDescuento *= 0.85f;
        }
        // Se realiza la compra
        return super.compra(montoConDescuento);
    }

    @Override
    public String toString() {
        return this.getNroCuenta() + " (Platinum)";
    }
}
