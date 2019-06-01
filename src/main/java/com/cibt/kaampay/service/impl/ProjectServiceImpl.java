/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cibt.kaampay.service.impl;

import com.cibt.kaampay.entity.Project;
import com.cibt.kaampay.repository.ProjectRepository;
import com.cibt.kaampay.service.ProjectService;
import java.util.List;

/**
 *
 * @author HP B&O
 */
public class ProjectServiceImpl implements ProjectService {

    private ProjectRepository projectRepository;

    public ProjectServiceImpl(ProjectRepository projectRepository) {
        this.projectRepository = projectRepository;
    }

    @Override
    public void save(Project model) throws Exception {
        if(model.getId()==0){
            projectRepository.insert(model);
        }else{
            projectRepository.update(model);
        }
    }

    @Override
    public List<Project> findAll() throws Exception {
        return projectRepository.findAll();
    }

    @Override
    public Project findById(int id) throws Exception {
        return projectRepository.findById(id);
    }

}
