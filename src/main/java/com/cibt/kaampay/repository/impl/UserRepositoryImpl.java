/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cibt.kaampay.repository.impl;

import com.cibt.kaampay.entity.User;
import com.cibt.kaampay.repository.UserRepositoy;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

/**
 *
 * @author HP B&O
 */
public class UserRepositoryImpl implements UserRepositoy {

    @Override
    public void insert(User user) throws Exception{
        Class.forName("com.mysql.cj.jdbc.Driver");
        String url = "jdbc:mysql://localhost/kaamPay";
        String username = "root";
        String password = "";
        Connection conn = DriverManager.getConnection(url, username, password);
        String sql = "insert into tbl_users(email,password) values(?,?)";
        PreparedStatement stmt = conn.prepareStatement(sql);
        stmt.setString(1, user.getEmail());
        stmt.setString(2, user.getPassword());
        stmt.executeUpdate();
    }

    @Override
    public void update(User user) throws Exception{
        Class.forName("com.mysql.cj.jdbc.Driver");
        String url = "jdbc:mysql://localhost/kaamPay";
        String username = "root";
        String password = "";
        Connection conn = DriverManager.getConnection(url, username, password);
        String sql = "update table tbl_users set email=?,password=?"
                + ",modified_date=CURRENT_TIMESTAMP,status=? where id=?";
        PreparedStatement stmt = conn.prepareStatement(sql);
        stmt.setString(1, user.getEmail());
        stmt.setString(2, user.getPassword());
        stmt.setBoolean(3, user.isStatus());
        stmt.setInt(4, user.getId());
        stmt.executeUpdate();
    }

}
