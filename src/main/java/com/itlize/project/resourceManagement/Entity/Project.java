package com.itlize.project.resourceManagement.Entity;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

@Entity
public class Project {
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        @Column(name = "project_id" )
        private int id;
        @Column(name = "project_name")
        private String projectName;
        @Column(name ="time_created")
        private LocalDateTime  createDate;

        //one user has many projects
        @ManyToOne (cascade = CascadeType.ALL)
        @JoinColumn(name ="user_id")
        private User user;

        @JsonIgnore
        @OneToMany(mappedBy = "project", cascade = CascadeType.ALL)
        private List<ProjectResource> projectResourceList;




    public Project() {
    }

    public Project(Date date, String owner) {

    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public LocalDateTime getDate() {
        return createDate;
    }

    public void setDate(LocalDateTime date) {
        this.createDate = date;
    }

    public String getProjectName() {
        return projectName;
    }

    public void setProjectName(String projectName) {
        this.projectName = projectName;
    }

    public LocalDateTime getCreateDate() {
        return createDate;
    }

    public void setCreateDate(LocalDateTime createDate) {
        this.createDate = createDate;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public List<ProjectResource> getProjectResourceList() {
        return projectResourceList;
    }

    public void setProjectResourceList(List<ProjectResource> projectResourceList) {
        this.projectResourceList = projectResourceList;
    }

    @Override
    public String toString() {
        return "Project{" +
                "id=" + id +
                ", projectName='" + projectName + '\'' +
                ", createDate=" + createDate +
                ", user=" + user +
                ", projectResourceList=" + projectResourceList +
                '}';
    }
}
