package com.company;

import java.sql.*;

/**
 * Created by Sergey on 18.12.2015.
 */
public class Main {
    // JDBC ������� � ����� ������� ��
    static final String JDBC_DRIVER = "org.postgresql.Driver";
    static final String DB_URL = "jdbc:postgresql://localhost:5432/MyDbTest";

    // ����� � ������ ��� ������� � ��
    static final String USER = "postgres";
    static final String PASS = "XAvier";

    public static void main(String[] args) {
        Connection conn = null;

        try {
            //��� 2: ������������ �������
            Class.forName(JDBC_DRIVER);

            //��� 3: ��������� ����������
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

