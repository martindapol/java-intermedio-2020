/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.javaint.servicios;

import com.javaint.dao.AplicacionDao;
import com.javaint.dao.AplicacionDaoJDBC;
import com.javaint.dao.UsuarioDao;
import com.javaint.dao.UsuarioDaoJDBC;
import com.javaint.entidades.Aplicacion;
import com.javaint.entidades.Usuario;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

/**
 *
 * @author MARTIN Una clase de servicios que nos conecte con los datos y no
 * resuelva la lógica de negocio.
 */
public class GestorUsuarios {

    private final UsuarioDao dao;

    private Usuario userLog;

    public Usuario getUserLog() {
        return userLog;
    }

    public GestorUsuarios() {
        dao = new UsuarioDaoJDBC();
    }

    public boolean login(String user, String pass) {
        boolean loginOK;
        userLog = dao.validate(user, pass);

        loginOK = userLog != null;
        try {
            checkFirstLogin(user);
        } catch (IOException ioe) {
            throw new RuntimeException("Problema de login!", ioe);
        }
        return loginOK;
    }

    
    public void crearUsuario(String nombre, String password){
        Usuario usuario = new Usuario(nombre, password);
        this.dao.create(usuario);
    }
    /**
     * Chequea si existe su directorio de trabajo "workspace/userName". Si no
     * existe, es el primer login y lo crea, copiando la imagen por defecto al
     * directorio correspondiente.
     *
     * @param userName
     */
    private void checkFirstLogin(String userName) throws IOException {
        Path workspaceDir = Paths.get("workspace", userName);

        // Se comprueba si existe o no
        if (!Files.exists(workspaceDir)) {
            //Si no existe el directorio, hay que crearlo
            Files.createDirectories(workspaceDir);

        }

        Path imageFile = Paths.get(getUserAvatar());
        if (!Files.exists(imageFile)) {
            // Se arma el path por defecto
            Path defaultFile = Paths.get("images", "default.png");
            // Se copia la imagen
            Files.copy(defaultFile, imageFile);
        }
    }

    public String getUserAvatar() {
        if (userLog == null) {
            throw new RuntimeException("No hay usuario logueado");
        }

        return Paths.get("workspace", this.userLog.getNombre(), "avatar.png").
                toAbsolutePath().toString();
    }

}
