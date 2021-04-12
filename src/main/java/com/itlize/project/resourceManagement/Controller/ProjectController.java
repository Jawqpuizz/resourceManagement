package com.itlize.project.resourceManagement.Controller;

import com.itlize.project.resourceManagement.Entity.ObjectRequest;
import com.itlize.project.resourceManagement.Entity.Project;
import com.itlize.project.resourceManagement.Service.impl.ProjectResourceServiceImpl;
import com.itlize.project.resourceManagement.Service.impl.ProjectServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;
import java.util.List;

@RestController
@RequestMapping("/project")
public class ProjectController {

    @Autowired
    private ProjectServiceImpl projectService;

    @Autowired
    private ProjectResourceServiceImpl projectResourceService;

    // Create a project with no resources
    @PostMapping("/create")
    public ResponseEntity<?> createProject(@RequestBody ObjectRequest request) {
        Project project = projectService.createProject(request);
        projectResourceService.save(project,request.getProjectResourceList());
        return ResponseEntity.ok(request);

    }

    //find all projects //the result seems wrong
    @GetMapping(value = "/allList")
    public ResponseEntity<List<Project>> allProjectList(){
        List<Project> list = projectService.findAll();
        return ResponseEntity.ok(list);

    }

    // find all project by userId
    @GetMapping("/list/{id}")
    public ResponseEntity<List<Project>> getProjectById(@PathVariable Integer id){
        List<Project> list = projectService.findAllById(id);
        return ResponseEntity.ok(list);
    }


    @PutMapping("/update/{id}")
    public ResponseEntity<?> updateProject(@PathVariable Integer projectId){
        Project newProject = projectService.updateProject(projectId);
        String message = newProject.getId()+ ": "+newProject.getProjectName()+ " has been updated!!";
        return ResponseEntity.ok(message);
    }


    @DeleteMapping("/delete/{id}")
    @Transactional
    public ResponseEntity<?> deleteProject(@PathVariable Integer projectId ){
        projectService.deleteProjectById(projectId);
        return ResponseEntity.ok().build();
    }
}