package com.itlize.project.resourceManagement.Repository;

import com.itlize.project.resourceManagement.Entity.Resource;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ResourceManagementRepository extends JpaRepository<Resource,Integer>{
}
