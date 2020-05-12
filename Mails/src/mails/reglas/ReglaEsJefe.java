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
public class ReglaEsJefe implements ReglaClasificacion {

    private final String mailJefe;

    public ReglaEsJefe(String mailJefe) {
        this.mailJefe = mailJefe;
    }

    @Override
    public void aplicarRegla(Email email) {
        // Se obtiene le remitente
        String remitente = email.getRemitente();
        // Si es la dirección del jefe...
        if(remitente.equalsIgnoreCase(mailJefe)){
            email.marcarUrgente();
        }
    }

}
