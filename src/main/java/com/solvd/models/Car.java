package com.solvd.models;

import com.fasterxml.jackson.annotation.JsonProperty;
import javax.xml.bind.annotation.*;

@XmlRootElement(name = "car")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(propOrder = {"id", "price", "model", "year", "isSold", "carType", "manufacturer"})
public class Car {

    @XmlAttribute(name = "id")
    @JsonProperty("id")
    private final int id;
    @XmlElement(name = "price")
    @JsonProperty("price")
    private final int price;
    @XmlElement(name = "model")
    @JsonProperty("model")
    private final String model;
    @XmlElement(name = "year")
    @JsonProperty("year")
    private final String year;
    @XmlElement(name = "isSold")
    @JsonProperty("isSold")
    private final boolean isSold;
    @XmlElement(name = "carType", type = CarType.class)
    @JsonProperty("carType")
    private final CarType carType;
    @XmlElement(name = "manufacturer", type = Manufacturer.class)
    @JsonProperty("manufacturer")
    private final Manufacturer manufacturer;

    private Car(Builder builder) {
        this.id = builder.id;
        this.price = builder.price;
        this.model = builder.model;
        this.year = builder.year;
        this.isSold = builder.isSold;
        this.carType = builder.carType;
        this.manufacturer = builder.manufacturer;
    }

    public CarType getCarType() {
        return carType;
    }

    public Manufacturer getManufacturer() {
        return manufacturer;
    }

    public int getId() {
        return id;
    }

    public int getPrice() {
        return price;
    }

    public String getModel() {
        return model;
    }

    public String getYear() {
        return year;
    }

    public boolean isSold() {
        return isSold;
    }

    @Override
    public String toString() {
        return "Car{" +
                "id=" + id +
                ", price=" + price +
                ", model='" + model + '\'' +
                ", year='" + year + '\'' +
                ", isSold=" + isSold +
                ", carType=" + carType +
                ", manufacturer=" + manufacturer +
                '}';
    }

    public static class Builder {
        private int id;
        private int price;
        private String model;
        private String year;
        private boolean isSold;
        private CarType carType;
        private Manufacturer manufacturer;

        public Builder setId(int id) {
            this.id = id;
            return this;
        }

        public Builder setPrice(int price) {
            this.price = price;
            return this;
        }

        public Builder setModel(String model) {
            this.model = model;
            return this;
        }

        public Builder setYear(String year) {
            this.year = year;
            return this;
        }

        public Builder setIsSold(boolean isSold) {
            this.isSold = isSold;
            return this;
        }

        public Builder setCarType(CarType carType) {
            this.carType = carType;
            return this;
        }

        public Builder setManufacturer(Manufacturer manufacturer) {
            this.manufacturer = manufacturer;
            return this;
        }

        public Car build() {
            return new Car(this);
        }
    }
}
