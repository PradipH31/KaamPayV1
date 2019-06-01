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
import java.util.Properties;
import javax.mail.Message;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author HP B&O
 */
@WebServlet(urlPatterns = "/register/*")
public class RegisterServlet extends HttpServlet {
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("WEB-INF/views/register.jsp")
                .forward(request, response);
    }
    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        if (request.getMethod().equalsIgnoreCase("post")) {
            UserService userService = new UserServiceImpl();
            User user = new User();
            user.setEmail(request.getParameter("email"));
            user.setPassword(request.getParameter("password"));
            user.setStatus(false);
            try {
                userService.save(user);
                sendEmail(user.getEmail());
            } catch (Exception ex) {
                System.out.println(ex.getMessage());
            }
            response.sendRedirect(request.getContextPath() + "/login");
        }
    }
    
    private void sendEmail(String email) {
        String url = "http://localhost:8080/kaampayv1/verifyemail?email=" + email;
        String host = "smtp.wlink.com.np";
        String port = "25";
        String from = "enquire@creators.institute";
        String to = email;
        String subject = "CIBT:You have successfully registered email";
        String body = "Dear sir/madam<br>Please verify your email address:"
                + "<a href=\"" + url + "\"Verify";
        Properties properties = System.getProperties();
        properties.setProperty("mail.smtp.host", host);
        properties.setProperty("mail.smtp.port", port);
        try {
            Session session = Session.getDefaultInstance(properties);
            MimeMessage message = new MimeMessage(session);
            message.setFrom(new InternetAddress(from));
            message.setSubject(subject);
            message.addRecipient(Message.RecipientType.TO, new InternetAddress(to));
            message.setContent(body, "text/html");
            Transport.send(message);
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
        
    }
    
}
