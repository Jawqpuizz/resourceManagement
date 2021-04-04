package com.itlize.project.resourceManagement.Entity;

import javax.persistence.*;

@Entity
public class Resource {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private int resourceCode;
    private String resourceName;
    private String resourceDesc;

    public Resource() { }

    public Resource(int id, int resourceCode, String resourceName, String resourceDesc) {
        this.id = id;
        this.resourceCode = resourceCode;
        this.resourceName = resourceName;
        this.resourceDesc = resourceDesc;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getResourceCode() {
        return resourceCode;
    }

    public void setResourceCode(int resourceCode) {
        this.resourceCode = resourceCode;
    }

    public String getResourceName() {
        return resourceName;
    }

    public void setResourceName(String resourceName) {
        this.resourceName = resourceName;
    }

    public String getResourceDesc() {
        return resourceDesc;
    }

    public void setResourceDesc(String resourceDesc) {
        this.resourceDesc = resourceDesc;
    }
}
