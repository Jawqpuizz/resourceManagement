package com.itlize.project.resourceManagement.Repository;

import com.itlize.project.resourceManagement.Entity.Resource;
import org.springframework.data.jpa.repository.JpaRepository;


public interface ResourceRepository extends JpaRepository<Resource,Integer>{
    void deleteResourceById(Integer id);
}
