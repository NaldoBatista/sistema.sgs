package com.example.sgs.infrastructure;

import java.sql.Connection;

public class DataBase {

    private DataBase dataBase = null;
    private Connection conn = null;

    private DataBase() {
        this.conn = ConexaoDB.conectar();
    }

    public DataBase getInstance() {
        if (this.dataBase == null) {
            this.dataBase = new DataBase();
        }

        return dataBase;
    }

    public void query(String sql) {
    }

    public void execute(String sql) {
        // implementar
    }
}
