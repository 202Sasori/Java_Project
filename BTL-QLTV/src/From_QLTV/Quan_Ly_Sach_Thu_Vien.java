/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package From_QLTV;

import Sach.Them_Xoa_Sua_Sach;
import Sach.Sach_Thu_Vien;
import DBConnection.ConnectDB;
import Ban_Doc.Ban_Doc;
import Ban_Doc.Them_Xoa_Sua_Ban_Doc;

import java.awt.Color;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author daovi
 */
public class Quan_Ly_Sach_Thu_Vien extends javax.swing.JFrame {
    public static Menu menu = new Menu();
    DefaultTableModel tableSach;//Tạo bảng trống
    DefaultTableModel tableBD;
    List<Sach_Thu_Vien> STV = new ArrayList<>();//Lưu danh sách có trong sách thư viện
    List<Ban_Doc> BDTV = new ArrayList<>();
    public Quan_Ly_Sach_Thu_Vien() {
        initComponents();
        tableBD = (DefaultTableModel) tabBanDoc.getModel();
        showBD();
        showDuLieuBanDoc();
        tableSach = (DefaultTableModel) tabBook.getModel();
        showSachTV();
        showDuLieuSachTV();
    }
    //Hiển thị dữ liệu sách trong thư viên
    public void showSachTV(){
        STV = Them_Xoa_Sua_Sach.findSachAll();//
        tableSach.setRowCount(0);//Xóa dữ liệu trong bảng
        for (Sach_Thu_Vien sachTV: STV){
            tableSach.addRow(new Object[]{sachTV.getMaSach(),sachTV.getTenSach(),sachTV.getGiaSach(), sachTV.getKeSo(), sachTV.getTheLoai(), sachTV.getNhaXuatBan(), sachTV.getNamXuatBan()});
        }
    }
    
