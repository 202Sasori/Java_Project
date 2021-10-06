/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package demo;


import java.sql.Connection;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author FPT
 */
public class DBConnection {

   public static Connection getConnection(){
       Connection connection = null;
       try {
           Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
           String url ="jdbc:sqlserver://localhost:1433; databaseName=DB_01_TEST";
           String user = "sa";
           String pass = "123456@Ab";
           connection = DriverManager.getConnection(url,user,pass);
       } catch (Exception ex) {
          ex.printStackTrace();
       }
       return connection;
   }
   
   public static void closeConnection(Connection con){
       if(con != null){
           try{
               con.close();
           } catch (SQLException ex){
               ex.printStackTrace();
           }
       }
   }    
  
}

