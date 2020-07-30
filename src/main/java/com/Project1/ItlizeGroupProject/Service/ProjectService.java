package com.Project1.ItlizeGroupProject.Service;


import com.Project1.ItlizeGroupProject.Entity.Project;
import com.Project1.ItlizeGroupProject.Entity.ProjectResource;
import com.Project1.ItlizeGroupProject.Entity.Resource;
import com.Project1.ItlizeGroupProject.Entity.User;
import com.Project1.ItlizeGroupProject.Repository.ProjectRepository;
import com.Project1.ItlizeGroupProject.Repository.ProjectResourceRepository;
import com.Project1.ItlizeGroupProject.Repository.UserRepository;
import com.Project1.ItlizeGroupProject.TO.ProjectTO;
import com.Project1.ItlizeGroupProject.TO.ResourceTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProjectService {

    @Autowired
    private ProjectRepository projectRepository;

    @Autowired
    private ProjectResourceRepository projectResourceRepository;

    @Autowired
    private UserRepository userRepository;

    public List<ProjectTO> getProjects() {
        List<ProjectTO> projectsToReturn = new ArrayList<>();
        for(Project p: projectRepository.findAll()){
            projectsToReturn.add(createProjectTO(p));
        }
        return projectsToReturn;
    }

    public ProjectTO getProjectById(int projectCode){
        return createProjectTO(projectRepository.findById(projectCode).orElse(null));
    }

    public ProjectTO getProjectByName(String projectName){
        return createProjectTO(projectRepository.findByProjectName(projectName));
    }

    public String deleteProject(int projectCode){
        if(projectRepository.existsById(projectCode)) {
            Project projectToDelete = projectRepository.findById(projectCode).orElse(null);
            User userOfProject = projectToDelete.getUser();
            userOfProject.getProjects().remove(projectToDelete);
            userRepository.save(userOfProject);
            projectRepository.deleteById(projectCode);
            return "Project removed: " + projectCode;
        }else{
            return "No Project to delete by id: "+ projectCode;
        }
    }

    public ProjectTO updateProject(ProjectTO project){
        System.out.println("Project code to update "+ project.getProjectCode());
        Project existingProject = projectRepository.findById(project.getProjectCode()).orElse(null);
        if(existingProject != null) {
            existingProject.setProjectName(project.getProjectName());
            existingProject.setUser(UserService.createUserEntity(project.getUser()));
            existingProject = projectRepository.save(existingProject);
            updateResourcesMapping(existingProject,project.getResources());
            return createProjectTO(existingProject);
        }
        return null;
    }

    public boolean createProject(ProjectTO project){
        Project projectEntity = createProjectEntity(project);
        projectEntity = projectRepository.save(projectEntity);
        updateResourcesMapping(projectEntity,project.getResources());
        return true;
    }

    public static Project createProjectEntity(ProjectTO projectTO){
        Project projectEntity = new Project();
        projectEntity.setProjectName(projectTO.getProjectName());
        if(projectTO.getUser() != null)
            projectEntity.setUser(UserService.createUserEntity(projectTO.getUser()));
        projectEntity.setProjectCode(projectTO.getProjectCode());
        return projectEntity;
    }
    public static ProjectTO createProjectTO(Project projectEntity){
        ProjectTO projectTO = new ProjectTO();
        projectTO.setProjectCode(projectEntity.getProjectCode());
        projectTO.setProjectName(projectEntity.getProjectName());
        projectTO.setUser(UserService.createUserTO(projectEntity.getUser()));
        List<ResourceTO> resources = new ArrayList<>();
        for(ProjectResource pr : projectEntity.getProjectResources()){
            ResourceTO rTemp = new ResourceTO();
            rTemp.setResourceCode(pr.getResource().getResourceCode());
            rTemp.setResourceName(pr.getResource().getResourceName());
            resources.add(rTemp);
        }
        projectTO.setResources(resources);
        return projectTO;
    }
    private void updateResourcesMapping(Project project, List<ResourceTO> resources){
        for(ResourceTO r: resources){
            ProjectResource pr = new ProjectResource();
            Resource rEntity = new Resource();
            //System.out.println(r);
            rEntity.setResourceCode(r.getResourceCode());
            rEntity.setResourceName(r.getResourceName());
            pr.setProject(project);
            pr.setResource(rEntity);
            projectResourceRepository.save(pr);
        }
    }
}
