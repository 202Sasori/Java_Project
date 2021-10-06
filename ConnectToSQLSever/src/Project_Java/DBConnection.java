/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Project_Java;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author FPT
 */
public class DBConnection {
    public static  Connection  getConnection(){
         Connection connection = null;
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            String url = "jdbc:sqlserver://localhost:1433; databaseName=QLTV";
            String user = "sa";
            String password = "123456@Ab";
            connection = DriverManager.getConnection(url,user,password);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return connection;
    }
    public static void closeConnection(Connection conn){
        if(conn != null){
            try {
                conn.close();
            } catch (SQLException ex) {
               ex.printStackTrace();
            }
        }
    }
     public static void main(String[] arg){
        System.err.println(getConnection());
    }
}
