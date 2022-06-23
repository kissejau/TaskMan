package com.kissejau.taskman.dao;

import com.kissejau.taskman.entity.Task;

import java.util.List;

public interface DAO<T> {

    List<T> list();

    void create(T t);

    Task get(String id);

    void update(T t, String id);

    void delete(String id);
}
