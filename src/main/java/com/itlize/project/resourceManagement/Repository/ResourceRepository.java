package com.itlize.project.resourceManagement.Repository;

import com.itlize.project.resourceManagement.Entity.Resource;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ResourceRepository extends JpaRepository<Resource,Integer>{
    void deleteResourceById(Integer id);
    Optional<Resource> findById(Integer id);
}
