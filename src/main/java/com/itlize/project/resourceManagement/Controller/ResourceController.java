package com.itlize.project.resourceManagement.Controller;

import com.itlize.project.resourceManagement.Entity.Resource;
import com.itlize.project.resourceManagement.Entity.ResourceSubset;
import com.itlize.project.resourceManagement.Service.impl.ResourceServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/resource")
public class ResourceController {
    @Autowired
    private ResourceServiceImpl resourceService;


    @GetMapping("/allList")
    public List<Resource> resourceList(){
        return resourceService.findAll();

    }

    @PostMapping("/create")
    public ResponseEntity createResource(ResourceSubset resource){
        resourceService.createResource(resource);
       return ResponseEntity.ok(resource);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity deleteResource(@PathVariable Integer id){
        resourceService.delete(id);
        return ResponseEntity.ok("Resource has been deleted!!");
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<?> updateResource(@PathVariable Integer id ,@RequestBody ResourceSubset resource){
        System.out.println("I am in the controller layer");
        resourceService.updateResource(id,resource);
        return ResponseEntity.ok(resource);
    }
}
