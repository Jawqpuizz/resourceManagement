package com.itlize.project.resourceManagement.Entity;

import javax.persistence.*;

@Entity
public class Project {
        @Id
        @GeneratedValue(strategy = GenerationType.AUTO)
        private int id;
        private String projectName;
        private String projectDetail;

    public Project() {
    }

    public Project(int id, String projectName, String projectDetail) {
        this.id = id;
        this.projectName = projectName;
        this.projectDetail = projectDetail;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getProjectName() {
        return projectName;
    }

    public void setProjectName(String projectName) {
        this.projectName = projectName;
    }

    public String getProjectDetail() {
        return projectDetail;
    }

    public void setProjectDetail(String projectDetail) {
        this.projectDetail = projectDetail;
    }
}
