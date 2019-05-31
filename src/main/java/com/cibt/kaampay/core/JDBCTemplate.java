/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cibt.kaampay.core;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

/**
 *
 * @author HP B&O
 */
public class JDBCTemplate<T> {

    public int update(String sql, Object[] params) throws Exception {
        Class.forName("com.mysql.cj.jdbc.Driver");
        String url = "jdbc:mysql://localhost/kaamPay";
        String username = "root";
        String password = "";
        Connection conn = DriverManager.getConnection(url, username, password);
        PreparedStatement stmt = conn.prepareStatement(sql);
        int counter = 1;
        for (Object param : params) {
            stmt.setObject(counter, param);
            counter++;
        }
        return stmt.executeUpdate();
    }
}