     public void showDuLieuSachTV(){
        try {
            tabBook.getSelectionModel().addListSelectionListener(new ListSelectionListener(){
                 @Override
                 public void valueChanged(ListSelectionEvent e) {
                    if (tabBook.getSelectedRow() >= 0) {
                        txtMaSach.setText(tabBook.getValueAt(tabBook.getSelectedRow(), 0) + "");
                        txtTenSach.setText(tabBook.getValueAt(tabBook.getSelectedRow(), 1) + "");
                        txtGiaSach.setText(tabBook.getValueAt(tabBook.getSelectedRow(), 2) + "");
                        txtKeSo.setText(tabBook.getValueAt(tabBook.getSelectedRow(), 3) + "");
                        txtTheLoai.setText(tabBook.getValueAt(tabBook.getSelectedRow(), 4) + "");
                        txtNhaXuatBan.setText(tabBook.getValueAt(tabBook.getSelectedRow(), 5) + "");
                        txtNamXuatBan.setText(tabBook.getValueAt(tabBook.getSelectedRow(), 6) + "");
                    }
                }
            });
        } catch (Exception e) {
            System.out.println(e.toString());
        }
    }
    //Hiển thị dữ liêu bạn đọc trong thư viện
    public void showBD(){
        BDTV = Them_Xoa_Sua_Ban_Doc.findBanDocAll();
        tableBD.setRowCount(0);
        for (Ban_Doc BD: BDTV){
            tableBD.addRow(new Object[]{BD.getMaBD(),BD.getTenBD(),BD.getSDT(),BD.getDiaChiBD(), BD.getGioiTinh(), BD.getSachMuon()});
        }
    }
    public void showDuLieuBanDoc(){
        try {
           tabBanDoc.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
               @Override
               public void valueChanged(ListSelectionEvent e) {
                    if (tabBanDoc.getSelectedRow() >= 0) {
                        txtMaBD.setText(tabBanDoc.getValueAt(tabBanDoc.getSelectedRow(), 0) + "");
                        txtTenBD.setText(tabBanDoc.getValueAt(tabBanDoc.getSelectedRow(), 1) + "");
                        txtSDT.setText(tabBanDoc.getValueAt(tabBanDoc.getSelectedRow(), 2) + "");
                        txtDiaChi.setText(tabBanDoc.getValueAt(tabBanDoc.getSelectedRow(), 3) + "");
                        txtGioiTinh.setText(tabBanDoc.getValueAt(tabBanDoc.getSelectedRow(), 4) + "");
                        txtSachMuon.setText(tabBanDoc.getValueAt(tabBanDoc.getSelectedRow(), 5) + "");
                    }
               }
           }); 
        } catch (Exception e) {
             System.out.println(e.toString());
        }
    }
    public void showSachA1(){
        try{
        tabA1.removeAll();
        String[] arr = {"Mã sách", "Tên sách", "giá sách"};
        DefaultTableModel model = new DefaultTableModel(arr, 0);
        
        Connection connection = ConnectDB.getConnection();
        String query ="SELECT MASACH, TENSACH, GIASACH FROM DBO.SACH WHERE KESO = 'A1' ";
        PreparedStatement ps = connection.prepareStatement(query);
        ResultSet rs = ps.executeQuery();
        while(rs.next()){
            Vector vector = new Vector();
            vector.add(rs.getString("MASACH"));
            vector.add(rs.getString("TENSACH"));
            vector.add(rs.getString("GIASACH"));
            model.addRow(vector); 
        }
        ConnectDB.closeConnection(connection);
        tabA1.setModel(model);
        }catch(SQLException ex){
          Logger.getLogger(Quan_Ly_Sach_Thu_Vien.class.getName()).log(Level.SEVERE, null, ex);  
        }
    }
     public void showSachA2(){
        try{
        tabA2.removeAll();
        String[] arr = {"Mã sách", "Tên sách", "giá sách"};
        DefaultTableModel model = new DefaultTableModel(arr, 0);
        
        Connection connection = ConnectDB.getConnection();
        String query ="SELECT MASACH, TENSACH, GIASACH FROM DBO.SACH WHERE KESO = 'A2' ";
        PreparedStatement ps = connection.prepareStatement(query);
        ResultSet rs = ps.executeQuery();
        while(rs.next()){
            Vector vector = new Vector();
            vector.add(rs.getString("MASACH"));
            vector.add(rs.getString("TENSACH"));
            vector.add(rs.getString("GIASACH"));
            model.addRow(vector); 
        }
        ConnectDB.closeConnection(connection);
        tabA2.setModel(model);
        }catch(SQLException ex){
          Logger.getLogger(Quan_Ly_Sach_Thu_Vien.class.getName()).log(Level.SEVERE, null, ex);  
        }
    }
      public void showSachA3(){
        try{
        tabA3.removeAll();
        String[] arr = {"Mã sách", "Tên sách", "giá sách"};
        DefaultTableModel model = new DefaultTableModel(arr, 0);
        
        Connection connection = ConnectDB.getConnection();
        String query ="SELECT MASACH, TENSACH, GIASACH FROM DBO.SACH WHERE KESO = 'A3' ";
        PreparedStatement ps = connection.prepareStatement(query);
        ResultSet rs = ps.executeQuery();
        while(rs.next()){
            Vector vector = new Vector();
            vector.add(rs.getString("MASACH"));
            vector.add(rs.getString("TENSACH"));
            vector.add(rs.getString("GIASACH"));
            model.addRow(vector); 
        }
        ConnectDB.closeConnection(connection);
        tabA3.setModel(model);
        }catch(SQLException ex){
          Logger.getLogger(Quan_Ly_Sach_Thu_Vien.class.getName()).log(Level.SEVERE, null, ex);  
        }
    }
       public void showSachA4(){
        try{
        tabA4.removeAll();
        String[] arr = {"Mã sách", "Tên sách", "giá sách"};
        DefaultTableModel model = new DefaultTableModel(arr, 0);
        
        Connection connection = ConnectDB.getConnection();
        String query ="SELECT MASACH, TENSACH, GIASACH FROM DBO.SACH WHERE KESO = 'A4' ";
        PreparedStatement ps = connection.prepareStatement(query);
        ResultSet rs = ps.executeQuery();
        while(rs.next()){
            Vector vector = new Vector();
            vector.add(rs.getString("MASACH"));
            vector.add(rs.getString("TENSACH"));
            vector.add(rs.getString("GIASACH"));
            model.addRow(vector); 
        }
        ConnectDB.closeConnection(connection);
        tabA4.setModel(model);
        }catch(SQLException ex){
          Logger.getLogger(Quan_Ly_Sach_Thu_Vien.class.getName()).log(Level.SEVERE, null, ex);  
        }
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel8 = new javax.swing.JPanel();
        book__title = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tabBook = new javax.swing.JTable();
        jPanel12 = new javax.swing.JPanel();
        jPanel10 = new javax.swing.JPanel();
        book__nameText2 = new javax.swing.JLabel();
        book__idText2 = new javax.swing.JLabel();
        book__priceText2 = new javax.swing.JLabel();
        book__shelfText2 = new javax.swing.JLabel();
        book__nhaXuatBan2 = new javax.swing.JLabel();
        book__namXuatBan2 = new javax.swing.JLabel();
        txtMaSach = new javax.swing.JTextField();
        txtTenSach = new javax.swing.JTextField();
        txtGiaSach = new javax.swing.JTextField();
        txtKeSo = new javax.swing.JTextField();
        txtNhaXuatBan = new javax.swing.JTextField();
        txtNamXuatBan = new javax.swing.JTextField();
        book_categoryText2 = new javax.swing.JLabel();
        txtTheLoai = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        jPanel13 = new javax.swing.JPanel();
        jPanel5 = new javax.swing.JPanel();
        btnThem = new javax.swing.JButton();
        btnXoa = new javax.swing.JButton();
        btnThoat = new javax.swing.JButton();
        btnSua = new javax.swing.JButton();
        btnNhapMoi = new javax.swing.JButton();
        jPanel14 = new javax.swing.JPanel();
        jLabel28 = new javax.swing.JLabel();
        txtTraCuuS = new javax.swing.JTextField();
        btnTraCuuS = new javax.swing.JToggleButton();
        jLabel13 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        reader__title = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        reader__panel1 = new javax.swing.JPanel();
        reader_idText1 = new javax.swing.JLabel();
        txtMaBD = new javax.swing.JTextField();
        reader_nameText1 = new javax.swing.JLabel();
        txtDiaChi = new javax.swing.JTextField();
        reader_phoneText1 = new javax.swing.JLabel();
        txtTenBD = new javax.swing.JTextField();
        reader_addressText1 = new javax.swing.JLabel();
        txtSDT = new javax.swing.JTextField();
        reader_genderText1 = new javax.swing.JLabel();
        txtGioiTinh = new javax.swing.JTextField();
        txtSachMuon = new javax.swing.JTextField();
        reader_sachmuonBox1 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        reader__function_panel = new javax.swing.JPanel();
        btnThemBD = new javax.swing.JButton();
        btnSuaBD = new javax.swing.JButton();
        btnThoatBD = new javax.swing.JButton();
        btnXoaBD = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabBanDoc = new javax.swing.JTable();
        btnTraCuu = new javax.swing.JToggleButton();
        txtTraCuu = new javax.swing.JTextField();
        jPanel2 = new javax.swing.JPanel();
        jPanel6 = new javax.swing.JPanel();
        leader = new javax.swing.JLabel();
        member1 = new javax.swing.JLabel();
        member2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jPanel7 = new javax.swing.JPanel();
        jButton1 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jPanel15 = new javax.swing.JPanel();
        jLabel17 = new javax.swing.JLabel();
        jScrollPane5 = new javax.swing.JScrollPane();
        tabA1 = new javax.swing.JTable();
        jScrollPane6 = new javax.swing.JScrollPane();
        tabA3 = new javax.swing.JTable();
        jScrollPane7 = new javax.swing.JScrollPane();
        tabA4 = new javax.swing.JTable();
        jScrollPane8 = new javax.swing.JScrollPane();
        tabA2 = new javax.swing.JTable();
        jLabel19 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Quản Lý Thư Viện");
        setBackground(new java.awt.Color(255, 255, 255));
        setFocusCycleRoot(false);
        setFont(new java.awt.Font("Space Mono", 0, 10)); // NOI18N

        jTabbedPane1.setBackground(new java.awt.Color(255, 255, 255));
        jTabbedPane1.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jTabbedPane1.setFocusCycleRoot(true);
        jTabbedPane1.setFont(new java.awt.Font("Space Mono", 0, 11)); // NOI18N

        jPanel8.setBackground(new java.awt.Color(255, 255, 255));
        jPanel8.addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentShown(java.awt.event.ComponentEvent evt) {
                hienThiSach(evt);
            }
        });

        book__title.setBackground(new java.awt.Color(255, 255, 255));
        book__title.setFont(new java.awt.Font("Space Mono", 1, 16)); // NOI18N
        book__title.setForeground(new java.awt.Color(51, 153, 255));
        book__title.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        book__title.setText("Quản Lý Sách");

        tabBook.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Mã Sách", "Tên Sách", "Giá Sách", "Kệ Số", "Loại Sách", "Nhà Xuất Bản", "Năm Xuất Bản"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Integer.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        jScrollPane2.setViewportView(tabBook);

        jPanel12.setBackground(new java.awt.Color(255, 255, 255));
        jPanel12.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jPanel10.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        book__nameText2.setFont(new java.awt.Font("Space Mono", 1, 11)); // NOI18N
        book__nameText2.setText("TÊN SÁCH:");

        book__idText2.setFont(new java.awt.Font("Space Mono", 1, 11)); // NOI18N
        book__idText2.setText("MÃ SÁCH:");

        book__priceText2.setFont(new java.awt.Font("Space Mono", 1, 11)); // NOI18N
        book__priceText2.setText("GIÁ SÁCH:");

        book__shelfText2.setFont(new java.awt.Font("Space Mono", 1, 11)); // NOI18N
        book__shelfText2.setText("KỆ SỐ:");

        book__nhaXuatBan2.setFont(new java.awt.Font("Space Mono", 1, 11)); // NOI18N
        book__nhaXuatBan2.setText("NHÀ XUẤT BẢN:");

        book__namXuatBan2.setFont(new java.awt.Font("Space Mono", 1, 11)); // NOI18N
        book__namXuatBan2.setText("NĂM XUẤT BẢN:");

        book_categoryText2.setFont(new java.awt.Font("Space Mono", 1, 11)); // NOI18N
        book_categoryText2.setText("THỂ LOẠI:");

        txtTheLoai.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtTheLoaiActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel10Layout = new javax.swing.GroupLayout(jPanel10);
        jPanel10.setLayout(jPanel10Layout);
        jPanel10Layout.setHorizontalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel10Layout.createSequentialGroup()
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel10Layout.createSequentialGroup()
                        .addGap(28, 28, 28)
                        .addComponent(book__priceText2)
                        .addGap(18, 18, 18)
                        .addComponent(txtGiaSach, javax.swing.GroupLayout.PREFERRED_SIZE, 161, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel10Layout.createSequentialGroup()
                        .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel10Layout.createSequentialGroup()
                                .addGap(28, 28, 28)
                                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(book__idText2)
                                    .addComponent(book__shelfText2))
                                .addGap(17, 17, 17))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel10Layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(book__nameText2)
                                .addGap(18, 18, 18)))
                        .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtMaSach, javax.swing.GroupLayout.PREFERRED_SIZE, 164, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtTenSach, javax.swing.GroupLayout.PREFERRED_SIZE, 164, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtKeSo, javax.swing.GroupLayout.PREFERRED_SIZE, 164, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 72, Short.MAX_VALUE)
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel10Layout.createSequentialGroup()
                        .addComponent(book__namXuatBan2)
                        .addGap(18, 18, 18)
                        .addComponent(txtNamXuatBan, javax.swing.GroupLayout.PREFERRED_SIZE, 185, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel10Layout.createSequentialGroup()
                        .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(book__nhaXuatBan2)
                            .addComponent(book_categoryText2))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtTheLoai, javax.swing.GroupLayout.DEFAULT_SIZE, 185, Short.MAX_VALUE)
                            .addComponent(txtNhaXuatBan))))
                .addGap(28, 28, 28))
        );
        jPanel10Layout.setVerticalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel10Layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(book__idText2)
                    .addComponent(txtMaSach, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(book_categoryText2)
                    .addComponent(txtTheLoai, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel10Layout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtTenSach, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(book__nameText2)))
                    .addGroup(jPanel10Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(book__nhaXuatBan2)
                            .addComponent(txtNhaXuatBan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(book__namXuatBan2)
                    .addComponent(book__priceText2)
                    .addComponent(txtGiaSach, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtNamXuatBan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(book__shelfText2)
                    .addComponent(txtKeSo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(40, Short.MAX_VALUE))
        );

        jLabel12.setFont(new java.awt.Font("Space Mono", 0, 16)); // NOI18N
        jLabel12.setText("Nhập Thông Tin Sách");

        javax.swing.GroupLayout jPanel12Layout = new javax.swing.GroupLayout(jPanel12);
        jPanel12.setLayout(jPanel12Layout);
        jPanel12Layout.setHorizontalGroup(
            jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel12Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel10, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel12Layout.createSequentialGroup()
                        .addComponent(jLabel12)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel12Layout.setVerticalGroup(
            jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel12Layout.createSequentialGroup()
                .addContainerGap(19, Short.MAX_VALUE)
                .addComponent(jLabel12)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jPanel13.setBackground(new java.awt.Color(255, 255, 255));
        jPanel13.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jPanel5.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        btnThem.setBackground(new java.awt.Color(255, 255, 255));
        btnThem.setFont(new java.awt.Font("Space Mono", 0, 11)); // NOI18N
        btnThem.setText("Thêm");
        btnThem.setFocusPainted(false);
        btnThem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnThemActionPerformed(evt);
            }
        });

        btnXoa.setBackground(new java.awt.Color(255, 255, 255));
        btnXoa.setFont(new java.awt.Font("Space Mono", 0, 11)); // NOI18N
        btnXoa.setText("Xóa");
        btnXoa.setFocusPainted(false);
        btnXoa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnXoaActionPerformed(evt);
            }
        });

        btnThoat.setText("Thoát");
        btnThoat.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnThoatActionPerformed(evt);
            }
        });

        btnSua.setBackground(new java.awt.Color(255, 255, 255));
        btnSua.setFont(new java.awt.Font("Space Mono", 0, 11)); // NOI18N
        btnSua.setText("Sửa");
        btnSua.setFocusPainted(false);
        btnSua.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSuaActionPerformed(evt);
            }
        });

        btnNhapMoi.setBackground(new java.awt.Color(255, 255, 255));
        btnNhapMoi.setFont(new java.awt.Font("Space Mono", 0, 11)); // NOI18N
        btnNhapMoi.setText("Nhập mới");
        btnNhapMoi.setFocusPainted(false);
        btnNhapMoi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNhapMoiActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                .addContainerGap(45, Short.MAX_VALUE)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnNhapMoi, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnSua, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnThoat, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnXoa, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnThem, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(36, 36, 36))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnThem)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnXoa, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 25, Short.MAX_VALUE)
                .addComponent(btnNhapMoi, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnSua, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnThoat)
                .addContainerGap())
        );

        jPanel14.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel28.setFont(new java.awt.Font("Space Mono", 0, 11)); // NOI18N
        jLabel28.setText("CHỨC NĂNG");

        javax.swing.GroupLayout jPanel14Layout = new javax.swing.GroupLayout(jPanel14);
        jPanel14.setLayout(jPanel14Layout);
        jPanel14Layout.setHorizontalGroup(
            jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel14Layout.createSequentialGroup()
                .addGap(51, 51, 51)
                .addComponent(jLabel28)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel14Layout.setVerticalGroup(
            jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel28, javax.swing.GroupLayout.DEFAULT_SIZE, 26, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jPanel13Layout = new javax.swing.GroupLayout(jPanel13);
        jPanel13.setLayout(jPanel13Layout);
        jPanel13Layout.setHorizontalGroup(
            jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel13Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel14, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel13Layout.setVerticalGroup(
            jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel13Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel14, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        btnTraCuuS.setText("Tìm kiếm");
        btnTraCuuS.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTraCuuSActionPerformed(evt);
            }
        });

        jLabel13.setText("Tìm kiếm theo mã sách");

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addComponent(book__title, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel8Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 894, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel8Layout.createSequentialGroup()
                        .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jPanel12, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel8Layout.createSequentialGroup()
                                .addGap(19, 19, 19)
                                .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(txtTraCuuS, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(btnTraCuuS, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(18, 18, 18)
                        .addComponent(jPanel13, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(37, 37, 37))
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(book__title, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel13, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel8Layout.createSequentialGroup()
                        .addComponent(jPanel12, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtTraCuuS, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnTraCuuS)
                            .addComponent(jLabel13))))
                .addGap(28, 28, 28)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Sách", jPanel8);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentShown(java.awt.event.ComponentEvent evt) {
                hienThi(evt);
            }
        });

        reader__title.setBackground(new java.awt.Color(255, 255, 255));
        reader__title.setFont(new java.awt.Font("Space Mono", 1, 16)); // NOI18N
        reader__title.setForeground(new java.awt.Color(51, 153, 255));
        reader__title.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        reader__title.setText("Quản Lý Đọc Giả");

        jPanel4.setBackground(new java.awt.Color(255, 255, 255));
        jPanel4.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        reader__panel1.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        reader__panel1.setFont(new java.awt.Font("Space Mono", 0, 11)); // NOI18N

        reader_idText1.setBackground(new java.awt.Color(255, 255, 255));
        reader_idText1.setFont(new java.awt.Font("Space Mono", 1, 11)); // NOI18N
        reader_idText1.setText("MÃ ĐỘC GIẢ:");

        txtMaBD.setFont(new java.awt.Font("Space Mono", 0, 11)); // NOI18N
        txtMaBD.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        reader_nameText1.setFont(new java.awt.Font("Space Mono", 1, 11)); // NOI18N
        reader_nameText1.setText("TÊN ĐỌC GIẢ:");

        txtDiaChi.setFont(new java.awt.Font("Space Mono", 0, 11)); // NOI18N
        txtDiaChi.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        reader_phoneText1.setFont(new java.awt.Font("Space Mono", 1, 11)); // NOI18N
        reader_phoneText1.setText("ĐIỆN THOẠI:");

        txtTenBD.setFont(new java.awt.Font("Space Mono", 0, 11)); // NOI18N
        txtTenBD.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        reader_addressText1.setFont(new java.awt.Font("Space Mono", 1, 11)); // NOI18N
        reader_addressText1.setText("ĐỊA CHỈ:");

        txtSDT.setFont(new java.awt.Font("Space Mono", 0, 11)); // NOI18N
        txtSDT.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        reader_genderText1.setFont(new java.awt.Font("Space Mono", 1, 11)); // NOI18N
        reader_genderText1.setText("GIỚI TÍNH:");

        txtGioiTinh.setFont(new java.awt.Font("Space Mono", 0, 11)); // NOI18N
        txtGioiTinh.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        txtSachMuon.setFont(new java.awt.Font("Space Mono", 0, 11)); // NOI18N
        txtSachMuon.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        reader_sachmuonBox1.setFont(new java.awt.Font("Space Mono", 1, 11)); // NOI18N
        reader_sachmuonBox1.setText("SÁCH MƯỢN:");

        javax.swing.GroupLayout reader__panel1Layout = new javax.swing.GroupLayout(reader__panel1);
        reader__panel1.setLayout(reader__panel1Layout);
        reader__panel1Layout.setHorizontalGroup(
            reader__panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(reader__panel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(reader__panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(reader__panel1Layout.createSequentialGroup()
                        .addComponent(reader_nameText1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(txtTenBD, javax.swing.GroupLayout.PREFERRED_SIZE, 169, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(reader__panel1Layout.createSequentialGroup()
                        .addComponent(reader_idText1, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(txtMaBD, javax.swing.GroupLayout.PREFERRED_SIZE, 169, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(reader__panel1Layout.createSequentialGroup()
                        .addComponent(reader_phoneText1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(txtSDT, javax.swing.GroupLayout.PREFERRED_SIZE, 169, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(28, 28, 28)
                .addGroup(reader__panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(reader__panel1Layout.createSequentialGroup()
                        .addComponent(reader_addressText1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(txtDiaChi, javax.swing.GroupLayout.PREFERRED_SIZE, 169, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(reader__panel1Layout.createSequentialGroup()
                        .addGroup(reader__panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(reader_sachmuonBox1)
                            .addComponent(reader_genderText1))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(reader__panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(reader__panel1Layout.createSequentialGroup()
                                .addComponent(txtSachMuon, javax.swing.GroupLayout.PREFERRED_SIZE, 159, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, reader__panel1Layout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(txtGioiTinh, javax.swing.GroupLayout.PREFERRED_SIZE, 169, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap())
        );
        reader__panel1Layout.setVerticalGroup(
            reader__panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(reader__panel1Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(reader__panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(reader_idText1)
                    .addComponent(txtMaBD, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtDiaChi, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(reader_addressText1))
                .addGap(18, 18, 18)
                .addGroup(reader__panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(reader_nameText1)
                    .addComponent(txtTenBD, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(reader_genderText1)
                    .addComponent(txtGioiTinh, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(reader__panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(reader_phoneText1)
                    .addComponent(txtSDT, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(reader_sachmuonBox1)
                    .addComponent(txtSachMuon, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(25, Short.MAX_VALUE))
        );

        jLabel11.setFont(new java.awt.Font("Space Mono", 0, 16)); // NOI18N
        jLabel11.setText("Nhập Thông Tin Độc Giả");

        reader__function_panel.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        btnThemBD.setBackground(new java.awt.Color(255, 255, 255));
        btnThemBD.setFont(new java.awt.Font("Space Mono", 0, 11)); // NOI18N
        btnThemBD.setText("Thêm");
        btnThemBD.setFocusPainted(false);
        btnThemBD.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnThemBDActionPerformed(evt);
            }
        });

        btnSuaBD.setBackground(new java.awt.Color(255, 255, 255));
        btnSuaBD.setFont(new java.awt.Font("Space Mono", 0, 11)); // NOI18N
        btnSuaBD.setText("Sửa");
        btnSuaBD.setFocusPainted(false);
        btnSuaBD.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSuaBDActionPerformed(evt);
            }
        });

        btnThoatBD.setBackground(new java.awt.Color(255, 255, 255));
        btnThoatBD.setFont(new java.awt.Font("Space Mono", 0, 11)); // NOI18N
        btnThoatBD.setText("Thoát");
        btnThoatBD.setFocusPainted(false);
        btnThoatBD.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnThoatBDActionPerformed(evt);
            }
        });

        btnXoaBD.setBackground(new java.awt.Color(255, 255, 255));
        btnXoaBD.setFont(new java.awt.Font("Space Mono", 0, 11)); // NOI18N
        btnXoaBD.setText("Xóa");
        btnXoaBD.setFocusPainted(false);
        btnXoaBD.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnXoaBDActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout reader__function_panelLayout = new javax.swing.GroupLayout(reader__function_panel);
        reader__function_panel.setLayout(reader__function_panelLayout);
        reader__function_panelLayout.setHorizontalGroup(
            reader__function_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(reader__function_panelLayout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addGroup(reader__function_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnThoatBD, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnXoaBD, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnSuaBD, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnThemBD, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(22, Short.MAX_VALUE))
        );
        reader__function_panelLayout.setVerticalGroup(
            reader__function_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(reader__function_panelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnThemBD, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnSuaBD, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnXoaBD, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnThoatBD, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(38, Short.MAX_VALUE))
        );

        tabBanDoc.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        tabBanDoc.setFont(new java.awt.Font("Space Mono", 0, 11)); // NOI18N
        tabBanDoc.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Mã Độc Giả", "Tên Độc Giả", "Số Điện Thoại", "Địa Chỉ", "Giới Tính", "Sách mượn"
            }
        ));
        tabBanDoc.setSelectionForeground(new java.awt.Color(51, 51, 51));
        tabBanDoc.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        tabBanDoc.setShowGrid(true);
        jScrollPane1.setViewportView(tabBanDoc);

        btnTraCuu.setText("Tra cứu");
        btnTraCuu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTraCuuActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(reader__panel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel11)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(txtTraCuu, javax.swing.GroupLayout.PREFERRED_SIZE, 172, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(39, 39, 39)
                        .addComponent(btnTraCuu, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(reader__function_panel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(71, 71, 71))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 909, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel11)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(reader__panel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnTraCuu)
                            .addComponent(txtTraCuu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(reader__function_panel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 33, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 149, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(reader__title, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addComponent(reader__title, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(26, 26, 26)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(26, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Đọc Giả", jPanel1);

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));

        jPanel6.setBackground(new java.awt.Color(255, 255, 255));
        jPanel6.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        leader.setFont(new java.awt.Font("Space Mono", 0, 11)); // NOI18N
        leader.setText("Member: Đào Việt Bảo");

        member1.setFont(new java.awt.Font("Space Mono", 0, 11)); // NOI18N
        member1.setText("Member: Trần Đức Tiến");

        member2.setFont(new java.awt.Font("Space Mono", 0, 11)); // NOI18N
        member2.setText("Member: Đinh Khắc Hoạt");

        jLabel3.setFont(new java.awt.Font("Space Mono", 0, 11)); // NOI18N
        jLabel3.setText("Mã Sinh Viên: 20200910");

        jLabel4.setFont(new java.awt.Font("Space Mono", 0, 11)); // NOI18N
        jLabel4.setText("Mã Sinh Viên: 20200184");

        jLabel5.setFont(new java.awt.Font("Space Mono", 0, 11)); // NOI18N
        jLabel5.setText("Mã Sinh Viên: 20200781");

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel6Layout.createSequentialGroup()
                .addGap(31, 31, 31)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(member1)
                    .addComponent(member2)
                    .addComponent(leader))
                .addGap(133, 133, 133)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel4)
                    .addComponent(jLabel5)
                    .addComponent(jLabel3))
                .addContainerGap(65, Short.MAX_VALUE))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGap(36, 36, 36)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(leader))
                .addGap(18, 18, 18)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(member1))
                .addGap(18, 18, 18)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(member2))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel7.setBackground(new java.awt.Color(255, 255, 255));
        jPanel7.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jButton1.setBackground(new java.awt.Color(255, 255, 255));
        jButton1.setFont(new java.awt.Font("Space Mono", 0, 11)); // NOI18N
        jButton1.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jButton1.setBorderPainted(false);
        jButton1.setFocusable(false);

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(22, Short.MAX_VALUE))
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(27, Short.MAX_VALUE))
        );

        jLabel1.setBackground(new java.awt.Color(255, 255, 255));
        jLabel1.setFont(new java.awt.Font("Space Mono", 0, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(51, 153, 255));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Team Member");
        jLabel1.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel2.setFont(new java.awt.Font("Space Mono", 0, 17)); // NOI18N
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("NHÓM 1");
        jLabel2.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel8.setFont(new java.awt.Font("Space Mono", 1, 24)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(51, 153, 255));
        jLabel8.setText("ĐẠI HỌC CÔNG NGHỆ ĐÔNG Á");

        jLabel6.setFont(new java.awt.Font("Space Mono", 0, 18)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(51, 153, 255));
        jLabel6.setText("CONTACT");

        jLabel7.setFont(new java.awt.Font("Space Mono", 0, 11)); // NOI18N
        jLabel7.setText("Gmail: 20200184@eaut.edu.vn");

        jLabel9.setFont(new java.awt.Font("Space Mono", 0, 11)); // NOI18N
        jLabel9.setText("Facebook:  Đào Việt Bảo");

        jLabel10.setFont(new java.awt.Font("Space Mono", 0, 11)); // NOI18N
        jLabel10.setText("Phone Number:  123456789987");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 363, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(259, 259, 259))
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(98, 98, 98)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 184, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(101, 101, 101)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(394, 394, 394)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 205, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel9)
                            .addComponent(jLabel7)))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(442, 442, 442)
                        .addComponent(jLabel6)))
                .addContainerGap(97, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel8)
                .addGap(61, 61, 61)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jPanel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(25, 25, 25)
                        .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addGap(43, 43, 43)
                .addComponent(jLabel6)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel9)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel7)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel10)
                .addGap(91, 91, 91))
        );

        jTabbedPane1.addTab("Admin", jPanel2);

        jPanel15.addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentShown(java.awt.event.ComponentEvent evt) {
                jPanel15ComponentShown(evt);
            }
        });

        jLabel17.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jLabel17.setText("Kệ A1");

        tabA1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Mã sách", "Tên sách", "Giá sách"
            }
        ));
        tabA1.addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentShown(java.awt.event.ComponentEvent evt) {
                tabA1ComponentShown(evt);
            }
        });
        jScrollPane5.setViewportView(tabA1);

        tabA3.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Mã sách", "Tên sách", "Giá sách"
            }
        ));
        jScrollPane6.setViewportView(tabA3);

        tabA4.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Mã sách", "Tên sách", "Giá sách"
            }
        ));
        jScrollPane7.setViewportView(tabA4);

        tabA2.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Mã sách", "Tên sách", "Giá sách"
            }
        ));
        tabA2.addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentShown(java.awt.event.ComponentEvent evt) {
                tabA2ComponentShown(evt);
            }
        });
        jScrollPane8.setViewportView(tabA2);

        jLabel19.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jLabel19.setText("Kệ A2");

        jLabel20.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jLabel20.setText("Kệ A3");

        jLabel21.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jLabel21.setText("Kệ A4");

        javax.swing.GroupLayout jPanel15Layout = new javax.swing.GroupLayout(jPanel15);
        jPanel15.setLayout(jPanel15Layout);
        jPanel15Layout.setHorizontalGroup(
            jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel15Layout.createSequentialGroup()
                .addGap(204, 204, 204)
                .addComponent(jLabel20)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel21)
                .addGap(246, 246, 246))
            .addGroup(jPanel15Layout.createSequentialGroup()
                .addGap(31, 31, 31)
                .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 369, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane6, javax.swing.GroupLayout.PREFERRED_SIZE, 367, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(85, 85, 85)
                .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane8, javax.swing.GroupLayout.PREFERRED_SIZE, 393, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane7, javax.swing.GroupLayout.PREFERRED_SIZE, 392, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(85, Short.MAX_VALUE))
            .addGroup(jPanel15Layout.createSequentialGroup()
                .addGap(169, 169, 169)
                .addComponent(jLabel17)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel19)
                .addGap(241, 241, 241))
        );
        jPanel15Layout.setVerticalGroup(
            jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel15Layout.createSequentialGroup()
                .addGap(38, 38, 38)
                .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel17)
                    .addComponent(jLabel19))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane8, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(53, 53, 53)
                .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel15Layout.createSequentialGroup()
                        .addComponent(jLabel20)
                        .addGap(18, 18, 18)
                        .addComponent(jScrollPane6, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel15Layout.createSequentialGroup()
                        .addComponent(jLabel21)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jScrollPane7, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(7, 7, 7)))
                .addContainerGap(21, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Vị trí ", jPanel15);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 20, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane1, javax.swing.GroupLayout.Alignment.TRAILING)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
    
    private void btnXoaBDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnXoaBDActionPerformed
        int select = tabBanDoc.getSelectedRow();
        if (select >= 0){
            Ban_Doc bd = BDTV.get(select);
            int xoa = JOptionPane.showConfirmDialog(this, "Bạn có muốn xóa?");
            System.out.println(":" + xoa);
            if (xoa == 0) {
                Them_Xoa_Sua_Ban_Doc.deleteBD(bd.getMaBD());
                JOptionPane.showMessageDialog(this, "Xóa thành công");
                showBD();
            }
        }
    }//GEN-LAST:event_btnXoaBDActionPerformed

    private void btnThoatBDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThoatBDActionPerformed
        menu.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnThoatBDActionPerformed

    private void btnSuaBDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSuaBDActionPerformed
      int update = JOptionPane.showConfirmDialog(this, "Bạn có muốn sửa không?", "Thông báo", JOptionPane.YES_OPTION);
        if(update != JOptionPane.YES_OPTION){
            return;
        }
        String maBD = txtMaBD.getText();
        String tenBD = txtTenBD.getText();
        String SDT = txtSDT.getText();
        String diaChi = txtDiaChi.getText();
        String gioiTinh = txtGioiTinh.getText();
        String sachMuon = txtSachMuon.getText();
        Ban_Doc banDoc = new Ban_Doc(maBD,tenBD,SDT,diaChi,gioiTinh,sachMuon);
        Them_Xoa_Sua_Ban_Doc.updateBD(banDoc);
        JOptionPane.showMessageDialog(this, "Sửa thành công");
        showBD();
    }//GEN-LAST:event_btnSuaBDActionPerformed

    private void btnThemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThemActionPerformed
       int ch = JOptionPane.showConfirmDialog(this, "Bạn có muốn thêm không?", "Xác nhận",JOptionPane.YES_NO_OPTION);
       if (ch != JOptionPane.YES_OPTION){
           return;
       }
       String maSach = txtMaSach.getText();
       String tenSach = txtTenSach.getText();
       int giaSach = Integer.parseInt(txtGiaSach.getText());
       String keSo = txtKeSo.getText();
       String theLoai = txtTheLoai.getText();
       String nhaXB = txtNhaXuatBan.getText();
       int namXB = Integer.parseInt(txtNamXuatBan.getText());
       Sach_Thu_Vien themSach = new Sach_Thu_Vien(maSach, tenSach, giaSach, keSo, theLoai, nhaXB,namXB);
       Them_Xoa_Sua_Sach.insert(themSach);
       showSachTV();
    }//GEN-LAST:event_btnThemActionPerformed

    private void txtTheLoaiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtTheLoaiActionPerformed
        // TODO add your handling code here:
                
    }//GEN-LAST:event_txtTheLoaiActionPerformed

    private void hienThi(java.awt.event.ComponentEvent evt) {//GEN-FIRST:event_hienThi

    }//GEN-LAST:event_hienThi

    private void hienThiSach(java.awt.event.ComponentEvent evt) {//GEN-FIRST:event_hienThiSach

    }//GEN-LAST:event_hienThiSach

    private void btnThemBDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThemBDActionPerformed
        int th = JOptionPane.showConfirmDialog(this, "Bạn có muốn thêm không?", "Thông báo", JOptionPane.YES_OPTION);
        if(th != JOptionPane.YES_OPTION){
            return;
        }
        String maBD = txtMaBD.getText();
        String tenBD = txtTenBD.getText();
        String SDT = txtSDT.getText();
        String diaChi = txtDiaChi.getText();
        String gioiTinh = txtGioiTinh.getText();
        String sachMuon = txtSachMuon.getText();
        Ban_Doc banDoc = new Ban_Doc(maBD,tenBD,SDT,diaChi,gioiTinh,sachMuon);
        Them_Xoa_Sua_Ban_Doc.insertBD(banDoc);
        JOptionPane.showMessageDialog(this, "Thêm thành công");
        showBD();
    }//GEN-LAST:event_btnThemBDActionPerformed

    private void btnXoaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnXoaActionPerformed
        int select = tabBook.getSelectedRow();
        if (select > 0){
            Sach_Thu_Vien stv = STV.get(select);
            int xoa = JOptionPane.showConfirmDialog(this, "Bạn có muốn xóa không?");
            System.out.println(":"+ xoa);
            if(xoa == 0){
                Them_Xoa_Sua_Sach.deleteSach(stv.getMaSach());
                JOptionPane.showMessageDialog(this, "Xóa thành công");
            }
        }
    }//GEN-LAST:event_btnXoaActionPerformed

    private void btnSuaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSuaActionPerformed
        int update = JOptionPane.showConfirmDialog(this, "Bạn có muốn sửa không?", "Thông báo", JOptionPane.YES_OPTION);
        if (update != JOptionPane.YES_OPTION){
            return;
        }
        String maSach = txtMaSach.getText();
        String tenSach = txtTenSach.getText();
        int giaSach = Integer.parseInt(txtGiaSach.getText());
        String keSach = txtKeSo.getText();
        String theLoai = txtTheLoai.getText();
        String nhaXB = txtNhaXuatBan.getText();
        int namXB = Integer.parseInt(txtNamXuatBan.getText());
        Sach_Thu_Vien suaSach = new Sach_Thu_Vien(maSach, tenSach, giaSach, keSach, theLoai, nhaXB, namXB);
        Them_Xoa_Sua_Sach.update(suaSach);
        JOptionPane.showMessageDialog(this, "Sửa thành công!");
        tableSach.setRowCount(0);
        showSachTV();
    }//GEN-LAST:event_btnSuaActionPerformed

    private void btnThoatActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThoatActionPerformed
        menu.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnThoatActionPerformed

    private void btnNhapMoiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNhapMoiActionPerformed
        txtMaSach.setText("");
        txtTenSach.setText("");
        txtGiaSach.setText("");
        txtKeSo.setText("");
        txtTheLoai.setText("");
        txtNhaXuatBan.setText("");
        txtNamXuatBan.setText("");
    }//GEN-LAST:event_btnNhapMoiActionPerformed

    private void btnTraCuuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTraCuuActionPerformed
        String Search = txtTraCuu.getText();
        if (Search.length() > 0) {//độ dài>0 mới thực hiện
            BDTV = Them_Xoa_Sua_Ban_Doc.timKiemBD(Search);
            tableBD.setRowCount(0);
            for (Ban_Doc bd : BDTV) {
                tableBD.addRow(new Object[]{bd.getMaBD(),bd.getTenBD(),bd.getSDT(),bd.getDiaChiBD(),bd.getGioiTinh(),bd.getSachMuon()});

            }
        }
    }//GEN-LAST:event_btnTraCuuActionPerformed

    private void btnTraCuuSActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTraCuuSActionPerformed
       String Search = txtTraCuuS.getText();
        if (Search.length() > 0) {//độ dài>0 mới thực hiện
           STV = Them_Xoa_Sua_Sach.timKiemSach(Search);
            tableSach.setRowCount(0);
            for (Sach_Thu_Vien stv : STV) {
                tableSach.addRow(new Object[]{stv.getMaSach(),stv.getTenSach(),stv.getGiaSach(),stv.getKeSo(),stv.getTheLoai(),stv.getNhaXuatBan(),stv.getNamXuatBan()});
            }
        }
    }//GEN-LAST:event_btnTraCuuSActionPerformed

    private void tabA1ComponentShown(java.awt.event.ComponentEvent evt) {//GEN-FIRST:event_tabA1ComponentShown

    }//GEN-LAST:event_tabA1ComponentShown

    private void jPanel15ComponentShown(java.awt.event.ComponentEvent evt) {//GEN-FIRST:event_jPanel15ComponentShown
        showSachA1();
        showSachA2();
        showSachA3();
        showSachA4();
    }//GEN-LAST:event_jPanel15ComponentShown

    private void tabA2ComponentShown(java.awt.event.ComponentEvent evt) {//GEN-FIRST:event_tabA2ComponentShown
     
    }//GEN-LAST:event_tabA2ComponentShown

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Quan_Ly_Sach_Thu_Vien.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Quan_Ly_Sach_Thu_Vien.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Quan_Ly_Sach_Thu_Vien.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Quan_Ly_Sach_Thu_Vien.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Quan_Ly_Sach_Thu_Vien().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel book__idText2;
    private javax.swing.JLabel book__namXuatBan2;
    private javax.swing.JLabel book__nameText2;
    private javax.swing.JLabel book__nhaXuatBan2;
    private javax.swing.JLabel book__priceText2;
    private javax.swing.JLabel book__shelfText2;
    private javax.swing.JLabel book__title;
    private javax.swing.JLabel book_categoryText2;
    private javax.swing.JButton btnNhapMoi;
    private javax.swing.JButton btnSua;
    private javax.swing.JButton btnSuaBD;
    private javax.swing.JButton btnThem;
    private javax.swing.JButton btnThemBD;
    private javax.swing.JButton btnThoat;
    private javax.swing.JButton btnThoatBD;
    private javax.swing.JToggleButton btnTraCuu;
    private javax.swing.JToggleButton btnTraCuuS;
    private javax.swing.JButton btnXoa;
    private javax.swing.JButton btnXoaBD;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel12;
    private javax.swing.JPanel jPanel13;
    private javax.swing.JPanel jPanel14;
    private javax.swing.JPanel jPanel15;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JScrollPane jScrollPane7;
    private javax.swing.JScrollPane jScrollPane8;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JLabel leader;
    private javax.swing.JLabel member1;
    private javax.swing.JLabel member2;
    private javax.swing.JPanel reader__function_panel;
    private javax.swing.JPanel reader__panel1;
    private javax.swing.JLabel reader__title;
    private javax.swing.JLabel reader_addressText1;
    private javax.swing.JLabel reader_genderText1;
    private javax.swing.JLabel reader_idText1;
    private javax.swing.JLabel reader_nameText1;
    private javax.swing.JLabel reader_phoneText1;
    private javax.swing.JLabel reader_sachmuonBox1;
    private javax.swing.JTable tabA1;
    private javax.swing.JTable tabA2;
    private javax.swing.JTable tabA3;
    private javax.swing.JTable tabA4;
    private javax.swing.JTable tabBanDoc;
    private javax.swing.JTable tabBook;
    private javax.swing.JTextField txtDiaChi;
    private javax.swing.JTextField txtGiaSach;
    private javax.swing.JTextField txtGioiTinh;
    private javax.swing.JTextField txtKeSo;
    private javax.swing.JTextField txtMaBD;
    private javax.swing.JTextField txtMaSach;
    private javax.swing.JTextField txtNamXuatBan;
    private javax.swing.JTextField txtNhaXuatBan;
    private javax.swing.JTextField txtSDT;
    private javax.swing.JTextField txtSachMuon;
    private javax.swing.JTextField txtTenBD;
    private javax.swing.JTextField txtTenSach;
    private javax.swing.JTextField txtTheLoai;
    private javax.swing.JTextField txtTraCuu;
    private javax.swing.JTextField txtTraCuuS;
    // End of variables declaration//GEN-END:variables
}
