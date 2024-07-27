package dao;
import model.User;
import model.User;
import testsql.Connect;

import java.sql.*;
import java.util.ArrayList;

public class UserDAO implements DAOinterface<User>{

    public static UserDAO getInstance() {return new UserDAO();};

    @Override
    public int insert(User user) throws SQLException {
        Connection con = Connect.getConnection();
        Statement stmt = con.createStatement();
        String sql = "insert into user (username,password, hovaten) values('"+user.getUsername()+"','"+user.getPassword()+"','"+user.getHovaten()+"')";
        System.out.println(sql);
        int k = stmt.executeUpdate(sql);
        System.out.println("Bạn đã thực thi "+sql);
        System.out.println("Có "+k+" kết quả thay đổi");
        con.close();
        return k;
    }

    @Override
    public int update(User user) throws SQLException {
        Connection con = Connect.getConnection();
        Statement stmt = con.createStatement();
        String sql = "update user "+
                     "set "+
                     "password = '"+user.getPassword()+
                     "' ,hovaten = "+user.getHovaten()+
                     " where username = '"+user.getUsername()+"';";
        int k=stmt.executeUpdate(sql);
        System.out.println(sql);
        con.close();
        return k;
    }

    @Override
    public int delete(User user) throws SQLException {
        Connection con = Connect.getConnection();
        Statement stmt = con.createStatement();
        String sql = "delete from user where username = '"+user.getUsername()+"';";
        System.out.println(sql);
        int k=stmt.executeUpdate(sql);
        return k;
    }

    @Override
    public ArrayList<User> getAll() throws SQLException {
        ArrayList<User> ketqua = new ArrayList<>();
        Connection con = Connect.getConnection();
        Statement stmt = con.createStatement();

        String sql = "select * from user";
        System.out.println(sql);
        ResultSet rs = stmt.executeQuery(sql);

        while (rs.next()) {
            String username = rs.getString("username");
            String password = rs.getString("password");
            String hovaten = rs.getString("hovaten");
            User user = new User(username,password,hovaten);
            ketqua.add(user);
        }
        con.close();
        return ketqua;
    }

    @Override
    public User getById(User u) throws SQLException {
        ArrayList<User> ketqua = new ArrayList<>();
        Connection con = Connect.getConnection();

        String sql = "select * from user where username = ?";
        PreparedStatement stmt = con.prepareStatement(sql);
        stmt.setString(1,u.getUsername());

        ResultSet rs = stmt.executeQuery();

        User user = null;
        if (rs.next()) { // Kiểm tra nếu có hàng trong ResultSet
            String username = rs.getString("username");
            String password = rs.getString("password");
            String hovaten = rs.getString("hovaten");
            user = new User(username, password, hovaten);
        }

        con.close();
        return user;
    }

    @Override
    public ArrayList<User> getByCondition(String condition) throws SQLException {
        ArrayList<User> ketqua = new ArrayList<>();
        Connection con = Connect.getConnection();
        Statement stmt = con.createStatement();

        String sql = "select * from user where "+condition;
        System.out.println(sql);
        ResultSet rs = stmt.executeQuery(sql);

        while (rs.next()) {
            String username = rs.getString("username");
            String password = rs.getString("password");
            String hovaten = rs.getString("hovaten");
            User user = new User(username,password,hovaten);
            ketqua.add(user);
        }

        con.close();
        return ketqua;
    }
}
