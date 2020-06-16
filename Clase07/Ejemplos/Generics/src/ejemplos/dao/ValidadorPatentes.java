/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejemplos.dao;

import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author george
 */
public class ValidadorPatentes {

    public static final String PATRON_PATENTE_VIEJA
            = "[a-zA-Z]{3} [0-9]{3}";

    public static final String PATRON_PATENTE_NUEVA
            = "[a-zA-Z]{2} [0-9]{3} [a-zA-Z]{2}";

    public static final Pattern PATENTE_VIEJA
            = Pattern.compile(PATRON_PATENTE_VIEJA);

    public static final Pattern PATENTE_NUEVA
            = Pattern.compile(PATRON_PATENTE_NUEVA);

    public static boolean esPatenteVieja(String patente) {
        Matcher m = PATENTE_VIEJA.matcher(patente);
        return m.find();
    }

    public static boolean esPatenteNueva(String patente) {
        Matcher m = PATENTE_NUEVA.matcher(patente);
        return m.find();
    }

    public static void main(String[] args) {

        List<String> patentesAProbar = Arrays.asList(
                "RXB 123",
                "RX1 123",
                "123 ABC",
                " RXB 456",
                "AC 755 AD"
        );

        for (String patente : patentesAProbar) {
            boolean vieja = ValidadorPatentes.esPatenteVieja(patente.trim());
            boolean nueva = ValidadorPatentes.esPatenteNueva(patente.trim());
            System.out.println(
                    String.format("%s -> Vieja: %s - Nueva: %s",
                            patente.trim(),
                            vieja ? "SI" : "NO",
                            nueva ? "SI" : "NO"
                    )
            );
        }
    }

}
