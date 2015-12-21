package com.company;

import java.sql.*;

/**
 * Created by Sergey on 18.12.2015.
 */
public class Main {
    // JDBC драйвер и адрес сервера БД
    static final String JDBC_DRIVER = "org.postgresql.Driver";
    static final String DB_URL = "jdbc:postgresql://localhost:5432/MyDbTest";

    // логин и пороль для доступа к БД
    static final String USER = "postgres";
    static final String PASS = "XAvier";

    public static void main(String[] args) {
        Connection conn = null;

        try {
            //шаг 2: регистрируем драйвер
            Class.forName(JDBC_DRIVER);

            //шаг 3: открываем соединение
            System.out.println("Connecting to database...");
            conn = DriverManager.getConnection(DB_URL, USER, PASS);
            System.out.println("Connected");
           Statement stm = conn.createStatement();
            stm.execute("select * from \"Student\"");
            ResultSet rs = stm.executeQuery("select * from \"Student\"");

            conn.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
    }

