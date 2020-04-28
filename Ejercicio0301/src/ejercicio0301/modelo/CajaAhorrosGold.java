/*
 * 
 */
package ejercicio0301.modelo;

/**
 *
 * @author george
 */
public class CajaAhorrosGold extends CajaAhorros{
    
    private int contadorDepositos = 0; // Contador de depósitos
    
    public CajaAhorrosGold(String nroCuenta) {
        super(nroCuenta);
    }

    @Override
    public boolean depositar(float monto) {
        boolean resultado;
        float montoADepositar = monto;
        // Si se agotaron los depósitos libres, se cobra una comisión
        if(contadorDepositos > 3){
            // Se quita la comisión del depósito
            montoADepositar = monto * 0.995f;
        }
        // Se realiza el depósito
        resultado = super.depositar(montoADepositar); 
        // Si el resultado fue éxito
        if(resultado){
            // Se incrementan los depósitos realizados
            contadorDepositos++;
        }
        return resultado;
    }
    
    /**
     * Extraer de la cuenta, con una comisión del 1%
     * @param monto monto a extraer
     * @return true si la operación fue exitosa, false en caso contrario
     */
    @Override
    public boolean extraer(float monto) {
        // Se calcula la comisión del 1%
        float montoAExtraer = monto * 1.01f;
        // Se extrae el monto + la comisión
        return super.extraer(montoAExtraer);
    }
    
    /**
     * Realizar una compra, con un 10% de descuento
     * @param monto monto de la compra
     * @return true si la operación fue exitosa, false en caso contrario
     */
    @Override
    public boolean compra(float monto) {
        // Se realiza un 10% de descuento
        float montoConDescuento = monto * 0.90f;
        // Se realiza la compra
        return super.compra(montoConDescuento); 
    }
    
       @Override
    public String toString() {
        return this.getNroCuenta() + " (Gold)";
    }
}
