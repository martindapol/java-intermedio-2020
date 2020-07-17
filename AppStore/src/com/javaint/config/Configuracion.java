/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.javaint.config;


/**
 *
 * @author george
 */
public class Configuracion {
    
    private static final Configuracion INSTANCE = new Configuracion();
    
    private final String connectionString;
    private final String dbUserName, dbPassword;
    
    private Configuracion(){
        this.connectionString = "jdbc:mysql://localhost:3333/example?serverTimezone=UTC";
        this.dbUserName = "111mil";
        this.dbPassword = "111mil";
    }
    
    
    public static Configuracion getInstance(){
        return INSTANCE;
    }

    public String getConnectionString() {
        return connectionString;
    }

    public String getDbPassword() {
        return dbPassword;
    }

    public String getDbUserName() {
        return dbUserName;
    }
    
    
}
