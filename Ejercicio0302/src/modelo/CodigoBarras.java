/*
 * 
 */
package modelo;

import utiles.UtilesCadena;

/**
 * Representa un ćodigo de barras de acuerdo a la codificación
 * EAN 13
 * @author george
 */
public class CodigoBarras {

    private static final int LARGO_EAN13 = 13;
    private int codEmpresa = -1;
    private int codPais = -1;
    private int codProducto = -1;
    private final boolean valido;
    private final String codigo;

    /**
     * Constructor
     * @param cadena: Cadena representando el código de barras leído
     */
    public CodigoBarras(String cadena) {
        this.codigo = cadena;
        this.valido = parsearCodigo(cadena);
    }

    /**
     * Realiza el parseo del código completo, siempre y cuando el mismo
     * sea válido
     * @param cadena
     * @return true si es un código válido, false en caso contrario
     */
    private boolean parsearCodigo(String cadena) {
        // Revisar el dígito verificador
        boolean cadenaValida = verificarCodigo(cadena);
        // Únicamente si es válido, parsear los campos
        if (cadenaValida) {
            // Tres dígitos para codigo de País
            codPais = UtilesCadena.caracteresAEntero(cadena, 0, 2);
            // 5 dígitos para código de empresa
            codEmpresa = UtilesCadena.caracteresAEntero(cadena, 3, 7);
            // 4 dígitos para código de producto
            codProducto = UtilesCadena.caracteresAEntero(cadena, 8, 11);
        }
        // Devolución del resultado
        return cadenaValida;
    }

    /**
     * Calcula el dígito verificador que correspondería a esta código
     * @param cadena El código completo (Debe tener LARGO_EAN13 dígitos).
     * Si se quiere generar un dígito para un código nuevo, se debe completar
     * con cero
     * @return El dígito verificador que correspondería a este código
     */
    private int calcularDigitoVerificacion(String cadena) {
        int sumaPares = 0, sumaImpares = 0, sumaControl, decenaSuperior;
        // Se debe invertir la cadena
        String cadenaInvertida = UtilesCadena.invertir(cadena);
        // Se recorren los dígitos, menos el de control
        for (int i = 0; i < LARGO_EAN13 - 1; i++) {
            // Conversión de char a int
            int digito = UtilesCadena.charADigito(cadenaInvertida.charAt(i + 1));
            // Se suman las posiciones pares e impares
            if (i % 2 == 0) {
                // Cero o par...
                sumaPares += digito;
            } else {
                // Impar
                sumaImpares += digito;
            }
        }
        // Suma de control
        sumaControl = 3 * sumaPares + sumaImpares;
        // Decena superior
        decenaSuperior = (int) Math.ceil(sumaControl / 10f) * 10;
        // Dígito de control
        return decenaSuperior - sumaControl;
    }

    /**
     * Verifica que un código sea válido
     * @param cadena El código completo
     * @return true si es un código válido, false en caso contrario
     */
    private boolean verificarCodigo(String cadena) {
        boolean resultado = false;
        int digitoCalculado, digitoControl;
        // Si el largo de la cadena es el correcto
        if (cadena.length() == LARGO_EAN13) {
            // Tomo el dígito de control de la cadena
            digitoControl = UtilesCadena.charADigito(cadena.charAt(LARGO_EAN13 - 1));
            // Comienzo el cálculo del dígito
            digitoCalculado = calcularDigitoVerificacion(cadena);
            // Concide el dígito?
            resultado = digitoCalculado == digitoControl;
        }
        return resultado;
    }

    /**
     * Devuelve el código de país
     * @return El código de País
     */
    public int getCodPais() {
        return codPais;
    }

    /**
     * Devuelve el código de empresa
     * @return El código de empresa
     */
    public int getCodEmpresa() {
        return codEmpresa;
    }

    /**
     * Devuelve el código de Producto
     * @return El código de producto
     */
    public int getCodProducto() {
        return codProducto;
    }

    /**
     * Devuelve la cadena original
     * @return Cadena completa del código
     */
    public String getCodigo() {
        return codigo;
    }

    /**
     * Indica si es válido o no el código
     * @return true en caso de ser válido, false en caso contrario
     */
    public boolean isValido() {
        return valido;
    }
    
    

    @Override
    public String toString() {
        if (valido) {
            return "País: " + getCodPais() + "\tEmpresa: " + getCodEmpresa() + "\tProducto: " + getCodProducto();
        } else {
            return "Código inválido... (" + getCodigo() + ")";
        }
    }


}
