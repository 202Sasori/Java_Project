/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Ban_Doc;

import DBConnection.ConnectDB;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author FPT
 */
public class Them_Xoa_Sua_Ban_Doc extends Ban_Doc{
        public static List<Ban_Doc> findBanDocAll() {//Lấy ra danh sách bạn đọc
            List<Ban_Doc> ListBD = new ArrayList<>();//Quản lý dữ liệu đầu ra
            Connection connection = null;
            Statement stm = null;//Lấy dữ liệu từ DB đổ ra
            try {
               connection = DriverManager.getConnection("jdbc:sqlserver://localhost:1433;databaseName=QLTV", "sa", "123456@Ab");
               String sql = " SELECT * FROM DBO.BANDOC";
               stm = connection.createStatement();
               ResultSet rs = stm.executeQuery(sql);
               while(rs.next()){
                   Ban_Doc bd = new Ban_Doc(rs.getString("MABD"), rs.getString("TENBD"), rs.getString("SDT"), rs.getString("DIACHI"),rs.getString("GIOITINH"), rs.getString("SACHMUON"));
                   ListBD.add(bd);
               }
               stm.close();
            } catch (Exception ex) {
                 Logger.getLogger(Them_Xoa_Sua_Ban_Doc.class.getName()).log(Level.SEVERE, null, ex);
            }
            return ListBD;
        }
        //Thêm bạn đọc
        public static void insertBD(Ban_Doc banDoc){
            Connection connection;
            PreparedStatement pts;
            try {
                 connection = DriverManager.getConnection("jdbc:sqlserver://localhost:1433;databaseName=QLTV", "sa", "123456@Ab");
                 String sql = "INSERT INTO DBO.BANDOC(MABD, TENBD, SDT, DIACHI, GIOITINH, SACHMUON)"
                         +"VALUES(?,?,?,?,?,?)";
                 pts = connection.prepareCall(sql);
                 pts.setString(1, banDoc.getMaBD());
                 pts.setString(2, banDoc.getTenBD());
                 pts.setString(3, banDoc.getSDT());
                 pts.setString(4, banDoc.getDiaChiBD());
                 pts.setString(5, banDoc.getGioiTinh());
                 pts.setString(6, banDoc.getSachMuon());
                 pts.executeUpdate();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        //Sửa thông tin bạn đọc
        public static void updateBD(Ban_Doc banDoc){
            Connection connection = null;
            PreparedStatement pts = null;
            try {
                connection = DriverManager.getConnection("jdbc:sqlserver://localhost:1433;databaseName=QLTV", "sa", "123456@Ab");
                String sql = "UPDATE BANDOC SET TENBD = ?, SDT = ?, DIACHI = ?,  GIOITINH = ?, SACHMUON = ? WHERE MABD = ?";
                pts = connection.prepareCall(sql);
                pts.setString(6, banDoc.getMaBD());
                pts.setString(1, banDoc.getTenBD());
                pts.setString(2, banDoc.getSDT());
                pts.setString(3, banDoc.getDiaChiBD());
                pts.setString(4, banDoc.getGioiTinh());
                pts.setString(5, banDoc.getSachMuon());
                pts.executeUpdate();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        //Xóa thông tin bạn đọc
        public static void deleteBD(String maBD){
            Connection connection = null;
            PreparedStatement pts = null;
            try {
                 connection = DriverManager.getConnection("jdbc:sqlserver://localhost:1433;databaseName=QLTV", "sa", "123456@Ab");
                 String sql = "DELETE FROM DBO.BANDOC WHERE MABD = ?";
                 pts = connection.prepareCall(sql);
                 pts.setString(1, maBD);
                 pts.executeUpdate();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        //Tìm kiếm bạn đọc theo mã bạn đọc
        public static List<Ban_Doc> timKiemBD(String maBD){
            List<Ban_Doc> BDTV = new ArrayList<>();
            Connection connection = null;
            PreparedStatement pts = null;
            try {
                 connection = DriverManager.getConnection("jdbc:sqlserver://localhost:1433;databaseName=QLTV", "sa", "123456@Ab");
                 String sql = "SELECT * FROM BANDOC WHERE MABD LIKE ?";
                 pts = connection.prepareCall(sql);
                 pts.setString(1, "%"+maBD+"%");
                 ResultSet rs = pts.executeQuery();
                 while (rs.next()) {
                    Ban_Doc bd = new Ban_Doc(rs.getString("MABD"), rs.getString("TENBD"), rs.getString("SDT"), rs.getString("DIACHI"),rs.getString("GIOITINH"),rs.getString("SACHMUON"));
                    BDTV.add(bd);
            }
            } catch (Exception e) {
                e.printStackTrace();
            }
            return BDTV;
        }
}
