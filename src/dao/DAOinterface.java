package dao;

import java.sql.SQLException;
import java.util.ArrayList;

public interface DAOinterface<T> {
     public int insert(T t) throws SQLException;
     public int update(T t) throws SQLException;
     public int delete(T t) throws SQLException;
     public ArrayList<T> getAll() throws SQLException;
     public T getById(T id) throws SQLException;
     public ArrayList<T> getByCondition(String condition) throws SQLException;
}
