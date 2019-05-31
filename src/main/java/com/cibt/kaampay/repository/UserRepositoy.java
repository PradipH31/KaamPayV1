/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cibt.kaampay.repository;

import com.cibt.kaampay.entity.User;
import java.util.List;

/**
 *
 * @author HP B&O
 */
public interface UserRepositoy {

    void insert(User user) throws Exception;

    void update(User user) throws Exception;

    List<User> findAll() throws Exception;

    User findById(int id) throws Exception;
}
