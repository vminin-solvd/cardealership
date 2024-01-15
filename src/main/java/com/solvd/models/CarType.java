package com.solvd.models;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.xml.bind.annotation.*;

@XmlRootElement(name = "carType")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(propOrder = {"id", "carType"})
public class CarType {

    @XmlAttribute(name = "id")
    @JsonProperty("id")
    private int id;
    @XmlElement(name = "carType")
    @JsonProperty("carType")
    private String carType;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCarType() {
        return carType;
    }

    public void setCarType(String carType) {
        this.carType = carType;
    }

    @Override
    public String toString() {
        return "CarType{" +
                "id=" + id +
                ", carType='" + carType + '\'' +
                '}';
    }
}
