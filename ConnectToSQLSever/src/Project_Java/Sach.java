/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Project_Java;

/**
 *
 * @author FPT
 */
public class Sach {
    private String maS;
    private String tenSach;
    private String theLoai;
    private String nhaXB;
    
    public Sach(String maS, String tenSach, String theLoai, String nhaXB){
        this.maS = maS;
        this.tenSach= tenSach;
        this.theLoai = theLoai;
        this.nhaXB = nhaXB;
    }
    public String getMaS() {
        return maS;
    }

    public void setMaS(String maS) {
        this.maS = maS;
    }

    public String getTenSach() {
        return tenSach;
    }

    public void setTenSach(String tenSach) {
        this.tenSach = tenSach;
    }

    public String getTheLoai() {
        return theLoai;
    }

    public void setTheLoai(String theLoai) {
        this.theLoai = theLoai;
    }

    public String getNhaXB() {
        return nhaXB;
    }

    public void setNhaXB(String nhaXB) {
        this.nhaXB = nhaXB;
    }
    
    
}
