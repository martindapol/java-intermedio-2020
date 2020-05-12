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
public class ReglaContieneTexto implements ReglaClasificacion {

    private final String textoABuscar;
    private final CampoEmail donde;

    public ReglaContieneTexto(String texto, CampoEmail donde) {
        this.textoABuscar = texto.toLowerCase();
        this.donde = donde;
    }

    @Override
    public void aplicarRegla(Email email) {
        // Se obtiene el cuerpo del mail
        String textoAAnalizar = "";
        switch (donde) {
            case CUERPO:
                textoAAnalizar = email.getCuerpo();
                break;
            case DE:
                textoAAnalizar = email.getRemitente();
                break;
            case ASUNTO:
                textoAAnalizar = email.getAsunto();
                break;
        }

        // Se verifica si contiene o no la palabra oferta
        if (textoAAnalizar.toLowerCase().contains(textoABuscar)) {
            email.marcarSpam();
        }
    }

}
