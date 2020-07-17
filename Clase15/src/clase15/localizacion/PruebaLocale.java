/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clase15.localizacion;

import java.text.DateFormat;
import java.text.NumberFormat;
import java.text.ParseException;
import java.util.Date;
import java.util.Locale;
import java.util.ResourceBundle;

/**
 *
 * @author george
 */
public class PruebaLocale {

    public static void main(String[] args) throws ParseException {
        Locale locale = new Locale("es", "AR");
        ResourceBundle mensajes = 
                ResourceBundle.getBundle(
                        "Mensajes",
                        locale
                );
        System.out.println(mensajes.getString("mensaje1"));
        System.out.println(mensajes.getString("mensaje2"));
        
        NumberFormat currency = NumberFormat.getCurrencyInstance();
        // en_US: Total: $153.28
        // es_AR: Total: $153,28
        // zh_CN: Total: ￥153.28
        System.out.println("Total: " + currency.format(153.28));
        System.out.println("Parseado: " + currency.parse("$153.28"));
        
        DateFormat fecha = DateFormat.getDateInstance(DateFormat.SHORT, locale);
        System.out.println(fecha.format(new Date()));
    }
}
