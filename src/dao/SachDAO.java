package dao;
import model.Sach;
import testsql.Connect;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class SachDAO implements DAOinterface<Sach>{

    public static SachDAO getInstance() {return new SachDAO();};

    @Override
    public int insert(Sach sach) throws SQLException {
        Connection con = Connect.getConnection();
        Statement stmt = con.createStatement();
        String sql = "insert into sach (id,tenSach,giaBan,namXuatBan) values('"+sach.getId()+"','"+sach.getTenSach()+"',"+sach.getGiaBan()+","+sach.getNamXuatBan()+")";
        System.out.println(sql);
        int k = stmt.executeUpdate(sql);
        System.out.println("Bạn đã thực thi "+sql);
        System.out.println("Có "+k+" kết quả thay đổi");
        con.close();
        return k;
    }

    @Override
    public int update(Sach sach) throws SQLException {
        Connection con = Connect.getConnection();
        Statement stmt = con.createStatement();
        String sql = "update sach "+
                     "set "+
                     "tenSach = '"+ sach.getTenSach()+"' "+
                     ",giaBan = "+sach.getGiaBan()+
                     " ,namXuatBan = "+sach.getNamXuatBan()+
                     " where id = '"+sach.getId()+"';";
        int k=stmt.executeUpdate(sql);
        System.out.println(sql);
        con.close();
        return k;
    }

    @Override
    public int delete(Sach sach) throws SQLException {
        Connection con = Connect.getConnection();
        Statement stmt = con.createStatement();
        String sql = "delete from sach where id = '"+sach.getId()+"';";
        System.out.println(sql);
        int k=stmt.executeUpdate(sql);
        return k;
    }

    @Override
    public ArrayList<Sach> getAll() throws SQLException {
        ArrayList<Sach> ketqua = new ArrayList<>();
        Connection con = Connect.getConnection();
        Statement stmt = con.createStatement();

        String sql = "select * from sach";
        System.out.println(sql);
        ResultSet rs = stmt.executeQuery(sql);

        while (rs.next()) {
            String id = rs.getString("id");
            String tenSach = rs.getString("tenSach");
            float giaBan = rs.getFloat("giaBan");
            int namXuatBan = rs.getInt("namXuatBan");
            Sach sach = new Sach(id, tenSach, giaBan, namXuatBan);
            ketqua.add(sach);
        }

        con.close();
        return ketqua;
    }

    @Override
    public Sach getById(Sach s) throws SQLException {
        ArrayList<Sach> ketqua = new ArrayList<>();
        Connection con = Connect.getConnection();
        Statement stmt = con.createStatement();
        String id = s.getId();

        String sql = "select * from sach where id = '"+id+"';";
        System.out.println(sql);
        ResultSet rs = stmt.executeQuery(sql);

        String sid = rs.getString("id");
        String tenSach = rs.getString("tenSach");
        float giaBan = rs.getFloat("giaBan");
        int namXuatBan = rs.getInt("namXuatBan");
        Sach sach = new Sach(sid, tenSach, giaBan, namXuatBan);

        con.close();
        return sach;
    }

    @Override
    public ArrayList<Sach> getByCondition(String condition) throws SQLException {
        ArrayList<Sach> ketqua = new ArrayList<>();
        Connection con = Connect.getConnection();
        Statement stmt = con.createStatement();

        String sql = "select * from sach where "+condition;
        System.out.println(sql);
        ResultSet rs = stmt.executeQuery(sql);

        while (rs.next()) {
            String id = rs.getString("id");
            String tenSach = rs.getString("tenSach");
            float giaBan = rs.getFloat("giaBan");
            int namXuatBan = rs.getInt("namXuatBan");
            Sach sach = new Sach(id, tenSach, giaBan, namXuatBan);
            ketqua.add(sach);
        }

        con.close();
        return ketqua;
    }
}
