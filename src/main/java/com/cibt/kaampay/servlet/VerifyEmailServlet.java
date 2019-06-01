/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cibt.kaampay.servlet;

import com.cibt.kaampay.entity.User;
import com.cibt.kaampay.service.UserService;
import com.cibt.kaampay.service.impl.UserServiceImpl;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author HP B&O
 */
@WebServlet(urlPatterns = "/verifyemail/*")
public class VerifyEmailServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        
        request.getRequestDispatcher("/WEB-INF/views/login.jsp")
                .forward(request, response);
    }

}
