/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cibt.kaampay.service;

import com.cibt.kaampay.entity.User;
import java.util.List;

/**
 *
 * @author HP B&O
 */
public interface UserService {

    void save(User user) throws Exception;

    List<User> findAll() throws Exception;

    User findById(int id) throws Exception;
}
