package com.Project1.ItlizeGroupProject.TO;

public class ResourceTO {
    private int resourceCode;
    private String resourceName;

    public int getResourceCode() {
        return resourceCode;
    }

    public void setResourceCode(int resourceCode) {
        this.resourceCode = resourceCode;
    }

    public String getResourceName() {
        return resourceName;
    }

    public void setResourceName(String resourceName) {
        this.resourceName = resourceName;
    }

    @Override
    public String toString() {
        return "ResourceTO{" +
                "resourceCode=" + resourceCode +
                ", resourceName='" + resourceName + '\'' +
                '}';
    }
}
