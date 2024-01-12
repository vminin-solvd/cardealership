package com.solvd.models;

import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;

@XmlRootElement(name = "carSale")
@XmlType(propOrder = {"id", "customer", "employee", "car"})
public class CarSale {

    @XmlAttribute(name = "id")
    private int id;
    @XmlElement(name = "customer")
    private Customer customer;
    @XmlElement(name = "employee")
    private Employee employee;
    @XmlElement(name = "car")
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
