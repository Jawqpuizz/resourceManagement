package com.itlize.project.resourceManagement.Service.impl;

import com.itlize.project.resourceManagement.Entity.Project;
import com.itlize.project.resourceManagement.Entity.Resource;
import com.itlize.project.resourceManagement.Repository.ProjectRepository;
import com.itlize.project.resourceManagement.Service.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.criteria.CriteriaBuilder;
import java.util.ArrayList;
import java.util.List;
@Service
public class ProjectServiceImpl implements ProjectService {

    @Autowired
    public ProjectRepository projectRepository;

    @Override
    public List<Project> findAll() {
        return projectRepository.findAll();
    }

    @Override
    public List<Project> findAllById(Iterable<Integer> id) {
        List<Project> list = new ArrayList<>();
        list = projectRepository.findAllById(id);
        for (Project p: list) {
            System.out.print(p);
        }
        return projectRepository.findAllById(id);

    }

    @Override
    public Project createProject(Project project) {
        return projectRepository.save(project);
    }
}
