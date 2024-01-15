package com.solvd.models;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.xml.bind.annotation.*;

@XmlRootElement(name = "additionalService")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(propOrder = {"id", "serviceType", "serviceName"})
public class AdditionalService {

    @XmlAttribute(name = "id")
    @JsonProperty("id")
    private int id;
    @XmlElement(name = "serviceType", type = ServiceType.class)
    @JsonProperty("serviceType")
    private ServiceType serviceType;
    @XmlElement(name = "serviceName")
    @JsonProperty("serviceName")
    private String serviceName;

    public int getId() {
        return id;
    }

    @XmlAttribute(name = "id")
    public void setId(int id) {
        this.id = id;
    }

    public ServiceType getServiceType() {
        return serviceType;
    }

    @XmlElement(name = "serviceType", type = ServiceType.class)
    public void setServiceType(ServiceType serviceType) {
        this.serviceType = serviceType;
    }

    public String getServiceName() {
        return serviceName;
    }

    @XmlElement(name = "serviceName")
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
