package com.itlize.project.resourceManagement.Repository;

import com.itlize.project.resourceManagement.Entity.Resource;
import com.itlize.project.resourceManagement.Entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ResourceManagementRepository extends JpaRepository<User,Integer>{
}
