package com.itlize.project.resourceManagement.Service.impl;

import com.itlize.project.resourceManagement.Entity.Project;
import com.itlize.project.resourceManagement.Entity.ProjectResource;
import com.itlize.project.resourceManagement.Entity.Resource;
import com.itlize.project.resourceManagement.Repository.ProjectResourceRepository;
import com.itlize.project.resourceManagement.Repository.ResourceRepository;
import com.itlize.project.resourceManagement.Service.ProjectResourceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProjectResourceServiceImpl implements ProjectResourceService {

    @Autowired
    private ProjectResourceRepository projectResourceRepository;

    @Autowired
    private ResourceRepository resourceRepository;

    @Override
    public List<ProjectResource> save(Project project, List<Resource> projectResource) {
        List<ProjectResource> retValue = new ArrayList<>();
        for (Resource pr: projectResource) {
            ProjectResource newProjectResource = new ProjectResource();

            newProjectResource.setProject(project);
            // if a given resource exists then save
            Resource loadedResource = resourceRepository.getOne(pr.getId());
            if(loadedResource != null) {
                newProjectResource.setResource(loadedResource);
                retValue.add(projectResourceRepository.save(newProjectResource));
            }
        }
        return retValue;
    }

    public  List<ProjectResource> findAll(){
        return projectResourceRepository.findAll();
    }
    /// want to know how many project are using given resource
    @Override
    public List<Project> getProjectByResourceId(Integer id) {
        List<Project> projectList = new ArrayList<>();
        List<ProjectResource> projectResourceList = projectResourceRepository.findAll();
        for (ProjectResource pr: projectResourceList) {
            if(pr.getResource().getResourceCode() == id){
                projectList.add(pr.getProject());
            }
        }
        return projectList;
    }
}
