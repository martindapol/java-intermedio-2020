/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clase13.nio2;

import java.io.IOException;
import java.nio.file.DirectoryIteratorException;
import java.nio.file.DirectoryStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.regex.PatternSyntaxException;

/**
 *
 * @author george
 */
public class PruebaDirStream {

    public static void main(String[] args) {
        
        Path directorio = Paths.get(".");
        System.out.println(
                "Trabajando en: "
                + directorio.toAbsolutePath().toString()
        );

        try (DirectoryStream<Path> ds = Files.newDirectoryStream(directorio)) {

            for (Path unPath : ds) {
                if (Files.isDirectory(unPath)) {
                    System.err.println(unPath.toString());
                } else {
                    System.out.println(unPath.toString());
                }

            }

        } catch (PatternSyntaxException | DirectoryIteratorException | IOException ex) {
            ex.printStackTrace();
        }
    }

}
