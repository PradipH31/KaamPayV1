/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cibt.kaampay;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 *
 * @author HP B&O
 */
public class App {

    public static void main(String[] args) {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            String url="jdbc:mysql://localhost/kaamPay";
            String user="root";
            String password="";
            Connection conn=DriverManager.getConnection(url, user, password);
            String sql="insert into tbl_users(email,password) values(?,?)";
            PreparedStatement stmt=conn.prepareStatement(sql);
            stmt.setString(1, "abc@gmail.com");
            stmt.setString(2, "852903");
            stmt.executeUpdate();
        } catch (ClassNotFoundException | SQLException e) {
            System.out.println(e.getMessage());
        }
    }
}
