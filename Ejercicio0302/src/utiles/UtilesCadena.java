/*
 * 
 */
package utiles;

/**
 * Utilidades de cadena
 * @author george
 */
public class UtilesCadena {

    /**
     * Convierte un char cuyo caracter es un dígito al 
     * valor entero
     * @param c El caracter a convertir
     * @return El entero representando el dígito o -1 si 
     * el caracter no es un dígito
     */
    public static int charADigito(char c) {
        if (c >= '0' && c <= '9') {
            // Se retorna el caracter menos el valor de '0'
            return c - '0';
        } else {
            // No se pudo convertir
            return -1;
        }
    }

    /**
     * Invierte el orden de los caracteres en una cadena
     * @param cad La cadena a invertir
     * @return La cadena invertida
     */
    public static String invertir(String cad) {
        String resultado = "";
        // Se recorre la cadena desde el final al inicio
        for (int i = cad.length() - 1; i >= 0; i--) {
            // Se concatenan los distintos caracteres
            resultado += cad.charAt(i);
        }
        // Retorno de la cadena invertida
        return resultado;
    }

    /**
     * Extrae un entero de una cadena. Por ejemplo, dada la cadena:
     * "123456" y se invocase caracteresAEntero(cadena, 2, 5), el resultado
     * sería 3456
     * @param cadena La cadena original
     * @param inicio El primer caracter que forma parte del entero
     * @param fin El último caracter que forma parte del entero
     * @return Un entero con los dígitos solicitados o -1 si hubiese algún problema
     */
    public static int caracteresAEntero(String cadena, int inicio, int fin) {
        int resultado = 0;
        int longitud = fin - inicio;
        // Si la longitud es válida...
        if (longitud >= 0) {
            // Se recorre cada caracter solicitado
            for (int i = inicio, j = longitud; i <= fin; i++, j--) {
                // Se multiplica por la potencia de 10 que corresponda a la pos.
                resultado += Math.pow(10, j) * charADigito(cadena.charAt(i));
            }
        } else {
            // La longitud no es válida
            resultado = -1;
        }
        // Retorno del resultado
        return resultado;
    }

}
