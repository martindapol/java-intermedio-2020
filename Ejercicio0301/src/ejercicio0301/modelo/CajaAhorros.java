/*

 */
package ejercicio0301.modelo;

/**
 * Clase que representa una Caja de Ahorros.
 * 
 * Notar que los distintos métodos devuelven un booleano indicando el 
 * éxito o falla en la ejecución, pero no distingue que tipo de problemas
 * pudo haber. 
 * - ¿Es esta la manera correcta de hacerlo?,
 * - ¿Sería correcto realizar una salida por pantalla aquí?, 
 * - ¿De qué manera podría resolverse mejor?
 * 
 * Al revisar las distintas implementaciones (Cuentas Gold, Platinum, etc.).
 * ¿Se le ocurre una manera alternativa de resolver las políticas de descuento?
 * 
 * @author george
 */
public class CajaAhorros {
    
    private final String nroCuenta; // Nro. de Cuenta
    private float saldo;            // Saldo de la cuenta
    
    /**
     * Constructor de la cuenta.
     * @param nroCuenta Número identificador de la cuenta a crear
     */
    public CajaAhorros(String nroCuenta){
        this.nroCuenta = nroCuenta;
        this.saldo = 0;
    }
    
    /**
     * Devuelve el número de cuenta
     * @return Número de cuenta
     */
    public String getNroCuenta(){
        return this.nroCuenta;
    }
    
    /**
     * Devuelve el saldo de la cuenta
     * @return Saldo actual de la cuenta
     */
    public float getSaldo(){
        return this.saldo;
    }
    
    /**
     * Método que permite realizar un depósito en la cuenta.
     * 
     * @param monto: El monto a depositar
     * @return true:  Si la operación fue exitosa
     *         false: Si la operación no pudo realizarse
     * 
     */
    public boolean depositar(float monto){
        boolean resultado = false;
        // Se controla que el monto sea válido 
        if(monto > 0){
            // Si el monto es válido, se deposita
            this.saldo += monto;
            // Se marca el resultado como correcto
            resultado = true;
        } 
        
        return resultado;
    }
    
    /**
     * Realiza una extracción de la cuenta
     * @param monto
     * @return true: Si la operación fue exitosa
     *         false: En caso contrario
     */
    public boolean extraer(float monto){
        boolean resultado = false;
        // Se controla que el monto a extraer sea válido
        if(monto > 0){
            // Si el monto es válido, igual puede suceder que no tenga saldo
            if(controlarExtraccion(monto)){
                // Si se puede realizar la extracción
                this.saldo -= monto;
                resultado = true;
            }
        }
        return resultado;
    }
    
    /**
     * Simula una compra con tarjeta de débito. Para los efectos de este tipo
     * de cuentas, es equivalente a una extracción
     * @param monto: El monto a extraer
     * @return true: Si la operación fue exitosa
     *         false: En caso contrario
     */
    public boolean compra(float monto){
        // Se invoca a la extracción
        return extraer(monto);        
    }
    
    /**
     * Método que permite controlar si una cuenta tiene saldo suficiente para
     * una extracción. A preguntarse:
     *  - ¿Cuál sería el sentido de este método?
     *  - ¿Público es correcto, o debería ser privado?
     * 
     * @param monto: Monto que se quisiera extraer
     * @return true si es posible realizar esa extracción.
     *         false en caso contrario
     */
    public boolean controlarExtraccion(float monto){
        // En este caso solo validamos que el saldo sea suficiente
        return this.saldo >= monto;
    }
   
    
}
