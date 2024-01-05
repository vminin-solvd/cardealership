package com.solvd.models;

public class CarSale {
    private int id;
    private int customerId;
    private int employeeId;
    private int carId;

    public CarSale(int id, int customerId, int employeeId, int carId) {
        this.id = id;
        this.customerId = customerId;
        this.employeeId = employeeId;
        this.carId = carId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getCustomerId() {
        return customerId;
    }

    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }

    public int getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(int employeeId) {
        this.employeeId = employeeId;
    }

    public int getCarId() {
        return carId;
    }

    public void setCarId(int carId) {
        this.carId = carId;
    }

    @Override
    public String toString() {
        return "CarSale{" +
                "id=" + id +
                ", customerId=" + customerId +
                ", employeeId=" + employeeId +
                ", carId=" + carId +
                '}';
    }
}
