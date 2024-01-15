package com.solvd.models;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.xml.bind.annotation.*;

@XmlRootElement(name = "car")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(propOrder = {"id", "price", "model", "year", "isSold", "carType", "manufacturer"})
public class Car {

    @XmlAttribute(name = "id")
    @JsonProperty("id")
    private int id;
    @XmlElement(name = "price")
    @JsonProperty("price")
    private int price;
    @XmlElement(name = "model")
    @JsonProperty("model")
    private String model;
    @XmlElement(name = "year")
    @JsonProperty("year")
    private String year;
    @XmlElement(name = "isSold")
    @JsonProperty("isSold")
    private boolean isSold;
    @XmlElement(name = "carType", type = CarType.class)
    @JsonProperty("carType")
    private CarType carType;
    @XmlElement(name = "manufacturer", type = Manufacturer.class)
    @JsonProperty("manufacturer")
    private Manufacturer manufacturer;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public boolean isSold() {
        return isSold;
    }

    @JsonProperty("isSold")
    public void setSold(boolean sold) {
        isSold = sold;
    }

    public CarType getCarType() {
        return carType;
    }

    public void setCarType(CarType carType) {
        this.carType = carType;
    }

    public Manufacturer getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(Manufacturer manufacturer) {
        this.manufacturer = manufacturer;
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
}
