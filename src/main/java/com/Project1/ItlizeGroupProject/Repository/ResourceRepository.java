package com.Project1.ItlizeGroupProject.Repository;

import com.Project1.ItlizeGroupProject.Entity.Resource;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ResourceRepository extends JpaRepository<Resource, Integer> {

    Resource findByResourceName(String resourceName);
}
