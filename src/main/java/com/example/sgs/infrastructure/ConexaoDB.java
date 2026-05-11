package com.example.sgs.infrastructure;

import java.sql.*;

public class ConexaoDB {

    final static String url = "jdbc:mysql://mysql:3306/sgs";
    final static String user = "user";
    final static String password = "123456";

    public static Connection getConnection() {
        try {
            return DriverManager.getConnection(url, user, password);
        } catch (SQLException e) {
            throw new RuntimeException("Falha ao tentar conexão com o banco de dados.", e);
        }
    }
}
