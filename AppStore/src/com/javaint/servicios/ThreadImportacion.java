/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.javaint.servicios;

import java.io.IOException;
import java.nio.file.DirectoryIteratorException;
import java.nio.file.DirectoryStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.regex.PatternSyntaxException;

/**
 *
 * @author george
 */
public class ThreadImportacion extends Thread {

    private final Path dir;

    public ThreadImportacion(Path dir) {
        this.dir = dir;
    }

    @Override
    public void run() {
        while (!Thread.interrupted()) {
            try (DirectoryStream<Path> ds
                    = Files.newDirectoryStream(dir, "*.txt")) {

                for (Path unArchivo : ds) {
                    System.out.println(unArchivo.toString());
                }

            } catch (PatternSyntaxException | DirectoryIteratorException | IOException ioe) {
                System.err.println("Error al importar");
            }
            try {
                Thread.sleep(1000);
            } catch (InterruptedException ie) {
            }
        }
    }

}
