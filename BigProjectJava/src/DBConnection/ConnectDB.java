/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DBConnection;

import java.sql.*;
import java.sql.DriverManager;

/**
 *
 * @author FPT
 */
public class ConnectDB {
    public static Connection getConnection(){
        Connection connection = null;
        try {
           Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
           String url ="jdbc:sqlserver://localhost:1433; databaseName=QLTV";
           String user = "sa";
           String pass = "123456@Ab";
           connection = DriverManager.getConnection(url,user,pass);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return connection;
    }
     public static void closeConnection(java.sql.Connection con){
       if(con != null){
           try{
               con.close();
           } catch (SQLException ex){
               ex.printStackTrace();
           }
       }
   }
     public static void main(String[] args) {
         System.out.println("Error "+getConnection());
    }
}

