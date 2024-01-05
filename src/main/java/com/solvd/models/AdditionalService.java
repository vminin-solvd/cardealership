package com.solvd.models;

public class AdditionalService {
private int id;
private String serviceType;

public AdditionalService() {
    this.id = id;
    this.serviceType = serviceType;
}

public void setId(int id) {
    this.id = id;
}

public void setServiceType(String serviceType) {
    this.serviceType = serviceType;
}

public int getId() {
    return id;
}

public String getServiceType() {
    return serviceType;
}

    @Override
    public String toString() {
        return "AdditionalService{" +
                "id=" + id +
                ", serviceType='" + serviceType + '\'' +
                '}';
    }
}
