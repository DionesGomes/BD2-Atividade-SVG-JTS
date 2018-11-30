package com.br.atividade.svg.jts.model.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {

    private String url;
    private String user;
    private String password;

    public Connection getConnection() throws ClassNotFoundException, SQLException {
        Class.forName("org.postgresql.Driver");

        url = "jdbc:postgresql://localhost:5432/Brasil";
        user = "postgres";
        password = "falltopieces";

        return DriverManager.getConnection(url, user, password);
    }
}
