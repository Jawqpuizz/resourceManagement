package com.itlize.project.resourceManagement.Service;

import com.itlize.project.resourceManagement.Entity.ObjectRequest;
import com.itlize.project.resourceManagement.Entity.Project;

import java.util.List;

public interface ProjectService {
    public List<Project> findAll();
    public List<Project> findAllByUserId(Integer id);

    Project findById(Integer projectId);

    public Project createProject(ObjectRequest objectRequest);
    void deleteProjectById(Integer id);
    Project updateProject(ObjectRequest objectRequest);

}
