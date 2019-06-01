/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this project file, choose Tools | Templates
 * and open the project in the editor.
 */
package com.cibt.kaampay.controller.admin;

import com.cibt.kaampay.core.Controller;
import com.cibt.kaampay.entity.Project;
import com.cibt.kaampay.entity.User;
import com.cibt.kaampay.repository.impl.ProjectRepositoryImpl;
import com.cibt.kaampay.service.ProjectService;
import com.cibt.kaampay.service.impl.ProjectServiceImpl;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author HP B&O
 */
@WebServlet(urlPatterns = "/admin/projects/*")
public class ProjectController extends Controller {

    private ProjectService projectService = new ProjectServiceImpl(new ProjectRepositoryImpl());

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
                    Project project = projectService.findById(id);
                    User user = (User) request.getSession().getAttribute("loggedin");
                    if (project.getCreatedBy().getId() == user.getId()) {
                        request.setAttribute("project", project);
                        page = "edit";
                    }else{
                        isRedirect=true;
                        response.sendRedirect(request.getContextPath() + "/admin/projects?error");
                    }
                } catch (NumberFormatException e) {
                    isRedirect = true;
                    response.sendRedirect(request.getContextPath() + "/admin/projects");
                }
            } else {
                request.setAttribute("projects", projectService.findAll());
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        if (!isRedirect) {
            request.getRequestDispatcher("WEB-INF/views/admin/projects/" + page + ".jsp")
                    .forward(request, response);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Project project = new Project();
        if (request.getParameter("id") != null) {
            project.setId(Integer.parseInt(request.getParameter("id")));
        }
//        project.setTitle(request.getParameter("title"));
//        project.setSlug(request.getParameter("slug"));
//        project.setSubject(request.getParameter("subject"));
//        project.setBody(request.getParameter("body"));
//        User user = (User) request.getSession().getAttribute("loggedin");
//        project.setCreatedBy(user.getId());
//        try {
//            projectService.save(project);
//            response.sendRedirect(request.getContextPath() + "/admin/projects");
//        } catch (Exception ex) {
//            System.out.println(ex.getMessage());
//        }
    }

}
