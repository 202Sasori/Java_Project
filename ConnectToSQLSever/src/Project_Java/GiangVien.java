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
public class GiangVien extends BanDoc{
    private String chucVu;
    private String monGD;

    public GiangVien(String maBD, String hoTen, String SDT, String sachMuon, String chucVu, String monGD) {
        super(maBD, hoTen, SDT, sachMuon);
        this.chucVu = chucVu;
        this.monGD = monGD;
    }
    public String getChucVu() {
        return chucVu;
    }

    public void setChucVu(String chucVu) {
        this.chucVu = chucVu;
    }

    public String getMonGD() {
        return monGD;
    }

    public void setMonGD(String monGD) {
        this.monGD = monGD;
    }
    
}
