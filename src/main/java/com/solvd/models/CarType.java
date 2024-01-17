package com.solvd.models;

import com.fasterxml.jackson.annotation.JsonProperty;
import javax.xml.bind.annotation.*;

@XmlRootElement(name = "carType")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(propOrder = {"id", "carType"})
public class CarType {

    @XmlAttribute(name = "id")
    @JsonProperty("id")
    private final int id;
    @XmlElement(name = "carType")
    @JsonProperty("carType")
    private final String carType;

    private CarType(Builder builder) {
        this.id = builder.id;
        this.carType = builder.carType;
    }

    public int getId() {
        return id;
    }

    public String getCarType() {
        return carType;
    }

    @Override
    public String toString() {
        return "CarType{" +
                "id=" + id +
                ", carType='" + carType + '\'' +
                '}';
    }

    public static class Builder {
        private int id;
        private String carType;

        public Builder setId(int id) {
            this.id = id;
            return this;
        }

        public Builder setCarType(String carType) {
            this.carType = carType;
            return this;
        }

        public CarType build() {
            return new CarType(this);
        }
    }
}
