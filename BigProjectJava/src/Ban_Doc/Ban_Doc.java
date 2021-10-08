/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Ban_Doc;

/**
 *
 * @author daovi
 */
public class Ban_Doc {
    private String maBD;
    private String tenBD;
    private String SDT;
    private String diaChiBD;
    private String gioiTinh;
    private String sachMuon;
    //Constructor
    public Ban_Doc() {
    }

    public Ban_Doc(String maBD, String tenBD, String SDT, String diaChiBD, String gioiTinh, String sachMuon) {
        this.maBD = maBD;
        this.tenBD = tenBD;
        this.SDT = SDT;
        this.diaChiBD = diaChiBD;
        this.gioiTinh = gioiTinh;
        this.sachMuon = sachMuon;
    }

    public String getMaBD() {
        return maBD;
    }

    public void setMaBD(String maBD) {
        this.maBD = maBD;
    }

    public String getTenBD() {
        return tenBD;
    }

    public void setTenBD(String tenBD) {
        this.tenBD = tenBD;
    }

    public String getSDT() {
        return SDT;
    }

    public void setSDT(String SDT) {
        this.SDT = SDT;
    }

    public String getDiaChiBD() {
        return diaChiBD;
    }

    public void setDiaChiBD(String diaChiBD) {
        this.diaChiBD = diaChiBD;
    }

    public String getGioiTinh() {
        return gioiTinh;
    }

    public void setGioiTinh(String gioiTinh) {
        this.gioiTinh = gioiTinh;
    }

    public String getSachMuon() {
        return sachMuon;
    }

    public void setSachMuon(String sachMuon) {
        this.sachMuon = sachMuon;
    }

   
    
}
