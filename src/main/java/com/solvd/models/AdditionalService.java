package com.solvd.models;

public class AdditionalService {

    private int id;
    private ServiceType serviceType;
    private String serviceName;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public ServiceType getServiceType() {
        return serviceType;
    }

    public void setServiceType(ServiceType serviceType) {
        this.serviceType = serviceType;
    }

    public String getServiceName() {
        return serviceName;
    }

    public void setServiceName(String serviceName) {
        this.serviceName = serviceName;
    }

    @Override
    public String toString() {
        return "AdditionalService{" +
                "id=" + id +
                ", serviceType=" + serviceType +
                ", serviceName='" + serviceName + '\'' +
                '}';
    }
}
