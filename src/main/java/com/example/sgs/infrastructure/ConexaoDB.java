package com.example.sgs.infrastructure;

import java.sql.*;

public class ConexaoDB {

    final static String url = "jdbc:mysql://localhost:3306/sgs";
    final static String user = "user";
    final static String password = "123456";

    public static void teste() {
        try {
            Connection conn = conectar();
            Statement stmt = conn.createStatement();
            ResultSet resultSet = stmt.executeQuery("select * from teste");
            while (resultSet.next()) {
                System.out.println(resultSet.getInt("id"));
                System.out.println(resultSet.getString("nome"));
            }
            conn.close();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public static Connection conectar() {
        // remover variaveis
        String url = "jdbc:mysql://localhost:3306/sgs";
        String user = "user";
        String password = "123456";

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        try {
            return DriverManager.getConnection(url, user, password);
        } catch (SQLException e) {
            System.err.println("Falha: " + e.getMessage());
            return null;
        }
    }

    public static Connection getConnection() {
        try {
            return DriverManager.getConnection(url, user, password);
        } catch (SQLException e) {
            throw new RuntimeException("Falha ao tentar conexão com o banco de dados.");
        }
    }
}
