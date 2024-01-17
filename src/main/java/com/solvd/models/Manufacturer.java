package com.solvd.models;

import com.fasterxml.jackson.annotation.JsonProperty;
import javax.xml.bind.annotation.*;

@XmlRootElement(name = "manufacturer")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(propOrder = {"id", "manufacturerName"})
public class Manufacturer {

    @XmlAttribute(name = "id")
    @JsonProperty("id")
    private final int id;
    @XmlElement(name = "manufacturerName")
    @JsonProperty("manufacturerName")
    private final String manufacturerName;

    private Manufacturer(Builder builder) {
        this.id = builder.id;
        this.manufacturerName = builder.manufacturerName;
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

    public static class Builder {
        private int id;
        private String manufacturerName;

        public Builder setId(int id) {
            this.id = id;
            return this;
        }

        public Builder setManufacturerName(String manufacturerName) {
            this.manufacturerName = manufacturerName;
            return this;
        }

        public Manufacturer build() {
            return new Manufacturer(this);
        }
    }
}

