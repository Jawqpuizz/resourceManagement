package com.itlize.project.resourceManagement.Entity;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Entity
public class Resource {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "resource_id", nullable = false)
    private Integer id;
    @Column(name = "resource_name")
    private String resourceName;
    @Column(name = "time_created")
    private LocalDateTime timeCreated;
    @Column(name = "last_updated")
    private LocalDateTime lastUpdated;

    @JsonIgnore
    @OneToMany(mappedBy = "resource",fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<ProjectResource> projectResourceList;

    public Resource() { }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public LocalDateTime getTimeCreated() {
        return timeCreated;
    }

    public void setTimeCreated(LocalDateTime timeCreated) {
        this.timeCreated = timeCreated;
    }

    public LocalDateTime getLastUpdated() {
        return lastUpdated;
    }

    public void setLastUpdated(LocalDateTime lastUpdated) {
        this.lastUpdated = lastUpdated;
    }

    public String getResourceName() {
        return resourceName;
    }

    public void setResourceName(String resourcName) {
        this.resourceName = resourcName;
    }

    public List<ProjectResource> getProjectResourceList() {
        return projectResourceList;
    }

    public void setProjectResourceList(List<ProjectResource> projectResourceList) {
        this.projectResourceList = projectResourceList;
    }

    @Override
    public String toString() {
        return "Resource{" +
                "id=" + id +
                ", timeCreated=" + timeCreated +
                ", lastUpdated=" + lastUpdated +
                '}';
    }
}
