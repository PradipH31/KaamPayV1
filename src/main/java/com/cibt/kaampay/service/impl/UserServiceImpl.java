/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cibt.kaampay.service.impl;

import com.cibt.kaampay.entity.User;
import com.cibt.kaampay.entity.UserLog;
import com.cibt.kaampay.repository.UserLogRepository;
import com.cibt.kaampay.repository.UserRepositoy;
import com.cibt.kaampay.repository.impl.UserLogRepositoryImpl;
import com.cibt.kaampay.repository.impl.UserRepositoryImpl;
import com.cibt.kaampay.service.UserService;
import java.util.List;
import java.util.Properties;
import javax.mail.Message;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

/**
 *
 * @author HP B&O
 */
public class UserServiceImpl implements UserService {

    private UserRepositoy userRepositoy = new UserRepositoryImpl();
    private UserLogRepository userLogRepository = new UserLogRepositoryImpl();

    @Override
    public void save(User user) throws Exception {
        if (user.getId() == 0) {
            userRepositoy.insert(user);
            sendEmail(user.getEmail());
        } else {
            userRepositoy.update(user);
        }
    }

    @Override
    public List<User> findAll() throws Exception {
        return userRepositoy.findAll();
    }

    @Override
    public User findById(int id) throws Exception {
        return userRepositoy.findById(id);
    }

    @Override
    public User login(String email, String password) throws Exception {
        User user = userRepositoy.login(email, password);
        if (user != null) {
            userLogRepository.insert(new UserLog(0, user));
        }
        return user;
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

    @Override
    public boolean verify(String email) throws Exception {
        User user = userRepositoy.findByEmail(email);
        if (user != null) {
            userRepositoy.changeStatus(user.getId(), true);
            return true;
        }
        return false;
    }

}
