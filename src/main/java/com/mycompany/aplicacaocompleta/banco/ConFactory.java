package com.mycompany.aplicacaocompleta.banco;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConFactory {
    
    private final String host;
    private final String user;
    private final String password;
    
    public ConFactory(){
        host = "jdbc:postgresql://127.0.0.1:5432/POO";
        user = "postgres";
        password = "postgres";
    }
    
    public Connection getConnection() throws ClassNotFoundException, SQLException{
        Class.forName("org.postgresql.Driver");
        return DriverManager.getConnection(host, user, password);
    }
    
}
