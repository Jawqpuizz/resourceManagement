package com.itlize.project.resourceManagement.Entity;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Entity
public class Resource {
    @Id
    @Column(name = "resource_id", unique = true, nullable = false)
    private Integer id;
    @Column(name = "time_created")
    private LocalDateTime timeCreated;
    @Column(name = "last_updated")
    private LocalDateTime lastUpdated;


    @OneToMany(mappedBy = "Resource",fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<ResourceSubset> ResourceSubset;

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

    public List<com.itlize.project.resourceManagement.Entity.ResourceSubset> getResourceSubset() {
        return ResourceSubset;
    }

    public void setResourceSubset(List<com.itlize.project.resourceManagement.Entity.ResourceSubset> resourceSubset) {
        ResourceSubset = resourceSubset;
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
