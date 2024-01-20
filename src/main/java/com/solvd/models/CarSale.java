package com.solvd.models;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.xml.bind.annotation.*;

@XmlRootElement(name = "carSale")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(propOrder = {"id", "customer", "employee", "car"})
public class CarSale {

    @XmlAttribute(name = "id")
    @JsonProperty("id")
    private final int id;
    @XmlElement(name = "customer", type = Customer.class)
    @JsonProperty("customer")
    private final Customer customer;
    @XmlElement(name = "employee", type = Employee.class)
    @JsonProperty("employee")
    private final Employee employee;
    @XmlElement(name = "car", type = Car.class)
    @JsonProperty("car")
    private final Car car;

    private CarSale(Builder builder) {
        this.id = builder.id;
        this.customer = builder.customer;
        this.employee = builder.employee;
        this.car = builder.car;
    }

    public int getId() {
        return id;
    }

    public Customer getCustomer() {
        return customer;
    }

    public Employee getEmployee() {
        return employee;
    }

    public Car getCar() {
        return car;
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

    public static class Builder {
        private int id;
        private Customer customer;
        private Employee employee;
        private Car car;

        public Builder setId(int id) {
            this.id = id;
            return this;
        }

        public Builder setCustomer(Customer customer) {
            this.customer = customer;
            return this;
        }

        public Builder setEmployee(Employee employee) {
            this.employee = employee;
            return this;
        }

        public Builder setCar(Car car) {
            this.car = car;
            return this;
        }

        public CarSale build() {
            return new CarSale(this);
        }
    }
}