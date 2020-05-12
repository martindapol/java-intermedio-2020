/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mails.reglas;

import mails.Email;

/**
 *
 * @author george
 */
public class ReglaUrgenteSpam implements ReglaClasificacion {

    @Override
    public void aplicarRegla(Email email) {
        int cantidadPalabras;
        int cantidadUrgente = 0;
        double porcentaje;
        // Se obtiene el cuerpo
        String cuerpo = email.getCuerpo();
        // Se cuentan las palabras (separadas por espacio)
        String[] palabras = cuerpo.split(" ");
        // La cantidad de palabras, serán las separadas por " "
        cantidadPalabras = palabras.length;
        // Se cuenta la cantidad de "Urgente"
        for (String unaPalabra : palabras) {
            if (unaPalabra.toLowerCase().equals("urgente")) {
                cantidadUrgente++;
            }
        }
        // Se calcula el porcentaje de urgentes/cuerpo
        porcentaje = (cantidadUrgente / cantidadPalabras) * 100;
        // Si el porcentaje es mayor a 15% es spam
        if (porcentaje > 15) {
            email.marcarSpam();
        }

    }

}
