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
public class SinhVien extends BanDoc{
    private String lop;
    private String khoa;
    public SinhVien(String maBD, String hoTen, String SDT, String sachMuon, String lop, String khoa) {
        super(maBD, hoTen, SDT, sachMuon);
        this.lop = lop;
        this.khoa = khoa;
    }
    public String getLop() {
        return lop;
    }

    public void setLop(String lop) {
        this.lop = lop;
    }

    public String getKhoa() {
        return khoa;
    }

    public void setKhoa(String khoa) {
        this.khoa = khoa;
    }
    
}
