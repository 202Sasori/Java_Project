/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package connecttosqlsever;

import com.microsoft.sqlserver.jdbc.SQLServerDataSource;
import com.microsoft.sqlserver.jdbc.SQLServerException;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author FPT
 */
public class ConnectToSQLSever {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        var server = "MSI\\SQLEXPRESS";
        var user = "sa";
        var password ="123456@Ab";
        var db = "DB_01_TEST";
        var port = 1433;
        SQLServerDataSource ds = new SQLServerDataSource();
        ds.setUser(user);
        ds.setPassword(password);
        ds.setDatabaseName(db);
        ds.setPortNumber(port);
        try(Connection conn = ds.getConnection()){
            System.out.println("Ket noi thanh cong database");
            System.out.println(conn.getCatalog());
        } catch (SQLException ex) {
           ex.printStackTrace();
        }
        
    }
    
}
