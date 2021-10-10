/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Sach;

/**
 *
 * @author FPT
 */
public class Sach_Thu_Vien {
    private String maSach;
    private String tenSach;
    private int giaSach;
    private String keSo;
    private String theLoai;
    private String nhaXuatBan;
    private int namXuatBan;
    //Constructor
    public Sach_Thu_Vien() {
    }

    public Sach_Thu_Vien(String maSach, String tenSach, int giaSach, String keSo, String theLoai, String nhaXuatBan, int namXuatBan) {
        this.maSach = maSach;
        this.tenSach = tenSach;
        this.giaSach = giaSach;
        this.keSo = keSo;
        this.theLoai = theLoai;
        this.nhaXuatBan = nhaXuatBan;
        this.namXuatBan = namXuatBan;
    }
    //Getter & Setter
    public String getMaSach() {
        return maSach;
    }

    public void setMaSach(String maSach) {
        this.maSach = maSach;
    }

    public String getTenSach() {
        return tenSach;
    }

    public void setTenSach(String tenSach) {
        this.tenSach = tenSach;
    }

    public int getGiaSach() {
        return giaSach;
    }

    public void setGiaSach(int giaSach) {
        this.giaSach = giaSach;
    }

    public String getKeSo() {
        return keSo;
    }

    public void setKeSo(String keSo) {
        this.keSo = keSo;
    }

    public String getTheLoai() {
        return theLoai;
    }

    public void setTheLoai(String theLoai) {
        this.theLoai = theLoai;
    }

    public String getNhaXuatBan() {
        return nhaXuatBan;
    }

    public void setNhaXuatBan(String nhaXuatBan) {
        this.nhaXuatBan = nhaXuatBan;
    }

    public int getNamXuatBan() {
        return namXuatBan;
    }

    public void setNamXuatBan(int namXuatBan) {
        this.namXuatBan = namXuatBan;
    }
    
    
}
