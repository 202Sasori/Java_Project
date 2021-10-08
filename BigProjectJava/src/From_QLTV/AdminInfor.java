/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package From_QLTV;

/**
 *
 * @author daovi
 */
public class AdminInfor {
    private String adminName;
    private String adminPassword;

    public AdminInfor(String adminName, String adminPassword) {
        this.adminName = adminName;
        this.adminPassword = adminPassword;
    }
    //Method
    public void setName(String adminName) {
        this.adminName = adminName;
    }
    
    public String getName() {
        return adminName;
    }
    
    public void setPassword(String adminPassword) {
        this.adminPassword = adminPassword;
    }
    
    public String getPassword() {
        return adminPassword;
    }
}
