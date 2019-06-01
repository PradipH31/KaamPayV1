/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cibt.kaampay.repository.impl;

import com.cibt.kaampay.core.JDBCTemplate;
import com.cibt.kaampay.entity.Project;
import com.cibt.kaampay.repository.ProjectRepository;
import java.util.List;

/**
 *
 * @author HP B&O
 */
public class ProjectRepositoryImpl implements ProjectRepository {

    private JDBCTemplate<Project> template = new JDBCTemplate<>();

    @Override
    public void insert(Project model) throws Exception {
        String sql = "insert into tbl_projects(project_name,project_description"
                + ",start_date,end_date,created_by,status) values(?,?,?,?,?,?)";
        template.update(sql, new Object[]{
            model.getName(), model.getDescription(), model.getStartDate(), model.getEndDate(),
             model.getCreatedBy().getId(), model.isStatus()
        });
    }

    @Override
    public void update(Project model) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Project> findAll() throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Project findById(int id) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
