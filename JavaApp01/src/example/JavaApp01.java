package example;

import java.util.Calendar;
import java.util.Scanner;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author MARTIN
 */
public class JavaApp01 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        //Primer problema: calcular la edad y determinar si es mayor de edad

        Scanner input = new Scanner(System.in);

        System.out.println("Ingrese su año de nacimiento");
        int anio = input.nextInt();
        int actual = Calendar.getInstance().get(Calendar.YEAR);

        //calculamos la edad:
        int edad = actual - anio;

        //mostrar resultado:
        System.out.println("Su edad a la fecha es: " + edad);
        if (edad >= 18) {
            System.out.println("Usted es mayor de edad!");
        } else if (edad < 1) {
            System.out.println("Es un bebe!!!");

        } else {
            System.out.println("Es menor de edad");
        }
    }
    
}
