package com.itlize.project.resourceManagement.Controller;

import com.itlize.project.resourceManagement.Entity.ObjectRequest;
import com.itlize.project.resourceManagement.Entity.Resource;
import com.itlize.project.resourceManagement.Service.impl.ResourceServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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
    public ResponseEntity createResource(@RequestBody ObjectRequest objectRequest){
        resourceService.createResource(objectRequest.getResourceList());
        return ResponseEntity.ok("Resource have been created");
    }


    @DeleteMapping("/delete/{id}")
    public ResponseEntity deleteResource(@PathVariable Integer id){
        resourceService.delete(id);
        return ResponseEntity.ok("Resource has been deleted!!");
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<?> updateResource(@PathVariable Integer id ,@RequestBody Resource resource){
        resourceService.updateResource(id,resource);
        return ResponseEntity.ok(resource);
    }
}
