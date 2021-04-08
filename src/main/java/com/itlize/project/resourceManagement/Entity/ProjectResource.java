package com.itlize.project.resourceManagement.Entity;

import javax.persistence.*;

@Entity
public class ProjectResource {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "project_resource_id")
    private Integer id;
    private Integer projectId;
    private Integer resourceId;

    public ProjectResource() {
    }

    public ProjectResource(Integer id, Integer projectId, Integer resourceId) {
        this.id = id;
        this.projectId = projectId;
        this.resourceId = resourceId;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getProjectId() {
        return projectId;
    }

    public void setProjectId(Integer projectId) {
        this.projectId = projectId;
    }

    public Integer getResourceId() {
        return resourceId;
    }

    public void setResourceId(Integer resourceId) {
        this.resourceId = resourceId;
    }
}
