package com.itlize.project.resourceManagement.Entity;

import java.util.List;

public class ObjectRequest {

//    {
//        "user": {
//        "id": 2,
//                "user": null,
//                "password": null,
//                "role": null
//    },
//        "project": {
//        "id": 0,
//                "projectName": "project2",
//                "createDate": null,
//                "user": null,
//                "date": null
//    },
//        "resource": null,
//            "resourceList": null,
//            "projectResourceList": [
//        {
//            "id": null,
//                "project": null,
//                "resource": null
//        },
//        {
//            "id": null,
//                "project": null,
//                "resource": null
//        }
//    ]
//    }
    private User user;
    private Project project;
    private Resource resource;
    private List<Resource> resourceList;
    private List<ProjectResource> projectResourceList;

    public ObjectRequest() {
    }

    public ObjectRequest(User user, Project project, Resource resource,List<Resource> resourceList) {
        this.user = user;
        this.project = project;
        this.resource = resource;
        this.resourceList = resourceList;

    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
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

    public List<Resource> getResourceList() {
        return resourceList;
    }

    public void setResourceList(List<Resource> projectResource) {
        this.resourceList = projectResource;
    }

    public List<ProjectResource> getProjectResourceList() {
        return projectResourceList;
    }

    public void setProjectResourceList(List<ProjectResource> projectResourceList) {
        this.projectResourceList = projectResourceList;
    }

    @Override
    public String toString() {
        return "ObjectRequest{" +
                "user=" + user +
                ", project=" + project +
                ", resource=" + resource +
                '}';
    }

}
