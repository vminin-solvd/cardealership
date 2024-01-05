package com.solvd.models;

public class Car {
    private int id;
    private int price;
    private String model;
    private String year; // what type should this be? YEAR?
    private boolean isSold;
    private int carTypeId;
    private int manufacturerId;

    public Car(int id, int price, String model, String year, boolean isSold, int carTypeId, int manufacturerId) {
        this.id = id;
        this.price = price;
        this.model = model;
        this.year = year;
        this.isSold = isSold;
        this.carTypeId = carTypeId;
        this.manufacturerId = manufacturerId;
    }

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

    public void setSold(boolean sold) {
        isSold = sold;
    }

    public int getCarTypeId() {
        return carTypeId;
    }

    public void setCarTypeId(int carTypeId) {
        this.carTypeId = carTypeId;
    }

    public int getManufacturerId() {
        return manufacturerId;
    }

    public void setManufacturerId(int manufacturerId) {
        this.manufacturerId = manufacturerId;
    }

    @Override
    public String toString() {
        return "Car{" +
                "id=" + id +
                ", price=" + price +
                ", model='" + model + '\'' +
                ", year='" + year + '\'' +
                ", isSold=" + isSold +
                ", carTypeId=" + carTypeId +
                ", manufacturerId=" + manufacturerId +
                '}';
    }
}
