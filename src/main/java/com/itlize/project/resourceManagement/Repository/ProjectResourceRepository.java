package com.itlize.project.resourceManagement.Repository;

import com.itlize.project.resourceManagement.Entity.ProjectResource;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProjectResourceRepository extends JpaRepository<ProjectResource,Integer> {

}
