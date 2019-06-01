/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cibt.kaampay;

import com.cibt.kaampay.entity.User;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;

/**
 *
 * @author HP B&O
 */
public class App {

    public static void main(String[] args) {
        //getFields() for public fields,getDeclaredFields()
        Field[] fields = User.class.getDeclaredFields();
        for (Field f : fields) {
            System.out.println(f.getName());
            System.out.println(f.getType().getName());
        }
        Constructor<?>[] constructor = User.class.getConstructors();
        for (int i = 0; i < constructor.length; i++) {
            System.out.println(constructor[i].getName());
            Class<?>[] types = constructor[i].getParameterTypes();
            for (int j = 0; j < types.length; j++) {
                System.out.println(types[j].getName());
            }
        }
    }
}
