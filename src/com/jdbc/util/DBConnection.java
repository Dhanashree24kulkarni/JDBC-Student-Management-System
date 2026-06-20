package com.jdbc.util;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBConnection {

    public static Connection getConnection() {

        Connection con = null;

        try {

            Class.forName("oracle.jdbc.driver.OracleDriver");

            con = DriverManager.getConnection(
                    "jdbc:oracle:thin:@DK:1521:orcl",
                    "Scott",
                    "Oracle1234");

        } catch (Exception e) {

            e.printStackTrace();

        }

        return con;
    }
}
