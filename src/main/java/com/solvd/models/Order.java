package com.solvd.models;

public class Order {
private int id;
private int employeeId;
private int customerId;
private int carsId;

    public Order(int id, int employeeId, int customerId, int carsId) {
    this.id = id;
    this.employeeId = employeeId;
    this.customerId = customerId;
    this.carsId = carsId;
}

    public int getId() {
        return id;
    }

    public int getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(int employeeId) {
        this.employeeId = employeeId;
    }

    public int getCustomerId() {
        return customerId;
    }

    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }

    public int getCarsId() {
        return carsId;
    }

    public void setCarsId(int carsId) {
        this.carsId = carsId;
    }

    @Override
    public String toString() {
        return "Order{" +
                "id=" + id +
                ", employeeId=" + employeeId +
                ", customerId=" + customerId +
                ", carsId=" + carsId +
                '}';
    }
}
