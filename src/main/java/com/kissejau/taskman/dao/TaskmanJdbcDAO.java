package com.kissejau.taskman.dao;

import com.kissejau.taskman.entity.Task;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class TaskmanJdbcDAO implements DAO<Task>{

    private static final Logger log = LoggerFactory.getLogger(TaskmanJdbcDAO.class);

    Statement statement;

    public TaskmanJdbcDAO()
    {
        statement = DBManager.getStatement();
    }

    private List<Task> colMapper(ResultSet rs)
    {
        ArrayList<Task> tasks = new ArrayList<Task>();

        while (true) {
            try {
                if (!rs.next()) break;
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
            tasks.add(rowMapper(rs));
        }

        return tasks;
    }

    private Task rowMapper(ResultSet rs)
    {
        Task task = new Task();

        try {
            task.setId(rs.getString("id"));
            task.setName(rs.getString("name"));
            task.setContext(rs.getString("context"));
            task.setDate(rs.getString("date"));
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return task;
    }


    @Override
    public List<Task> list() {
        String sql = "SELECT * FROM Taskman;";
        List<Task> tasks = null;
        try {
            tasks = colMapper(statement.executeQuery(sql));
        } catch (SQLException e) {
            log.info("Tasks weren`t defined");
            throw new RuntimeException(e);
        }
        log.info("");
        return tasks;
    }

    @Override
    public void create(Task task) {
        String sql = "INSERT INTO Taskman(id, name, context, date) VALUES('"
                + task.getId() + "', '"
                + task.getName() + "', '"
                + task.getContext() + "', '"
                + task.getDate() + "')";
        try {
            statement.execute(sql);
        } catch (SQLException e) {
            log.info("Task wasn`t created");
            throw new RuntimeException(e);
        }
    }

    @Override
    public Task get(String id) {
        Task task = null;
        String sql = "SELECT * FROM Taskman WHERE id='" + id + "'";
        try {
            task = colMapper(statement.executeQuery(sql)).get(0);
        } catch (SQLException e) {
            log.info("Task wasn`t got");
            throw new RuntimeException(e);
        }
        return task;
    }

    @Override
    public void update(Task task, String id)
    {
        String sql = "UPDATE Taskman SET (name, context) " +
                "= ('" + task.getName() + "', '" + task.getContext() + "') " +
                "WHERE id = '" + id + "'";
        try {
            statement.executeUpdate(sql);
        } catch (SQLException e) {
            log.info("Task wasn`t update");
            throw new RuntimeException(e);
        }
    }

    @Override
    public void delete(String id) {
        String sql = "DELETE FROM Taskman WHERE id='" + id + "'";
        try {
            statement.execute(sql);
        } catch (SQLException e) {
            log.info("Task wasnt`t update");
            throw new RuntimeException(e);
        }
    }


}
