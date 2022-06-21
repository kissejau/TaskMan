package com.kissejau.taskman.dao;


import javax.swing.plaf.nimbus.State;
import java.sql.SQLException;
import java.sql.Statement;

public class DBManager {


    private static Statement statement;

    private static String createTable = "CREATE TABLE taskman(" +
            "id bigint," +
            "name varchar(90)" +
            "context varchar(250)," +
            "date varchar(50)" +
            ")";

    static {
        try {
            statement = DBConnector.getDBConnection().createStatement();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
//        try {
//            statement.execute(createTable);
//        } catch (SQLException e) {
//            throw new RuntimeException(e);
//        }
    }

    public static Statement getStatement()
    {
        return statement;
    }
}
