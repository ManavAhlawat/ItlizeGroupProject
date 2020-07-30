package com.Project1.ItlizeGroupProject.Service;

import com.Project1.ItlizeGroupProject.Entity.Resource;
import com.Project1.ItlizeGroupProject.Repository.ResourceRepository;
import com.Project1.ItlizeGroupProject.TO.ResourceTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ResourceService {

    @Autowired
    private ResourceRepository resourceRepository;

    public List<ResourceTO> getResources(){
        List<ResourceTO> resourceTOList = new ArrayList<>();
        for(Resource r : resourceRepository.findAll()){
            resourceTOList.add(createResourceTO(r));
        }
        return resourceTOList;
    }

    public ResourceTO getResourceById(int resourceCode){
        return createResourceTO(resourceRepository.findById(resourceCode).orElse(null));
    }

    public ResourceTO getResourceByName(String resourceName){
        return createResourceTO(resourceRepository.findByResourceName(resourceName));
    }

    public String deleteResource(int resourceCode){
        resourceRepository.deleteById(resourceCode);
        return "Resource removed: " + resourceCode;
    }

    public ResourceTO updateResource(ResourceTO resource){
        Resource existingResource = resourceRepository.findById(resource.getResourceCode()).orElse(null);
        existingResource.setResourceName(resource.getResourceName());

        return createResourceTO(resourceRepository.save(existingResource));
    }
    public ResourceTO createResource(ResourceTO resource){
        return createResourceTO(resourceRepository.save(createResourceEntity(resource)));
    }

    public static ResourceTO createResourceTO(Resource resource){
        ResourceTO resourceTO = new ResourceTO();
        resourceTO.setResourceName(resource.getResourceName());
        resourceTO.setResourceCode(resource.getResourceCode());
        return resourceTO;
    }

    public static Resource createResourceEntity(ResourceTO resourceTO){
        Resource resource = new Resource();
        resource.setResourceName(resourceTO.getResourceName());
        resource.setResourceCode(resourceTO.getResourceCode());
        return resource;
    }
}
