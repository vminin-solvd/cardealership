package com.solvd.models;

import javax.xml.bind.annotation.*;

@XmlRootElement(name = "order")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(propOrder = {"id", "employee", "customer", "car"})
public class Order {

    @XmlAttribute(name = "id")
    private int id;
    @XmlElement(name = "employee", type = Employee.class)
    private Employee employee;
    @XmlElement(name = "customer", type = Customer.class)
    private Customer customer;
    @XmlElement(name = "car", type = Car.class)
    private Car car;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public Car getCar() {
        return car;
    }

    public void setCar(Car car) {
        this.car = car;
    }

    @Override
    public String toString() {
        return "Order{" +
                "id=" + id +
                ", employee=" + employee +
                ", customer=" + customer +
                ", car=" + car +
                '}';
    }
}
