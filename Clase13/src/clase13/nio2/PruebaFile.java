/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clase13.nio2;

import java.io.File;

/**
 *
 * @author george
 */
public class PruebaFile {

    public static void main(String[] args) {
        File f = new File(".");
        for (File unFile : f.listFiles()) {
            System.out.println(unFile.toString());
        }
    }
}
