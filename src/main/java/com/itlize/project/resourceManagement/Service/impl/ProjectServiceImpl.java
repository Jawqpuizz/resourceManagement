package com.itlize.project.resourceManagement.Service.impl;

import com.itlize.project.resourceManagement.Entity.*;
import com.itlize.project.resourceManagement.Repository.ProjectRepository;
import com.itlize.project.resourceManagement.Repository.ProjectResourceRepository;
import com.itlize.project.resourceManagement.Repository.UserRepository;
import com.itlize.project.resourceManagement.Service.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import javax.persistence.criteria.CriteriaBuilder;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
@Service
public class ProjectServiceImpl implements ProjectService {

    @Autowired
    public ProjectRepository projectRepository;

    @Autowired
    public UserRepository userRepository;

    @Override
    public List<Project> findAll() {
        return projectRepository.findAll();
    }

    @Override
    public List<Project> findAllById(Integer id) {
        List<Project> newList = new ArrayList<>();
        List<Project> list = projectRepository.findAll();
        for (Project p: list) {
            if(p.getUser().getId()== id){
                newList.add(p);
            }
        }
        return newList;

    }

    @Override
    public Project createProject(ObjectRequest objectRequest) {
        Project project = new Project();
        project.setDate(LocalDateTime.now());
        project.setProjectName(objectRequest.getProject().getProjectName());
        // need to ensure that a given id exists in the user table first
        User user = userRepository.getOne(objectRequest.getUser().getId());
        project.setUser(user);
        Project newProject = projectRepository.save(project);

        return newProject;
    }

    @Override
    public void deleteProjectById(Integer id) {
       projectRepository.deleteProjectById(id);
    }

    @Override
    public Project updateProject(Integer id) {
        return null;
    }
}
