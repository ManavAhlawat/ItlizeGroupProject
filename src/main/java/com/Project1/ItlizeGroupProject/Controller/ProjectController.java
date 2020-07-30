package com.Project1.ItlizeGroupProject.Controller;

import com.Project1.ItlizeGroupProject.Service.ProjectService;
import com.Project1.ItlizeGroupProject.TO.ProjectTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ProjectController {

    @Autowired
    private ProjectService service;

    @GetMapping("/projects")
    public List<ProjectTO> getProjects(){
        return service.getProjects();
    }

    @GetMapping("/projectByID/{projectCode}")
    public ProjectTO findProjectById(@PathVariable int projectCode){
        return service.getProjectById(projectCode);
    }

    @GetMapping("/project/{projectName}")
    public ProjectTO findProjectByName(@PathVariable String projectName){
        return service.getProjectByName(projectName);
    }
    @PostMapping("createProject")
    public void createProject(@RequestBody ProjectTO project){
        service.createProject(project);
    }

    @PutMapping("/updateProject")
    public ProjectTO updateProject(@RequestBody ProjectTO project){
        return service.updateProject(project);
    }

    @DeleteMapping("/deleteProject/{projectCode}")
    public String deleteProject(@PathVariable int projectCode){
        return service.deleteProject(projectCode);
    }
}
