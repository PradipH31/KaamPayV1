/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cibt.kaampay.repository.impl;

import com.cibt.kaampay.core.JDBCTemplate;
import com.cibt.kaampay.core.RowMapper;
import com.cibt.kaampay.entity.EmailTemplate;
import com.cibt.kaampay.repository.EmailTemplateRepository;
import java.sql.ResultSet;
import java.util.Date;
import java.util.List;

/**
 *
 * @author HP B&O
 */
public class EmailTemplateRepositoryImpl implements EmailTemplateRepository {

    private JDBCTemplate<EmailTemplate> template = new JDBCTemplate<>();

    @Override
    public void insert(EmailTemplate model) throws Exception {
        String sql = "insert into tbl_email_templates(email_title,slug_name,subject,"
                + "body,created_by) values(?,?,?,?,?)";
        template.update(sql, new Object[]{
            model.getTitle(), model.getSlug(), model.getSubject(), model.getBody(), model.getCreatedBy()
        });
    }

    @Override
    public void update(EmailTemplate model) throws Exception {
        String sql = "update tbl_email_templates set email_title=?,slug_name=?,subject=?,"
                + "body=?,modified_date=CURRENT_TIMESTAMP,modified_by=? where id=?";
        template.update(sql, new Object[]{
            model.getTitle(), model.getSlug(), model.getSubject(),
            model.getBody(), model.getModifiedBy(),model.getId()
        });
    }

    @Override
    public List<EmailTemplate> findAll() throws Exception {
        String sql = "select * from vw_email_templates";
        return template.query(sql, new RowMapper<EmailTemplate>() {
            @Override
            public EmailTemplate mapRow(ResultSet rs) throws Exception {
                EmailTemplate template = new EmailTemplate();
                template.setId(rs.getInt("id"));
                template.setTitle(rs.getString("email_title"));
                template.setSlug(rs.getString("slug_name"));
                template.setSubject(rs.getString("subject"));
                template.setBody(rs.getString("body"));
                template.setCreatedBy(rs.getInt("created_by"));
                template.setCreatedDate(new Date(rs.getDate("created_date").getTime()));
                template.setStatus(rs.getBoolean("status"));
                return template;
            }
        });
    }

    @Override
    public EmailTemplate findById(int id) throws Exception {
        String sql = "select * from vw_email_templates where id=?";
        return template.queryForObject(sql, new Object[id], new RowMapper<EmailTemplate>() {
            @Override
            public EmailTemplate mapRow(ResultSet rs) throws Exception {
                EmailTemplate template = new EmailTemplate();
                template.setId(rs.getInt("id"));
                template.setTitle(rs.getString("email_title"));
                template.setSlug(rs.getString("slug_name"));
                template.setSubject(rs.getString("subject"));
                template.setBody(rs.getString("body"));
                template.setCreatedBy(rs.getInt("created_by"));
                template.setCreatedDate(new Date(rs.getDate("created_date").getTime()));
                template.setStatus(rs.getBoolean("status"));
                return template;
            }
        });
    }

}
