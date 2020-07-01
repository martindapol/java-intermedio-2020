/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.javaint.entidades;

import java.io.Serializable;

/**
 *
 * @author MARTIN
 */
public class Password implements Serializable{

    private String valor;
    private int largo;

    public Password() {
        largo = 8;
        valor = generarPassword();
    }

    public Password(String valor) {
        this.valor = valor;
        this.largo = valor.length();
    }
    
    public boolean esFuerte() {
        int cMay, cMin, cNum;
        int ascii;
        //asignación múltiple...
        cMay = cMin = cNum = 0;
        for (int i = 0; i < largo; i++) {
            //tomar automáticamente el código ASCII:
            ascii = valor.charAt(i);
            if (ascii >= 48 && ascii <= 57) {
                cNum++;
            } else if (ascii >= 65 && ascii <= 90) {
                cMay++;
            } else {
                cMin++;
            }
        }//fin for...
        return (cMay > 3 && cMin > 1 && cNum > 5);
    }

    private String generarPassword() {
        return "admin123";
    }

    public String getValor() {
        return valor;
    }

    @Override
    public String toString() {
        String aux = "Débil";
        if(esFuerte())
            aux = "Fuerte";
        return getValor() + "|" + aux;
    }
    
    public boolean validate(String pass){
        return this.valor.equals(pass);
    }
    
    

}
