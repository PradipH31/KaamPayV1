/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cibt.kaampay.configuration;

import com.cibt.kaampay.helper.MailHelper;

/**
 *
 * @author HP B&O
 */
public class AppConfiguration {

    public static MailHelper getMailHelper() {
        String host = "smtp.wlink.com.np";
        String port = "25";
        String from = "enquire@creators.institute";
        return new MailHelper().setHost(host).setPort(port).setFrom(from);
    }
}
