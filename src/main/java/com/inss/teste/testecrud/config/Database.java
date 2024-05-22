package com.inss.teste.testecrud.config;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Database implements DatabaseConfig {

    private Connection conn;

    @Override
    public Connection connect(){
        String url = "jdbc:postgresql://localhost:5432/testeCrud";
        String user = "postgres";
        String password = "postgres";
        try {
            Class.forName("org.postgresql.Driver");
            conn = DriverManager.getConnection(url, user, password);
        } catch (ClassNotFoundException e) {
            // Erro caso o driver JDBC não foi instalado
            e.printStackTrace();
        } catch (SQLException e) {
            // Erro caso haja problemas para se conectar ao banco de dados
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public void disconnect(Connection conn) {
        try{
            conn.close();
        }catch (SQLException ex) {
            Logger.getLogger(DatabaseConfig.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}

