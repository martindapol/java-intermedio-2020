/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clase13.nio2;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 *
 * @author george
 */
public class PruebaVisitor {

    public static void main(String[] args) {
        try {
            Path dir = Paths.get(".");
            Files.walkFileTree(dir, new FileVisitorMuestraNombres());
        } catch (IOException ioe) {
            ioe.printStackTrace();
        }
    }

}
