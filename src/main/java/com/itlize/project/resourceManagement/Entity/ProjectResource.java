package com.itlize.project.resourceManagement.Entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class ProjectResource {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private int projectId;
    private int resourceId;

    public ProjectResource() {
    }

    public ProjectResource(int id, int projectId, int resourceId) {
        this.id = id;
        this.projectId = projectId;
        this.resourceId = resourceId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getProjectId() {
        return projectId;
    }

    public void setProjectId(int projectId) {
        this.projectId = projectId;
    }

    public int getResourceId() {
        return resourceId;
    }

    public void setResourceId(int resourceId) {
        this.resourceId = resourceId;
    }
}
