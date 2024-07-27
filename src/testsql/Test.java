package testsql;

import dao.KhachHangDAO;
import dao.SachDAO;
import dao.UserDAO;
import model.KhachHang;
import model.Sach;
import model.User;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class Test {
    public static void main(String[] args) throws SQLException {
         ArrayList<KhachHang> khachHangList = KhachHangDAO.getInstance().getByCondition("where hoVaTen='Jack'");
         for (KhachHang khachHang : khachHangList) {
             System.out.println(khachHang.getHoVaTen());
         }
    }
}
