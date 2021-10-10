/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Sach;

import java.sql.PreparedStatement;
import java.sql.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author FPT
 */
public class Them_Xoa_Sua_Sach extends Sach_Thu_Vien{
    public static List<Sach_Thu_Vien> findSachAll(){//Lấy ra danh sách các sinh viên
        List<Sach_Thu_Vien> TVlist = new ArrayList<>();//Quản lý dữ liệu đầu ra
        Connection connection = null;
        Statement stm = null;
        try {
            connection = DriverManager.getConnection("jdbc:sqlserver://localhost:1433;databaseName=QLTV", "sa", "123456@Ab");
            String sql = "SELECT * FROM DBO.SACH";
            stm = connection.createStatement();//Tạo đối tượng
            ResultSet rs = stm.executeQuery(sql);//rs(con trỏ)//lấy dữ liệu trả về
            while (rs.next()) {//cho phép chuyển từng bản ghi trên dữ liệu đầu ra
                Sach_Thu_Vien stv = new Sach_Thu_Vien(rs.getString("MASACH"), rs.getString("TENSACH"), rs.getInt("GIASACH"), rs.getString("KESO"), rs.getString("THELOAI"), rs.getString("NHAXB"), rs.getInt("NAMXB"));
                TVlist.add(stv);
            }
            stm.close();
        } catch (Exception ex) {
            Logger.getLogger(Them_Xoa_Sua_Sach.class.getName()).log(Level.SEVERE, null, ex);
        }
        return TVlist;//trả về ds các sv lấy ra từ database
    }
    //Thêm sách vào thư viện
    public static void insert(Sach_Thu_Vien sach) {
        Connection connection = null;
        PreparedStatement  pst = null;
        try {
            connection = DriverManager.getConnection("jdbc:sqlserver://localhost:1433;databaseName=QLTV","sa","123456@Ab");
            String sql = "INSERT INTO DBO.SACH(MASACH, TENSACH, GIASACH, KESO, THELOAI, NHAXB, NAMXB)"+
                    "VALUES(?,?,?,?,?,?,?)";
            pst = connection.prepareCall(sql);//Gọi ra đối tượng và lưu trữ
            pst.setString(1, sach.getMaSach());
            pst.setString(2, sach.getTenSach());
            pst.setInt(3, sach.getGiaSach());
            pst.setString(4, sach.getKeSo());
            pst.setString(5, sach.getTheLoai());
            pst.setString(6, sach.getNhaXuatBan());
            pst.setInt(7, sach.getNamXuatBan());
            pst.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    //Cập nhật sách trong thư viện
    public static void update(Sach_Thu_Vien sach){
        Connection connection = null;
        PreparedStatement pst = null;
        try {
            connection = DriverManager.getConnection("jdbc:sqlserver://localhost:1433;databaseName=QLTV","sa","123456@Ab");
            String sql = "UPDATE SACH SET TENSACH = ?, GIASACH = ?, KESO = ?, THELOAI = ?, NHAXB = ?, NAMXB = ? WHERE MASACH = ?";
            pst = connection.prepareCall(sql);
            pst.setString(7, sach.getMaSach());
            pst.setString(1, sach.getTenSach());
            pst.setInt(2, sach.getGiaSach());
            pst.setString(3, sach.getKeSo());
            pst.setString(4, sach.getTheLoai());
            pst.setString(5, sach.getNhaXuatBan());
            pst.setInt(6, sach.getNamXuatBan());
            pst.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    //Xóa sách trong CSDL sách
    public static void deleteSach(String MASACH){
        Connection connection = null;
        PreparedStatement pts = null;
        try {
            connection = DriverManager.getConnection("jdbc:sqlserver://localhost:1433;databasename = QLTV","sa","123456@Ab");
            String sql = "DELETE FORM SACH WHERE MASACH = ?";
            pts = connection.prepareCall(sql);
            pts.setString(1, MASACH);
            pts.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    //Tìm kiếm sách theo mã sách trong thư viện
    public static List<Sach_Thu_Vien> timKiemSach(String maSach){
            List<Sach_Thu_Vien> STV = new ArrayList<>();
            Connection connection = null;
            PreparedStatement pts = null;
            try {
                 connection = DriverManager.getConnection("jdbc:sqlserver://localhost:1433;databaseName=QLTV", "sa", "123456@Ab");
                 String sql = "SELECT * FROM SACH WHERE MASACH LIKE ?";
                 pts = connection.prepareCall(sql);
                 pts.setString(1, "%"+maSach+"%");
                 ResultSet rs = pts.executeQuery();
                 while (rs.next()) {
                    Sach_Thu_Vien bd = new Sach_Thu_Vien(rs.getString("MASACH"),rs.getString("TENSACH"), rs.getInt("GIASACH"), rs.getString("KESO"), rs.getString("THELOAI"),rs.getString("NHAXB"),rs.getInt("NAMXB"));
                    STV.add(bd);
            }
            } catch (Exception e) {
                e.printStackTrace();
            }
            return STV;
        }
     
}
