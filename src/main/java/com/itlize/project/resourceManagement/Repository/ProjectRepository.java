package com.itlize.project.resourceManagement.Repository;

import com.itlize.project.resourceManagement.Entity.Project;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProjectRepository extends JpaRepository<Project,Integer> {
    List<Project> findAllById(Integer id);
    void deleteProjectById(Integer id);
}
