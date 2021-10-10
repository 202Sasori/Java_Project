/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Sach;

import java.sql.Connection;
import java.sql.Statement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

/**
 *
 * @author FPT
 */
public class Chuc_nang_muon_tra_sach extends Sach_Thu_Vien{
    public static List<MuonTra_Sach> hienThiAllMuonTra(){
        List<MuonTra_Sach> ListMT = new ArrayList<>();
        Connection  connection = null;
        Statement stm = null;
        try {
            connection = DriverManager.getConnection("jdbc:sqlserver://localhost:1433;databaseName=QLTV", "sa", "123456@Ab");
            String sql = "SELECT * FROM MUONTRA";
            stm = connection.createStatement();
            ResultSet rs = stm.executeQuery(sql);
            while(rs.next()){
                MuonTra_Sach mts = new MuonTra_Sach(rs.getString("MABD"),rs.getString("MASACH"), rs.getString("NGAYMUON"),rs.getString("NGAYTRA"),rs.getInt("SOLUONG"));
                ListMT.add(mts);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return ListMT;
    }
    
    //Thêm mượn trả
    public static void insert(MuonTra_Sach mt){
        Connection connection;
        PreparedStatement pst;
        try {
            connection = DriverManager.getConnection("jdbc:sqlserver://localhost:1433;databaseName=QLTV", "sa", "123456@Ab");
            String sql = "INSERT INTO MUONTRA(MABD,MASACH,NGAYMUON,NGAYTRA,SOLUONG) VALUES(?,?,?,?,?)";
            pst = connection.prepareCall(sql);
            pst.setString(1, mt.getMaBD());
            pst.setString(2, mt.getMaSach());
            pst.setString(3, mt.getNgayMuon());
            pst.setString(4, mt.getNgayTra());
            pst.setInt(5, mt.getSoLuong());
            pst.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    //Sửa thông tin mượn trả
    public static void update(MuonTra_Sach mt){
        Connection connection = null;
        PreparedStatement pts = null;
        try {
            connection = DriverManager.getConnection("jdbc:sqlserver://loacalhost:1433;databaseName=QLTV","sa","123456@Ab");
            String sql = "UPDATE MUONTRA SET MABD = ?, MASACH = ?, NGAYMUON = ?, NGAYTRA = ?, SOLUONG = ?";
            pts = connection.prepareCall(sql);
            pts.setString(5,mt.getMaBD());
            pts.setString(1, mt.getMaSach());
            pts.setString(2, mt.getNgayMuon());
            pts.setString(3, mt.getNgayTra());
            pts.setInt(4, mt.getSoLuong());
            pts.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    //Trả sách 
    public static void deleteMuonTra(String maBD){
        Connection connection = null;
        PreparedStatement pst = null;
        try {
            connection = DriverManager.getConnection("jdbc:sqlserver://localhost:1433;databaseName=QLTV","sa","123456@Ab");
            String sql = "DELETE FROM MUONTRA WHERE MABD = ? ";
            pst = connection.prepareCall(sql);
            pst.setString(1, maBD);
            pst.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
