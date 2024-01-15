package com.solvd.models;

import com.solvd.parser.jaxb.DateAdapter;

import javax.xml.bind.annotation.*;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
import java.sql.Date;

@XmlRootElement(name = "testDrive")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(propOrder = {"id", "date", "car", "customer", "employee"})
public class TestDrive {

    @XmlAttribute(name = "id")
    private int id;
    @XmlJavaTypeAdapter(DateAdapter.class)
    @XmlElement(name = "date")
    private Date date;
    @XmlElement(name = "car", type = Car.class)
    private Car car;
    @XmlElement(name = "customer", type = Customer.class)
    private Customer customer;
    @XmlElement(name = "employee", type = Employee.class)
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
