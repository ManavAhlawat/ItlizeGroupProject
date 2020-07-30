package com.Project1.ItlizeGroupProject.TO;

import com.fasterxml.jackson.annotation.JsonInclude;

import java.util.List;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class ProjectTO {

    private int projectCode;
    private String projectName;
    private UserTO user;
    private List<ResourceTO> resources;

    public int getProjectCode() {
        return projectCode;
    }

    public void setProjectCode(int projectCode) {
        this.projectCode = projectCode;
    }

    public String getProjectName() {
        return projectName;
    }

    public void setProjectName(String projectName) {
        this.projectName = projectName;
    }

    public UserTO getUser() {
        return user;
    }

    public void setUser(UserTO user) {
        this.user = user;
    }

    public List<ResourceTO> getResources() {
        return resources;
    }

    public void setResources(List<ResourceTO> resources) {
        this.resources = resources;
    }

    @Override
    public String toString() {
        return "ProjectTO{" +
                "projectCode=" + projectCode +
                ", projectName='" + projectName + '\'' +
                ", user=" + user +
                ", resources=" + resources +
                '}';
    }
}
