/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mails;

import mails.reglas.CampoEmail;
import mails.reglas.ReglaClasificacion;
import mails.reglas.ReglaContieneTexto;
import mails.reglas.ReglaEsJefe;
import mails.reglas.ReglaMismaEmpresa;
import mails.reglas.ReglaUrgenteSpam;

/**
 *
 * @author george
 */
public class ClasificadorMails {

    private final ReglaClasificacion[] reglas;

    public ClasificadorMails() {
        this.reglas = new ReglaClasificacion[]{
            new ReglaContieneTexto("oferta", CampoEmail.ASUNTO),
            new ReglaUrgenteSpam(),
            new ReglaContieneTexto("príncipe africano", CampoEmail.CUERPO),
            new ReglaEsJefe("jefe@acme.com"),
            new ReglaMismaEmpresa("acme.com") 
            
        };
    }

    public void clasificar(Email email) {
        for (ReglaClasificacion unaRegla : reglas) {
            unaRegla.aplicarRegla(email);
        }
    }
}
