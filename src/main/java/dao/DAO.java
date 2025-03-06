package dao;

import java.sql.Connection;
import java.util.List;

public abstract class DAO<T> {
    protected Connection connection;

    public DAO(Connection connection) {
        this.connection = connection;
    }

    public abstract boolean insert(T obj);
    public abstract boolean update(T obj);
    public abstract boolean delete(int id);
    public abstract List<T> getAll();
    public abstract T getById(int id);
}
