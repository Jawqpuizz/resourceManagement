package com.itlize.project.resourceManagement.Service;

import com.itlize.project.resourceManagement.Entity.Project;
import com.itlize.project.resourceManagement.Entity.Resource;
import com.itlize.project.resourceManagement.Entity.User;

import java.util.List;

public interface ResourceService {
   public List<Resource> findAll();
   public List<Resource> findAllById(Iterable<Integer> id);
   public void delete(Integer id);

}
