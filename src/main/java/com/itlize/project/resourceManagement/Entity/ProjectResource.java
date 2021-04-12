package com.itlize.project.resourceManagement.Entity;

import javax.persistence.*;

@Entity
public class ProjectResource {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "project_resource_id")
    private Integer id;

    @ManyToOne(fetch = FetchType.LAZY,cascade = {CascadeType.ALL})
    @JoinColumn(name ="project_id")
    private Project project;

    @ManyToOne(fetch = FetchType.LAZY,cascade = {CascadeType.ALL})
    @JoinColumn(name ="resource_id")
    private Resource resource;


    public ProjectResource() {
    }

    public ProjectResource(Integer id, Project project, Resource resource) {
        this.id = id;
        this.project = project;
        this.resource = resource;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Project getProject() {
        return project;
    }

    public void setProject(Project project) {
        this.project = project;
    }

    public Resource getResource() {
        return resource;
    }

    public void setResource(Resource resource) {
        this.resource = resource;
    }

    @Override
    public String toString() {
        return "ProjectResource{" +
                "id=" + id +
                ", project=" + project +
                ", resource=" + resource +
                '}';
    }
}
