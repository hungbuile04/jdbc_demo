package dao;

import model.KhachHang;
import model.Sach;
import testsql.Connect;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;

public class KhachHangDAO implements DAOinterface<KhachHang>{
    public static KhachHangDAO getInstance(){return new KhachHangDAO();}


    @Override
    public int insert(KhachHang khachHang) throws SQLException {
        Connection con = Connect.getConnection();
        Statement stmt = con.createStatement();
        String sql = "insert into khachhang (id,hoVaTen,ngaySinh,diaChi) values("+khachHang.getId()+",'"+khachHang.getHoVaTen()+"','"+khachHang.getNgaySinh()+"','"+khachHang.getDiaChi()+"')";
        int k = stmt.executeUpdate(sql);
        System.out.println("Bạn đã thực thi "+sql);
        System.out.println("Có "+k+" kết quả thay đổi");
        con.close();
        return k;
    }

    @Override
    public int update(KhachHang khachHang) throws SQLException {
        Connection con = Connect.getConnection();
        Statement stmt = con.createStatement();
        String sql = "update khachhang "+
                "set "+
                "hoVaTen = '"+ khachHang.getHoVaTen()+"' "+
                ",ngaySinh = '"+khachHang.getNgaySinh()+"' "+
                " ,diaChi = '"+khachHang.getDiaChi()+"' "+
                " where id = "+khachHang.getId()+";";
        int k=stmt.executeUpdate(sql);
        con.close();
        return k;
    }

    @Override
    public int delete(KhachHang khachHang) throws SQLException {
        Connection con = Connect.getConnection();
        Statement stmt = con.createStatement();
        String sql = "delete from khachHang where id = "+khachHang.getId()+";";
        int k=stmt.executeUpdate(sql);
        return k;
    }

    @Override
    public ArrayList<KhachHang> getAll() throws SQLException {
        ArrayList<KhachHang> ketqua = new ArrayList<>();
        Connection con = Connect.getConnection();
        Statement stmt = con.createStatement();

        String sql = "select * from khachhang";
        System.out.println(sql);
        ResultSet rs = stmt.executeQuery(sql);

        while (rs.next()) {
            int id = rs.getInt("id");
            String hoVaTen = rs.getString("hoVaTen");
            Date ngaySinh = rs.getDate("ngaySinh");
            String diaChi = rs.getString("diaChi");
            KhachHang khachHang = new KhachHang(id, hoVaTen, ngaySinh, diaChi);
            ketqua.add(khachHang);
        }

        con.close();
        return ketqua;
    }

    @Override
    public KhachHang getById(KhachHang kh) throws SQLException {
        ArrayList<KhachHang> ketqua = new ArrayList<>();
        Connection con = Connect.getConnection();
        Statement stmt = con.createStatement();
        int id = kh.getId();

        String sql = "select * from khachhang where id = "+id+";";
        System.out.println(sql);
        ResultSet rs = stmt.executeQuery(sql);

        int kid = rs.getInt("id");
        String hoVaTen = rs.getString("hoVaTen");
        Date ngaySinh = rs.getDate("ngaySinh");
        String diaChi = rs.getString("diaChi");
        KhachHang khachHang = new KhachHang(kid, hoVaTen, ngaySinh, diaChi);

        con.close();
        return khachHang;
    }

    @Override
    public ArrayList<KhachHang> getByCondition(String condition) throws SQLException {
        ArrayList<KhachHang> ketqua = new ArrayList<>();
        Connection con = Connect.getConnection();
        Statement stmt = con.createStatement();

        String sql = "select * from khachhang "+condition;
        System.out.println(sql);
        ResultSet rs = stmt.executeQuery(sql);

        while (rs.next()) {
            int id = rs.getInt("id");
            String hoVaTen = rs.getString("hoVaTen");
            Date ngaySinh = rs.getDate("ngaySinh");
            String diaChi = rs.getString("diaChi");
            KhachHang khachHang = new KhachHang(id, hoVaTen, ngaySinh, diaChi);
            ketqua.add(khachHang);
        }

        con.close();
        return ketqua;
    }
}
