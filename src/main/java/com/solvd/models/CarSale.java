package com.solvd.models;

public class CarSale {
    private int id;
    private Customer customer;
    private Employee employee;
    private Car car;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public Car getCar() {
        return car;
    }

    public void setCar(Car car) {
        this.car = car;
    }

    @Override
    public String toString() {
        return "CarSale{" +
                "id=" + id +
                ", customer=" + customer +
                ", employee=" + employee +
                ", car=" + car +
                '}';
    }
}
