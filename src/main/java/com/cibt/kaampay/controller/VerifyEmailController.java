/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cibt.kaampay.controller;

import com.cibt.kaampay.service.UserService;
import com.cibt.kaampay.service.impl.UserServiceImpl;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author HP B&O
 */
@WebServlet(urlPatterns = "/verifyemail/*")
public class VerifyEmailController extends HttpServlet {
    
    UserService userService = new UserServiceImpl();
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            String page = "";
            if (userService.verify(request.getParameter("email"))) {
                page = "/login";
            } else {
                page = "/login?error";
            }
            response.sendRedirect(request.getContextPath() + page);
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
        
    }
    
}
