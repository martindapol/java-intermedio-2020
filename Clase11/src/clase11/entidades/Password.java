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
public class Password implements Serializable{
    private String value;
    private long expiredTo;

    public Password() {
        expiredTo = System.currentTimeMillis() + (1000*12000);
        value = "default";
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
    
    public boolean validate(String pass){
        return this.value.equals(pass);
    }
            
    public boolean isExpired(){
        long current = System.currentTimeMillis();
        return expiredTo - current > 0;
                
    }
    
}
