package com.solvd.models;

import java.sql.Date;

public class TestDrive {
    private int id;
    private Date date;// (DATETIME)
    private int carId;
    private int customerId;
    private int employeeId;

    public TestDrive() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public int getCarId() {
        return carId;
    }

    public void setCarId(int carId) {
        this.carId = carId;
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

    @Override
    public String toString() {
        return "TestDrive{" +
                "id=" + id +
                ", date=" + date +
                ", carId=" + carId +
                ", customerId=" + customerId +
                ", employeeId=" + employeeId +
                '}';
    }
}
