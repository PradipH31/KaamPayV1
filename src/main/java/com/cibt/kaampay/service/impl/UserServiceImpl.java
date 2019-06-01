/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cibt.kaampay.service.impl;

import com.cibt.kaampay.entity.User;
import com.cibt.kaampay.entity.UserLog;
import com.cibt.kaampay.helper.MailHelper;
import com.cibt.kaampay.repository.UserLogRepository;
import com.cibt.kaampay.repository.UserRepositoy;
import com.cibt.kaampay.repository.impl.UserLogRepositoryImpl;
import com.cibt.kaampay.repository.impl.UserRepositoryImpl;
import com.cibt.kaampay.service.UserService;
import java.util.List;

/**
 *
 * @author HP B&O
 */
public class UserServiceImpl implements UserService {

    private UserRepositoy userRepositoy = new UserRepositoryImpl();
    private UserLogRepository userLogRepository = new UserLogRepositoryImpl();
    private MailHelper mailer = new MailHelper();

    @Override
    public void save(User user) throws Exception {
        if (user.getId() == 0) {
            userRepositoy.insert(user);
            sendRegisterEmail(user.getEmail());
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

    private void sendRegisterEmail(String email) {
        String url = "http://localhost:8080/kaampayv1/verifyemail?email=" + email;
        String host = "smtp.wlink.com.np";
        String port = "25";
        String from = "enquire@creators.institute";
        String to = email;
        String subject = "CIBT:You have successfully registered email";
        String body = "Dear sir/madam<br>Please verify your email address:"
                + "<a href=\"" + url + "\"Verify";
        mailer.setHost(host).setBody(body).setFrom(from).setPort(port)
                .setSubject(subject).setTo(to).send();
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
