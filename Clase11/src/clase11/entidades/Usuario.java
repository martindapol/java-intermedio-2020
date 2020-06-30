/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clase11.entidades;

import java.io.Serializable;

/**
 *
 * @author MARTIN
 */
public class Usuario implements Serializable{
    private String nombre;
    private Password pass;

    public Usuario(String nombre) {
        this.nombre = nombre;
        pass = new Password();
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Password getPass() {
        return pass;
    }

    public void setPass(Password pass) {
        this.pass = pass;
    }
    
    public boolean isExpired(){
        return pass.isExpired();
    }

    @Override
    public boolean equals(Object o) {
        if(o == null)
            return false;
        if(!(o instanceof Usuario))
            return false;
        Usuario user = (Usuario)o;
        return this.nombre.equals(user.nombre);
        
        
    }
    
    
    
}
