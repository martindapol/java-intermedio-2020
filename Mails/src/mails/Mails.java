/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mails;

import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author george
 */
public class Mails {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // Se cargan los mails
        ArrayList<Email> todos = cargarMails();
        // Se crea el clasificador
        ClasificadorMails clasificador = new ClasificadorMails();
        // Se clasifican y se muestra el resultado
        for (Email unEmail : todos) {
            clasificador.clasificar(unEmail);
            // Se puede utilizar el toString ya sobreescrito
            System.out.println(unEmail.toString());
        }

    }

    private static ArrayList<Email> cargarMails() {
        ArrayList<Email> mails = new ArrayList<Email>();
        Scanner sc = new Scanner(System.in);
        String de, asunto, cuerpo;

        System.out.println("Cargue los emails, (Campo \"de\" vacío finaliza");
        System.out.println("---------------");
        System.out.print("De: ");
        de = sc.nextLine();
        while (!de.isEmpty()) {
            System.out.print("Asunto: ");
            asunto = sc.nextLine();
            System.out.print("Cuerpo: ");
            cuerpo = sc.nextLine();
            // Se crea el mail y se lo agrega
            mails.add(new Email(de, asunto, cuerpo));

            System.out.println("---------------");
            System.out.print("De: ");
            de = sc.nextLine();
        }

        return mails;

    }
}
