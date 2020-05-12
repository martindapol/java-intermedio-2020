/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mails;

/**
 *
 * @author george
 */
public class Email {

    private final String remitente;
    private final String asunto;
    private final String cuerpo;
    private boolean esSpam;
    private boolean esUrgente;

    public Email(String de, String asunto, String cuerpo) {
        this.remitente = de;
        this.asunto = asunto;
        this.cuerpo = cuerpo;
    }

    public String getRemitente() {
        return remitente;
    }

    public String getAsunto() {
        return asunto;
    }

    public String getCuerpo() {
        return cuerpo;
    }

    public boolean esSpam() {
        return esSpam;
    }

    public boolean esUrgente() {
        return esUrgente;
    }

    public void marcarSpam() {
        esSpam = true;
        limpiarUrgente();
    }

    public void marcarUrgente() {
        esUrgente = true;
        limpiarSpam();
    }

    public void limpiarSpam() {
        esSpam = false;
    }

    public void limpiarUrgente() {
        esUrgente = false;
    }

    @Override
    public String toString() {
        return "De: " + remitente
                + "\nAsunto: " + asunto
                + "\nSpam: " + (esSpam ? "SI" : "NO")
                + "\nUrgente: " + (esUrgente ? "SI" : "NO");
    }

}
