package com.itlize.project.resourceManagement.Service.impl;


import com.itlize.project.resourceManagement.Entity.Resource;
import com.itlize.project.resourceManagement.Repository.ResourceRepository;
import com.itlize.project.resourceManagement.Service.ResourceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.sql.SQLIntegrityConstraintViolationException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
public class ResourceServiceImpl implements ResourceService {

    @Autowired
    public ResourceRepository resourceRepository;



    public List<Resource> createResource(List<Resource> resource){
         List<Resource> retList = new ArrayList<>();
         for (Resource r: resource) {
             Resource newResource = new Resource();
             newResource.setResourceCode(r.getResourceCode());
             newResource.setResourceName(r.getResourceName());
             newResource.setTimeCreated(LocalDateTime.now());
             newResource.setLastUpdated(LocalDateTime.now());
             retList.add(resourceRepository.save(newResource));
         }

         return retList;
     }

    @Override
    public void deleteResourceById(Integer id) {
        resourceRepository.deleteResourceById(id);
    }



    @Override
    public List<Resource> findAll() {
        return resourceRepository.findAll();
    }

    @Override
    public Resource findById(Integer id) {
        return resourceRepository.findById(id).orElse(null);
    }


    public Boolean isResourceExist(Integer resourceCode) {
        List<Resource> resourceList = resourceRepository.findAll();
        for (Resource resource: resourceList) {
            if(resource.getResourceCode() == resourceCode){
                return true;
            }
        }
        return false;
    }



    public Resource updateResource(Integer id, Resource resourceDetail) throws Exception {
        Resource newResource = resourceRepository.findById(id).orElse(null);
        /// if resource code already exist throe exception
        newResource.setResourceCode(resourceDetail.getResourceCode());
        newResource.setResourceName(resourceDetail.getResourceName());
        newResource.setLastUpdated(LocalDateTime.now());
        resourceRepository.save(newResource);


        return resourceRepository.save(newResource);
    }



}
