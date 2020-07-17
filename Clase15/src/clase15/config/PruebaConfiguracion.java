/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clase15.config;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author george
 */
public class PruebaConfiguracion {
    public static void main(String[] args) {
        Properties p = new Properties();
        try {
            p.load(new FileInputStream("Configuracion.properties"));
            
            System.out.println("Usuario: " + p.getProperty("dbUser"));
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
}
