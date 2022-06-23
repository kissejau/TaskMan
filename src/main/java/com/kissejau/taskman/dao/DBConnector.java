package com.kissejau.taskman.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnector {

    private static String URL = "jdbc:postgresql://localhost:5432/postgres";
    private static String NAME = "postgres";
    private static String PASSWORD = "1243";

    private static Connection connection;

    static
    {
        try {
            Class.forName("org.postgresql.Driver");
            connection = DriverManager.getConnection(URL, NAME, PASSWORD);
        } catch (ClassNotFoundException | SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public static Connection getDBConnection()
    {
        return connection;
    }
}
