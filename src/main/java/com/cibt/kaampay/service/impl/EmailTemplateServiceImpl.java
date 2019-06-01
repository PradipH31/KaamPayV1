/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cibt.kaampay.service.impl;

import com.cibt.kaampay.entity.EmailTemplate;
import com.cibt.kaampay.repository.EmailTemplateRepository;
import com.cibt.kaampay.repository.impl.EmailTemplateRepositoryImpl;
import com.cibt.kaampay.service.EmailTemplateService;
import java.util.List;

/**
 *
 * @author HP B&O
 */
public class EmailTemplateServiceImpl implements EmailTemplateService {

    private EmailTemplateRepository templateRepository = new EmailTemplateRepositoryImpl();

    @Override
    public void save(EmailTemplate model) throws Exception {
        if (model.getId() == 0) {
            templateRepository.insert(model);
        }else{
            templateRepository.update(model);
        }
    }

    @Override
    public List<EmailTemplate> findAll() throws Exception {
        return templateRepository.findAll();
    }

    @Override
    public EmailTemplate findById(int id) throws Exception {
        return templateRepository.findById(id);
    }

}
