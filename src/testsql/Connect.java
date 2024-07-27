package testsql;//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.

import java.sql.*;


public class Connect {
    public static Connection getConnection() throws SQLException {
        Connection c = null;
        //Các thông số
        String url = "jdbc:mysql://localhost:3306/nhasach";
        String user = "root";
        String password = "Hung2004@";
        //Tạo kết nối
        c = DriverManager.getConnection(url,user,password);
        return c;
    }

    public static void closeConnection(Connection con) throws SQLException {
        if(con!=null){con.close();};
    }

    public static void printInfo(Connection c) throws SQLException {
        if(c!=null){
            DatabaseMetaData mtdt = c.getMetaData();
            System.out.println(mtdt.getDatabaseProductName());
            System.out.println(mtdt.getDatabaseProductVersion());
            System.out.println(mtdt.getDriverName());
        }
    }
    public static void main(String[] args) throws SQLException {
        Connection con = Connect.getConnection();
        printInfo(con);
        closeConnection(con);
        //printInfo(con);
    }
}