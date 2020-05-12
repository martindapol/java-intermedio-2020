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
public class ReglaMismaEmpresa implements ReglaClasificacion {

    private final String dominioEmpresa;

    public ReglaMismaEmpresa(String dominioEmpresa) {
        this.dominioEmpresa = dominioEmpresa;
    }

    @Override
    public void aplicarRegla(Email email) {
        // Se obtiene le remitente
        String remitente = email.getRemitente();
        // Si el remitente es de la misma compañía, no es spam
        if (remitente.contains(dominioEmpresa)) {
            email.limpiarSpam();
        }
    }

}
