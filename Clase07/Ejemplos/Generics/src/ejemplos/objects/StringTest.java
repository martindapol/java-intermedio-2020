/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejemplos.objects;

import java.util.Scanner;
import java.util.StringTokenizer;

/**
 *
 * @author MARTIN
 */
public class StringTest {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner sca;
        //Split:
        String cad1 = "Java Intermedio 2020";
        String[] array = cad1.split(" ");
        for (String s : array) {
            System.out.println(s);
        }
        
        //IDEM, con StringTokenizer:
        System.out.println("\n");
        StringTokenizer st = new StringTokenizer(cad1, " ");
        while (st.hasMoreElements()) {
            String nextElement = st.nextElement().toString();
            System.out.println(nextElement);
        }
        System.out.println("\n");
        
        //Ahora con Scanner:
        String dato = "2019, Ford Fiesta, AD777DC";

        sca = new Scanner(dato);
        sca.useDelimiter(", ");

        int anio = 0;
        String modelo;
        String patente;
        while (sca.hasNext()) {
            if (sca.hasNextInt()) {
                anio = sca.nextInt();
            } else {
                modelo = sca.next();
                patente = sca.next();
                System.out.format("Año: %d |Modelo: %s |Patente: %s\n", anio, modelo, patente);
            }
        }
    }
}
