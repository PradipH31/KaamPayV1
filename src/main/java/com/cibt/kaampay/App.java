/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cibt.kaampay;

import com.cibt.kaampay.entity.User;
import com.cibt.kaampay.service.UserService;
import com.cibt.kaampay.service.impl.UserServiceImpl;

/**
 *
 * @author HP B&O
 */
public class App {

    public static void main(String[] args) {
        try {
            UserService userService=new UserServiceImpl();
            userService.login("abc@gmail.com", "589273598");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
