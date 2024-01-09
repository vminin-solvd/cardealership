package com.solvd.models;

import java.sql.Date;

public class TestDrive {
    private int id;
    private Date date;
    private Car car;
    private Customer customer;
    private Employee employee;

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

    public Car getCar() {
        return car;
    }

    public void setCar(Car car) {
        this.car = car;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    @Override
    public String toString() {
        return "TestDrive{" +
                "id=" + id +
                ", date=" + date +
                ", car=" + car +
                ", customer=" + customer +
                ", employee=" + employee +
                '}';
    }
}
