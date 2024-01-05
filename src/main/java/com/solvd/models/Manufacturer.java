package com.solvd.models;

public class Manufacturer {
    private int id;
    private String manufacturerName;

    public Manufacturer() {
    }

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
