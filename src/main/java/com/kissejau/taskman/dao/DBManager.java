package com.kissejau.taskman.dao;


import java.sql.SQLException;
import java.sql.Statement;

public class DBManager {


    private static Statement statement;

    static {
        try {
            statement = DBConnector.getDBConnection().createStatement();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public static Statement getStatement()
    {
        return statement;
    }
}
