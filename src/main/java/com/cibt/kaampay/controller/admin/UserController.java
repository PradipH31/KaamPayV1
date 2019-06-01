/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cibt.kaampay.controller.admin;

import com.cibt.kaampay.core.Controller;
import com.cibt.kaampay.service.UserService;
import com.cibt.kaampay.service.impl.UserServiceImpl;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author HP B&O
 */
@WebServlet(urlPatterns = "/admin/users/*")
public class UserController extends Controller {

    private UserService userService = new UserServiceImpl();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            request.setAttribute("users", userService.findAll());
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
        request.getRequestDispatcher("/WEB-INF/views/admin/users/index.jsp")
                .forward(request, response);
    }

}
