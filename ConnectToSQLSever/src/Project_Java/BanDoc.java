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
public class BanDoc {
    private String maBD;
    private String hoTen;
    private String SDT;
    private String sachMuon;

    public BanDoc(String maBD, String hoTen, String SDT, String sachMuon) {
        this.maBD = maBD;
        this.hoTen = hoTen;
        this.SDT = SDT;
        this.sachMuon = sachMuon;
    }
    public String getMaBD() {
        return maBD;
    }

    public void setMaBD(String maBD) {
        this.maBD = maBD;
    }

    public String getHoTen() {
        return hoTen;
    }

    public void setHoTen(String hoTen) {
        this.hoTen = hoTen;
    }

    public String getSDT() {
        return SDT;
    }

    public void setSDT(String SDT) {
        this.SDT = SDT;
    }

    public String getSachMuon() {
        return sachMuon;
    }

    public void setSachMuon(String sachMuon) {
        this.sachMuon = sachMuon;
    }
    
    
}
