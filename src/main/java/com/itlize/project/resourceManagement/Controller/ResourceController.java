package com.itlize.project.resourceManagement.Controller;

import com.itlize.project.resourceManagement.Entity.ActionResponse;
import com.itlize.project.resourceManagement.Entity.ObjectRequest;
import com.itlize.project.resourceManagement.Entity.Resource;
import com.itlize.project.resourceManagement.Service.impl.ResourceServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/resource")
public class ResourceController {
    @Autowired
    private ResourceServiceImpl resourceService;

    @GetMapping("/allList")
    public List<Resource> resourceList(){
        return resourceService.findAll();

    }

    @PostMapping("/create")
    public ResponseEntity createResource(@RequestBody ObjectRequest objectRequest){
        //todo check if the list has no duplicate code
        /// IsResourceExist will return the existing code list
       List<Resource> alreadyExistList= resourceService.isResourceExist(objectRequest.getResourceList(),"CODE");
        // if the size is 0 means that there is no duplicate resource code in this request
        if(alreadyExistList.size() == 0) {
            resourceService.createResource(objectRequest.getResourceList());
            return ResponseEntity.ok(new ActionResponse(true,"Resources have been added"));
        }else{
            return  ResponseEntity.ok(new ActionResponse(false, "Resources cannot be created, the request list contains resource code that already exist in database",alreadyExistList));

        }
    }


    @DeleteMapping("/delete/{id}")
    public ResponseEntity deleteResource(@PathVariable Integer id){
        // check if a given resource is exist in the database
        Resource newResource = resourceService.findById(id);
        if(newResource == null){
            return new ResponseEntity(new ActionResponse(false,"Resource id not found"), HttpStatus.BAD_REQUEST);
        }
        resourceService.deleteResourceById(id);
        ActionResponse actionResponse = new ActionResponse(true,"Resource has been deleted");
        return ResponseEntity.ok(actionResponse);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity updateResource(@PathVariable Integer id ,@RequestBody Resource resource) throws Exception {
        //check if the given resource id is exist in the database
        if(resourceService.findById(id) == null){
            return new ResponseEntity(new ActionResponse(false,"Resource not found"), HttpStatus.BAD_REQUEST);
        }
        // check new resource code is exist
        if(resourceService.isResourceCodeExist(resource.getResourceCode())){
            return new ResponseEntity(new ActionResponse(false,"Resource cannot be updated - code: "+ resource.getResourceCode()+" is already exist"), HttpStatus.BAD_REQUEST);
        }

        resourceService.updateResource(id,resource);
        return new ResponseEntity(new ActionResponse(true, "The resource "+id+ " has been updated"), HttpStatus.OK);
    }
}
