package com.itlize.project.resourceManagement.Controller;

import com.itlize.project.resourceManagement.Entity.ObjectRequest;
import com.itlize.project.resourceManagement.Entity.Resource;
import com.itlize.project.resourceManagement.Service.impl.ResourceServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
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
        resourceService.createResource(objectRequest.getResourceList());
        return ResponseEntity.ok("Resources have been created!!");
    }


    @DeleteMapping("/delete/{id}")
    public ResponseEntity deleteResource(@PathVariable Integer id){
        resourceService.deleteResourceById(id);
        return ResponseEntity.ok("Resource has been deleted!!");
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<?> updateResource(@PathVariable Integer id ,@RequestBody Resource resource) throws Exception {
        //check if the given resource id is exist in the database
        if(resourceService.findById(id) == null){
            return ResponseEntity.ok("Resource not found!!");
        }
        // check new resource code is exist
        if(resourceService.isResourceExist(resource.getResourceCode())){
            return ResponseEntity.ok("resource code "+resource.getResourceCode()+" is already exist!!");
        }

        resourceService.updateResource(id,resource);
        return ResponseEntity.ok(resource);
    }
}
