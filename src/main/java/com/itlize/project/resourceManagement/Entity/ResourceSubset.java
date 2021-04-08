package com.itlize.project.resourceManagement.Entity;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
public class ResourceSubset {
    @Id
    @Column(name = "resource_subset_id", unique = true, nullable = false)
    private Integer id;
    @Column(name = "time_created")
    private LocalDateTime timeCreated;
    @Column(name = "last_updated")
    private LocalDateTime lastUpdated;
    @Column(name = "column_value")
    private String columnValue;
    @Column(name = "project_column_id")
    private Integer columnId;

    @ManyToOne(fetch = FetchType.LAZY,cascade = {CascadeType.ALL})
    @JoinColumn(name = "resource_id")
    private Resource resource;

    public ResourceSubset() {
    }

    public ResourceSubset(LocalDateTime timeCreated, LocalDateTime lastUpdated, String columnValue, Integer columnId) {
        this.timeCreated = timeCreated;
        this.lastUpdated = lastUpdated;
        this.columnValue = columnValue;
        this.columnId = columnId;
    }

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


    public String getColumnValue() {
        return columnValue;
    }

    public void setColumnValue(String columnValue) {
        this.columnValue = columnValue;
    }

    public Integer getColumnId() {
        return columnId;
    }

    public void setColumnId(Integer columnId) {
        this.columnId = columnId;
    }

    public Resource getResource() {
        return resource;
    }

    public void setResource(Resource resource) {
        this.resource = resource;
    }

    @Override
    public String toString() {
        return "ResourceDetail{" +
                "id=" + id +
                ", timeCreated=" + timeCreated +
                ", lastUpdated=" + lastUpdated +
                ", columnValue='" + columnValue + '\'' +
                ", columnId=" + columnId +
                '}';
    }
}