package com.itlize.project.resourceManagement.Controller;

import com.itlize.project.resourceManagement.Entity.Project;
import com.itlize.project.resourceManagement.Service.impl.ProjectServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/project")
public class ProjectController {

    @Autowired
    private ProjectServiceImpl projectService;


    @PostMapping("/create/{id}")
    public ResponseEntity<?> createProject(@PathVariable Integer userId,@RequestBody Project project){

        projectService.createProject(project);
        return ResponseEntity.ok(project);

    }
}
