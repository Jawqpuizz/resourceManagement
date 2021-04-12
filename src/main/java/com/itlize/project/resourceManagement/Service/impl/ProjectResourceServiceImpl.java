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
    public List<ProjectResource> save(Project project, List<ProjectResource> projectResource) {
        List<ProjectResource> retValue = new ArrayList<>();
        for (ProjectResource pr: projectResource) {
            ProjectResource newProjectResource = new ProjectResource();

            newProjectResource.setProject(project);

            newProjectResource.setResource(resourceRepository.getOne(pr.getId()));
            System.out.println(newProjectResource.toString());
            retValue.add(projectResourceRepository.save(newProjectResource));
        }
        return retValue;
    }
}
