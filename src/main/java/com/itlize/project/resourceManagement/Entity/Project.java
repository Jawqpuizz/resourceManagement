package com.itlize.project.resourceManagement.Entity;

import javax.persistence.*;
import java.util.Date;

@Entity
public class Project {
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        @Column(name = "project_id" )
        private int id;
        @Column(name ="time_created")
        private Date date;
        //one user has many projects
        @Column(name ="project_owner")
        private Integer owner;




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

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Integer getOwner() {
        return owner;
    }

    public void setOwner(Integer owner) {
        this.owner = owner;
    }

    @Override
    public String toString() {
        return "Project{" +
                "id=" + id +
                ", date=" + date +
                ", owner=" + owner +
                '}';
    }
}
