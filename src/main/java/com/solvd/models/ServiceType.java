package com.solvd.models;

public class ServiceType {
    private int id;
    private String serviceType;

    public ServiceType() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getServiceType() {
        return serviceType;
    }

    public void setServiceType(String serviceType) {
        this.serviceType = serviceType;
    }

    @Override
    public String toString() {
        return "ServiceType{" +
                "id=" + id +
                ", serviceType='" + serviceType + '\'' +
                '}';
    }
}
