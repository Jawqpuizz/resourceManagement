package com.itlize.project.resourceManagement.Controller;

import com.itlize.project.resourceManagement.Entity.Project;
import com.itlize.project.resourceManagement.Repository.ProjectResourceRepository;
import com.itlize.project.resourceManagement.Service.impl.ProjectResourceServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/management")
public class ProjectResourceController {
    @Autowired
    private ProjectResourceServiceImpl projectResourceService;
    // if we want to get a list of all projects that use a given resource
    @GetMapping("/projList/rescode={resourceId}")
    public List<Project> getProjectByResourceId(Integer resourceId){
        return projectResourceService.getProjectByResourceId(resourceId);
    }
}
