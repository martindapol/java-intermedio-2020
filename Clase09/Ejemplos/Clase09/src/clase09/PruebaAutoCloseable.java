/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clase09;

/**
 *
 * @author george
 */
public class PruebaAutoCloseable {

    public static void main(String[] args) {

        try (RecursoCerrable res = new RecursoCerrable()) {
            
            System.out.println("Haciendo algo...");

        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}
