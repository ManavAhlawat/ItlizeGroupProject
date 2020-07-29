package com.Project1.ItlizeGroupProject.Entity;



import com.fasterxml.jackson.annotation.JsonInclude;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;


@Entity
@Table(name="project")
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Project {

    @Id
    @Column(name="ProjectCode")
    private int projectCode;

    @Column(name="projectName")
    private String projectName;

//    @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.DETACH)
//    @JoinTable(name = "project_resource", joinColumns = {@JoinColumn(name = "projectCode")}, inverseJoinColumns = {@JoinColumn(name = "resourceCode")})
//    private Set<Resource> resources = new HashSet<>();

    @ManyToOne(targetEntity = User.class, cascade = CascadeType.DETACH, fetch = FetchType.EAGER)
    @JoinColumn(name="UserProject_FK", nullable = false,referencedColumnName ="userID")
    private User user;

//    @OneToMany(targetEntity = ProjectResource.class, cascade = CascadeType.ALL, fetch = FetchType.EAGER)
//    @JoinColumn(name = "Project_FK", referencedColumnName = "projectCode")
//    private List<ProjectResource> projectResources;

//    public List<ProjectResource> getProjectResources() {
//        return projectResources;
//    }
//
//    public void setProjectResources(List<ProjectResource> projectResources) {
//        this.projectResources = projectResources;
//    }

    @OneToMany(mappedBy = "project", cascade = CascadeType.ALL)
    private Set<ProjectResource> projectResources;

    public Set<ProjectResource> getProjectResources() {
        for(ProjectResource pr: projectResources){
            pr.setProject(null);
        }
        return projectResources;
    }

    public void setProjectResources(Set<ProjectResource> projectResources) {
        this.projectResources = projectResources;
    }

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

//    public Set<Resource> getResources() {
//        for (Resource r: resources) {
//            r.setProjects(new HashSet<>());
//        }
//        return resources;
//    }
//
//    public void setResources(Set<Resource> resources) {
//        this.resources = resources;
//    }

    public User getUser() {
        if(this.user != null)
            this.user.setProjects(new ArrayList<>());
        return this.user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
