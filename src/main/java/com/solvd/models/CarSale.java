package com.solvd.models;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.xml.bind.annotation.*;

@XmlRootElement(name = "carSale")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(propOrder = {"id", "customer", "employee", "car"})
public class CarSale {

    @XmlAttribute(name = "id")
    @JsonProperty("id")
    private int id;
    @XmlElement(name = "customer", type = Customer.class)
    @JsonProperty("customer")
    private Customer customer;
    @XmlElement(name = "employee", type = Employee.class)
    @JsonProperty("employee")
    private Employee employee;
    @XmlElement(name = "car", type = Car.class)
    @JsonProperty("car")
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
