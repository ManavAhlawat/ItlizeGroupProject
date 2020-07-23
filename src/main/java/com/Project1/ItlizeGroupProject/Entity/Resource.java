package com.Project1.ItlizeGroupProject.Entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="resource")
public class Resource {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    @Column(name = "ResourceCode")
    private int resourceCode;

    @Column(name = "ResourceName")
    private String resourceName;

    public Resource() {
    }

    public int getResourceCode() {
        return resourceCode;
    }

    public String getResourceName() {
        return resourceName;
    }

    public void setResourceCode(int resourceCode) {
        this.resourceCode = resourceCode;
    }

    public void setResourceName(String resourceName) {
        this.resourceName = resourceName;
    }
}