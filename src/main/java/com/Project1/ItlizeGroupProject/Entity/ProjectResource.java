package com.Project1.ItlizeGroupProject.Entity;

import com.fasterxml.jackson.annotation.JsonInclude;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name="ProjectResource")
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ProjectResource {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name="projectResourceId")
    private int projectResourceId;

    @ManyToOne
    private Project project;

    @ManyToOne
    private Resource resource;

    public ProjectResource() {
    }

    public int getProjectResourceId() {
        return projectResourceId;
    }

    public void setProjectResourceId(int projectResourceId) {
        this.projectResourceId = projectResourceId;
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
}
