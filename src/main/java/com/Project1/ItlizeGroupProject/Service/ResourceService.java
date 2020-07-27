package com.Project1.ItlizeGroupProject.Service;

import com.Project1.ItlizeGroupProject.Entity.Project;
import com.Project1.ItlizeGroupProject.Entity.Resource;
import com.Project1.ItlizeGroupProject.Repository.ResourceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ResourceService {

    @Autowired
    private ResourceRepository resourceRepository;

    public List<Resource> getResources(){
        return resourceRepository.findAll();
    }

    public Resource getResourceById(int resourceCode){
        return resourceRepository.findById(resourceCode).orElse(null);
    }

    public Resource getResourceByName(String resourceName){
        return resourceRepository.findByResourceName(resourceName);
    }

    public String deleteResource(int resourceCode){
        resourceRepository.deleteById(resourceCode);
        return "Resource removed: " + resourceCode;
    }

    public Resource updateResource(Resource resource){
        Resource existingResource = resourceRepository.findById(resource.getResourceCode()).orElse(null);
        existingResource.setResourceName(resource.getResourceName());
        return resourceRepository.save(existingResource);
    }
}
