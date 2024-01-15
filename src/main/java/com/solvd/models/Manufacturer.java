package com.solvd.models;

import javax.xml.bind.annotation.*;

@XmlRootElement(name = "manufacturer")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(propOrder = {"id", "manufacturerName"})
public class Manufacturer {

    @XmlAttribute(name = "id")
    private int id;
    @XmlElement(name = "manufacturerName")
    private String manufacturerName;

    public Manufacturer() {}

    public void setId(int id) {
        this.id = id;
    }

    public void setManufacturerName(String manufacturerName) {
        this.manufacturerName = manufacturerName;
    }

    public int getId() {
        return id;
    }

    public String getManufacturerName() {
        return manufacturerName;
    }

    @Override
    public String toString() {
        return "Manufacturer{" +
                "id=" + id +
                ", manufacturerName='" + manufacturerName + '\'' +
                '}';
    }
}
