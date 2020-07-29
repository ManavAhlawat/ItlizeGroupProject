package com.Project1.ItlizeGroupProject.Service;


import com.Project1.ItlizeGroupProject.Entity.Project;
import com.Project1.ItlizeGroupProject.Entity.User;
import com.Project1.ItlizeGroupProject.Repository.ProjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProjectService {

    @Autowired
    private ProjectRepository projectRepository;

    public List<Project> getProjects() {
        return projectRepository.findAll();
    }

    public Project getProjectById(int projectCode){
        return projectRepository.findById(projectCode).orElse(null);
    }

    public Project getProjectByName(String projectName){
        return projectRepository.findByProjectName(projectName);
    }

    public String deleteProject(int projectCode){
        projectRepository.deleteById(projectCode);
        return "Project removed: " + projectCode;
    }

    public Project updateProject(Project project){
        Project existingProject = projectRepository.findById(project.getProjectCode()).orElse(null);
        existingProject.setProjectName(project.getProjectName());
        return projectRepository.save(existingProject);
    }

}
