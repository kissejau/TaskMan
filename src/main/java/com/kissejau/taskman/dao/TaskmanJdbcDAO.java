package com.kissejau.taskman.dao;

import com.kissejau.taskman.entity.Task;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

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
            task.setId(rs.getInt("id"));
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
            throw new RuntimeException(e);
        }
        return tasks;
    }

    @Override
    public void create(Task task) {
        String sql = "INSERT INTO taskman(name, context, date) VALUES('"
                + task.getName() + "', '" + task.getContext() + "', '"
                + task.getDate() + "')";
        try {
            statement.execute(sql);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public Optional get(int id) {
        return Optional.empty();
    }

    @Override
    public void update(Task task, int id) {

    }

    @Override
    public void delete(int id) {

    }


}
