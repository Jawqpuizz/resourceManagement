package com.itlize.project.resourceManagement.Service;

import com.itlize.project.resourceManagement.Entity.Project;
import com.itlize.project.resourceManagement.Entity.ProjectResource;

import java.util.List;

public interface ProjectResourceService {
    List<ProjectResource> save(Project project, List<ProjectResource> projectResource);
}
