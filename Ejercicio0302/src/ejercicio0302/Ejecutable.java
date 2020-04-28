/*
 * 
 */
package ejercicio0302;

import java.util.Scanner;
import modelo.CodigoBarras;

/**
 *
 * @author george
 */
public class Ejecutable {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // Scanner para entrada por teclado
        Scanner sc = new Scanner(System.in);
        // Variable para los códigos ingresados
        String line;

        System.out.println("Lector de Códigos de barra v.1.0");
        System.out.println("================================");
        // Primera Carga
        System.out.println("Ingrese un código (blanco corta): ");
        // Carga de un código como string
        line = sc.nextLine();
        // Loop Principal
        while (!line.equals("")) {
            CodigoBarras cod = new CodigoBarras(line);
            if (cod.isValido()) {
                System.out.println("Código interpretado: \n" + cod);
            } else {
                System.out.println("Código inválido");
            }
            // Segunda lectura
            System.out.println("Ingrese un código (blanco corta): ");

            line = sc.nextLine();

        }
        // Fin del programa
        System.out.println("Hasta luego!");
    }

}
