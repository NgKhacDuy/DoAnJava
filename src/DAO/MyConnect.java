/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.SQLException;
/**
 *
 * @author DELL
 */
public class MyConnect {
    public static Connection conn=null ;
    private String url="jdbc:mysql://localhost:3306/doan";
    private String user="root";
    private String password="";

    public MyConnect() throws SQLException{
        try {
           Class.forName("com.mysql.cj.jdbc.Driver");           
           conn=DriverManager.getConnection(url,user,password);
        } catch (Exception e) {
        }
    }
    public Connection getCon(){
        return conn;
    }
    
}
