package com.itlize.project.resourceManagement.Service;

import com.itlize.project.resourceManagement.Entity.Project;
import com.itlize.project.resourceManagement.Entity.Resource;

import java.util.List;

public interface ProjectService {
    public List<Project> findAll();
    public List<Project> findAllById(Iterable<Integer> id);
    public Project createProject(Project project);
}
