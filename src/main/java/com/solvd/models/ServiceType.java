package com.solvd.models;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.xml.bind.annotation.*;

@XmlRootElement(name = "serviceType")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(propOrder = {"id", "serviceType"})
public class ServiceType {

    @XmlAttribute(name = "id")
    @JsonProperty("id")
    private int id;
    @XmlElement(name = "serviceType")
    @JsonProperty("serviceType")
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
