/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cibt.kaampay.service;

import com.cibt.kaampay.entity.UserLog;
import java.util.List;

/**
 *
 * @author HP B&O
 */
public interface UserLogService extends GenericService<UserLog> {
    List<UserLog> findByUserId(int id) throws Exception;
}