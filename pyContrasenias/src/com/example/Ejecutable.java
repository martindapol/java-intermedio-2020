/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example;

import com.example.dominio.Password;
import java.util.Scanner;

/**
 *
 * @author MARTIN
 */
public class Ejecutable {
    

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        System.out.println("****Ejercicio CONTRASEÑAS!");
        Scanner input = new Scanner(System.in);
        int cant, largo;
        
        do{
            System.out.println("Ingrese cantidad de contraseñas a generar:");
            cant = input.nextInt();
        }while(cant <=0);
        
        do{
            System.out.println("Ingrese longitud de las claves:");
            largo = input.nextInt();
        }while(largo <=0);
        
        Password array[] = new Password[cant];
        boolean array2[] = new boolean[cant];
        for (int i = 0; i < cant; i++) {
            array[i] = new Password(largo);
            array2[i] = array[i].esFuerte();
        }
        
        for (int indi = 0; indi < cant; indi++) {
            Password pass = array[indi];
            if( pass != null){
                System.out.print(pass + "-");
                if(array2[indi])
                    System.out.println("Fuerte");
                else
                    System.out.println("Débil");
            }
        }
    
        
        
    }
    
}
