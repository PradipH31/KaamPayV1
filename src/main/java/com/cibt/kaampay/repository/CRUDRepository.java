/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cibt.kaampay.repository;

import java.util.List;

/**
 *
 * @author HP B&O
 */
public interface CRUDRepository<T> {
    void insert(T model) throws Exception;

    void update(T model) throws Exception;

    List<T> findAll() throws Exception;

    T findById(int id) throws Exception;
}
