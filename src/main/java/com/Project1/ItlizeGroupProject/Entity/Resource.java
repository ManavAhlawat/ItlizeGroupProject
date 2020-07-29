package com.Project1.ItlizeGroupProject.Entity;

import javax.persistence.*;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Table(name="resource")
public class Resource {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ResourceCode")
    private int resourceCode;

    @Column(name = "ResourceName")
    private String resourceName;

//    @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, mappedBy = "resources")
//    private Set<Project> projects = new HashSet<>();

//    @OneToMany(targetEntity = ProjectResource.class, cascade = CascadeType.ALL, fetch = FetchType.EAGER)
//    @JoinColumn(name = "Resource_FK", referencedColumnName = "resourceCode")
//    private List<ProjectResource> projectResources;

    @OneToMany(mappedBy = "resource", cascade = CascadeType.ALL)
    private Set<ProjectResource> projectResources = new HashSet<>();

    public Set<ProjectResource> getProjectResources() {
        for(ProjectResource pr: projectResources){
            pr.setResource(null);
        }
        return projectResources;
    }

    public void setProjectResources(Set<ProjectResource> projectResources) {
        this.projectResources = projectResources;
    }

    public Resource(){

    }

    public Resource(String resourceName) {
        super();
        this.resourceName = resourceName;
    }

    public void setResourceCode(int resourceCode) {
        this.resourceCode = resourceCode;
    }

    public void setResourceName(String resourceName) {
        this.resourceName = resourceName;
    }

//    public void setProjects(Set<Project> projects) {
//        this.projects = projects;
//    }

    public int getResourceCode() {
        return resourceCode;
    }

    public String getResourceName() {
        return resourceName;
    }

//    public Set<Project> getProjects() {
//        for(Project p: projects){
//            p.setResources(new HashSet<>());
//        }
//        return projects;
//    }
}