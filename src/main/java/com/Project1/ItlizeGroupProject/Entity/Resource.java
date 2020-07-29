package com.Project1.ItlizeGroupProject.Entity;

import javax.persistence.*;
import java.util.HashSet;
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

    @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, mappedBy = "resources")
    private Set<Project> projects = new HashSet<>();

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

    public void setProjects(Set<Project> projects) {
        this.projects = projects;
    }

    public int getResourceCode() {
        return resourceCode;
    }

    public String getResourceName() {
        return resourceName;
    }

    public Set<Project> getProjects() {
        for(Project p: projects){
            p.setResources(new HashSet<>());
        }
        return projects;
    }
}