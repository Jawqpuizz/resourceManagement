package com.itlize.project.resourceManagement.Repository;

import com.itlize.project.resourceManagement.Entity.ProjectColumn;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProjectColumnRepository extends JpaRepository<ProjectColumn, Integer> {
}
