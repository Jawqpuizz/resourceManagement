package com.itlize.project.resourceManagement.Service.impl;


import com.itlize.project.resourceManagement.Entity.Resource;
import com.itlize.project.resourceManagement.Repository.ResourceRepository;
import com.itlize.project.resourceManagement.Service.ResourceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.time.LocalDateTime;
import java.util.List;

@Service
@Transactional
public class ResourceServiceImpl implements ResourceService {

    @Autowired
    public ResourceRepository resourceRepository;


     public Resource createResource(List<Resource> resource){
         Resource newResource = new Resource();
         for (Resource r: resource) {
             System.out.println(r.getId());
             newResource.setId(r.getId());
             newResource.setTimeCreated(LocalDateTime.now());
             newResource.setLastUpdated(LocalDateTime.now());
             newResource.setResourceName(r.getResourceName());
             resourceRepository.save(newResource);
         }

         return newResource;
     }

    @Override
    public void delete(Integer id) {
        resourceRepository.deleteResourceById(id);
    }


    @Override
    public List<Resource> findAll() {
        return resourceRepository.findAll();
    }

    @Override
    public List<Resource> findAllById(Iterable<Integer> id) {
        return resourceRepository.findAllById(id);
    }


    public Resource updateResource(Integer id, Resource resourceDetail){

         Resource newResource = resourceRepository.findById(id).orElse(null);
         newResource.setLastUpdated(LocalDateTime.now());
         resourceRepository.save(newResource);



        return newResource;

    }

}
