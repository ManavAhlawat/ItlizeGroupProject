package com.Project1.ItlizeGroupProject.Controller;

import com.Project1.ItlizeGroupProject.Entity.Project;
import com.Project1.ItlizeGroupProject.Entity.Resource;
import com.Project1.ItlizeGroupProject.Service.ResourceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ResourceController {

    @Autowired
    private ResourceService service;

    @GetMapping("/resources")
    public List<Resource> getResources(){
        return service.getResources();
    }

    @GetMapping("/resourceByID/{resourceCode}")
    public Resource findResourceById(@PathVariable int resourceCode){
        return service.getResourceById(resourceCode);
    }

    @GetMapping("/resource/{resourceName}")
    public Resource findResourceByName(@PathVariable String resourceName){
        return service.getResourceByName(resourceName);
    }

    @PutMapping("/updateResource")
    public Resource updateResource(@RequestBody Resource resource){
        return service.updateResource(resource);
    }

    @DeleteMapping("/deleteResource/{resourceCode}")
    public String deleteResource(@PathVariable int resourceCode){
        return service.deleteResource(resourceCode);
    }

}
