package com.Project1.ItlizeGroupProject.Entity;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="project")
public class Project {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)

    @Column(name="ProjectCode")
    private int projectCode;

    @Column(name="projectName")
    private String projectName;

    public Project() {
    }

    public int getProjectCode() {
        return projectCode;
    }

    public String getProjectName() {
        return projectName;
    }

    public void setProjectCode(int projectCode) {
        this.projectCode = projectCode;
    }

    public void setProjectName(String projectName) {
        this.projectName = projectName;
    }
}
