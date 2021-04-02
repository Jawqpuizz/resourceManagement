package com.itlize.project.resourceManagement.Entity;

public class Resource {
    private int id;
    private String resourceCode;
    private String resourceName;
    private String resourceDesc;

    public Resource() { }

    public Resource(int id, String resourceCode, String resourceName, String resourceDesc) {
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

    public String getResourceCode() {
        return resourceCode;
    }

    public void setResourceCode(String resourceCode) {
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
