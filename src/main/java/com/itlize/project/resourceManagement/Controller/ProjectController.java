package com.itlize.project.resourceManagement.Controller;

import com.itlize.project.resourceManagement.Entity.ActionResponse;
import com.itlize.project.resourceManagement.Entity.ObjectRequest;
import com.itlize.project.resourceManagement.Entity.Project;
import com.itlize.project.resourceManagement.Entity.Resource;
import com.itlize.project.resourceManagement.Service.impl.ProjectResourceServiceImpl;
import com.itlize.project.resourceManagement.Service.impl.ProjectServiceImpl;
import com.itlize.project.resourceManagement.Service.impl.ResourceServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;
import java.util.List;

@RestController
@RequestMapping("/api/project")
public class ProjectController {

    @Autowired
    private ProjectServiceImpl projectService;

    @Autowired
    private ProjectResourceServiceImpl projectResourceService;

    @Autowired
    private ResourceServiceImpl resourceService;

    // Create a project
    @PostMapping("/create")
    public ResponseEntity<?> createProject(@RequestBody ObjectRequest request) {
        List<Resource> unknownResource= (resourceService.isResourceExist(request.getResourceList(),"ID"));
        if(unknownResource.size() != 0){
            return new ResponseEntity(new ActionResponse(false,"The project cannot be created, it contains unknown resources", unknownResource),HttpStatus.BAD_REQUEST);
        }
        Project project = projectService.createProject(request);
        projectResourceService.save(project,request.getResourceList());
        return ResponseEntity.ok(new ActionResponse(true,"Project id: "+project.getId()+" has been created"));

    }

    //find all projects
    @GetMapping(value = "/allList")

    public ResponseEntity<List<Project>> getAllProjects(){
        List<Project> list = projectService.findAll();
        return ResponseEntity.ok(list);

    }

    // find all projects by userId
    @GetMapping("/list/{userid}")
    public ResponseEntity<List<Project>> getProjectByUserId(@PathVariable Integer userid){
        List<Project> projectList = projectService.findAllByUserId(userid);
        if(projectList.size() == 0){
            return new ResponseEntity(new ActionResponse(false,"Project for user id: "+userid+ " not found"), HttpStatus.BAD_REQUEST);
        }
        List<Project> list = projectService.findAllByUserId(userid);
        return ResponseEntity.ok(list);
    }


    @PutMapping("/update")
    public ResponseEntity updateProject(@RequestBody ObjectRequest objectRequest){
        // check if the project is already exist first
        Project projectFound = projectService.findById(objectRequest.getProject().getId());
        if(projectFound == null){
            return new ResponseEntity(new ActionResponse(false,"Project id:"+objectRequest.getProject().getId()+" not found"),HttpStatus.BAD_REQUEST);
        }
        // no error
        Project newProject = projectService.updateProject(objectRequest);
        String message = newProject.getId()+ ": "+newProject.getProjectName()+ " has been updated!!";
        return ResponseEntity.ok(new ActionResponse(true,message));
    }

    @PostMapping("/addResource")
    public ResponseEntity addResourceToProject(@RequestBody ObjectRequest objectRequest){
          Project projectFound = projectService.findById(objectRequest.getProject().getId());
                if(projectFound == null){
                    return new ResponseEntity(new ActionResponse(false,"Project id:"+objectRequest.getProject().getId()+" not found"),HttpStatus.BAD_REQUEST);
                }

        /// check if the resources to be added are exist in the database
        List<Resource> unknownResource = resourceService.isResourceExist(objectRequest.getResourceList(),"ID");
        if(unknownResource.size() != 0){
            return new ResponseEntity(new ActionResponse(false,"Project id:"+objectRequest.getProject().getId()+" try to add unknown resource", unknownResource),HttpStatus.BAD_REQUEST);
        }
        projectResourceService.save(projectFound, objectRequest.getResourceList());
        return new ResponseEntity(new ActionResponse(false," Resource was successfully added to the Project id:"+objectRequest.getProject().getId()),HttpStatus.OK);
    }

    @DeleteMapping("/delete/{projectId}")
    @Transactional
    public ResponseEntity deleteProject(@PathVariable Integer projectId ){
        if(projectService.findById(projectId) == null){
            return new ResponseEntity(new ActionResponse(false,"Project id not found"), HttpStatus.BAD_REQUEST );
        }
        projectService.deleteProjectById(projectId);
        return ResponseEntity.ok(new ActionResponse(true,"Project has been deleted"));
    }
}