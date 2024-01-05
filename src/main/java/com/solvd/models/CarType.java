package com.solvd.models;

public class CarType {
    private int id;
    private String carType;

    public CarType() {
    }

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
