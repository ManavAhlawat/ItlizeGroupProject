package com.Project1.ItlizeGroupProject.Controller;

import com.Project1.ItlizeGroupProject.Service.ResourceService;
import com.Project1.ItlizeGroupProject.TO.ResourceTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ResourceController {

    @Autowired
    private ResourceService service;

    @GetMapping("/resources")
    public List<ResourceTO> getResources(){
        return service.getResources();
    }
    @PostMapping("/createResource")
    public ResourceTO createResource(@RequestBody ResourceTO resource){
        return service.createResource(resource);
    }
    @GetMapping("/resourceByID/{resourceCode}")
    public ResourceTO findResourceById(@PathVariable int resourceCode){
        return service.getResourceById(resourceCode);
    }

    @GetMapping("/resource/{resourceName}")
    public ResourceTO findResourceByName(@PathVariable String resourceName){
        return service.getResourceByName(resourceName);
    }

    @PutMapping("/updateResource")
    public ResourceTO updateResource(@RequestBody ResourceTO resource){
        return service.updateResource(resource);
    }

    @DeleteMapping("/deleteResource/{resourceCode}")
    public String deleteResource(@PathVariable int resourceCode){
        return service.deleteResource(resourceCode);
    }

}
