package com.inss.teste.testecrud.config;
import java.sql.Connection;

public interface DatabaseConfig {

    public Connection connect();
    public void disconnect(Connection conn);
}