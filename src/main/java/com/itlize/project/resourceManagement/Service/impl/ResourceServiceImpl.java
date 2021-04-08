package com.itlize.project.resourceManagement.Service.impl;


import com.itlize.project.resourceManagement.Entity.Resource;
import com.itlize.project.resourceManagement.Entity.ResourceSubset;
import com.itlize.project.resourceManagement.Repository.ResourceDetailRepository;
import com.itlize.project.resourceManagement.Repository.ResourceRepository;
import com.itlize.project.resourceManagement.Service.ResourceDetailService;
import com.itlize.project.resourceManagement.Service.ResourceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

@Service
@Transactional
public class ResourceServiceImpl implements ResourceService , ResourceDetailService {

    @Autowired
    public ResourceRepository resourceRepository;

    @Autowired
    public ResourceDetailRepository resourceDetailRepository;

     public Resource createResource(ResourceSubset resourceDetail){
         Resource newResource = new Resource();
         newResource.setTimeCreated(LocalDateTime.now());
         newResource.setLastUpdated(LocalDateTime.now());
         //Set resource details
         ResourceSubset newResourceDetail = new ResourceSubset();
         newResourceDetail.setColumnValue(resourceDetail.getColumnValue());
         newResourceDetail.setTimeCreated(LocalDateTime.now());
         newResourceDetail.setLastUpdated(LocalDateTime.now());


         return resourceRepository.save(newResource);
     }

    @Override
    public void delete(Integer id) {
        resourceRepository.deleteResourceById(id);
    }
    // todo delete all

    @Override
    public List<Resource> findAll() {
        return resourceRepository.findAll();
    }

    @Override
    public List<Resource> findAllById(Iterable<Integer> id) {
        return resourceRepository.findAllById(id);
    }


    public Resource updateResource(Integer id, ResourceSubset resourceDetail){

         Resource newResource = resourceRepository.findById(id).orElse(null);
         newResource.setLastUpdated(LocalDateTime.now());
         resourceRepository.save(newResource);



        return newResource;

    }

}
