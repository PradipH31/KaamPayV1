/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cibt.kaampay.controller.admin;

import com.cibt.kaampay.core.Controller;
import com.cibt.kaampay.entity.EmailTemplate;
import com.cibt.kaampay.entity.User;
import com.cibt.kaampay.service.EmailTemplateService;
import com.cibt.kaampay.service.impl.EmailTemplateServiceImpl;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author HP B&O
 */
@WebServlet(urlPatterns = "/admin/emailtemplates/*")
public class EmailTemplateController extends Controller {

    private EmailTemplateService emailTemplateService = new EmailTemplateServiceImpl();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String page = "index";
        boolean isRedirect = false;
        try {
            if (request.getRequestURI().contains("/add")) {
                page = "add";
            } else if (request.getRequestURI().contains("/edit")) {
                String[] tokens = request.getRequestURI().split("/");
                try {
                    int id = Integer.parseInt(tokens[tokens.length - 1]);
                    request.setAttribute("template", emailTemplateService.findById(id));
                    page = "edit";
                } catch (NumberFormatException e) {
                    isRedirect = true;
                    response.sendRedirect(request.getContextPath() + "/admin/emailtemplates");
                }
            } else {
                request.setAttribute("templates", emailTemplateService.findAll());
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        if (!isRedirect) {
            request.getRequestDispatcher("WEB-INF/views/admin/emailtemplates/" + page + ".jsp")
                    .forward(request, response);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        EmailTemplate template = new EmailTemplate();
        if(request.getParameter("id")!=null){
            template.setId(Integer.parseInt(request.getParameter("id")));
        }
        template.setTitle(request.getParameter("title"));
        template.setSlug(request.getParameter("slug"));
        template.setSubject(request.getParameter("subject"));
        template.setBody(request.getParameter("body"));
        User user = (User) request.getSession().getAttribute("loggedin");
        template.setCreatedBy(user.getId());
        try {
            emailTemplateService.save(template);
            response.sendRedirect(request.getContextPath() + "/admin/emailtemplates");
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }

}
