/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cibt.kaampay.core;

import com.cibt.kaampay.controller.HomeController;
import java.io.IOException;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author HP B&O
 */
public class DispatcherServlet extends HttpServlet {

    Map<String, Controller> urlmapper = new HashMap<>();

    @Override
    public void init() throws ServletException {
        urlmapper.put("/", new HomeController());
    }

    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String url = request.getRequestURI();
        String path = url.replace(request.getContextPath(), "");
        if (path.equals("")) {
            path = "/";
        }
        try {
            Class<?> controller = urlmapper.get(path).getClass();
            Method method = controller.getMethod("index", null);
            method.invoke("index", null);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

}
