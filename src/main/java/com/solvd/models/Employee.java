package com.solvd.models;

import com.fasterxml.jackson.annotation.JsonProperty;
import javax.xml.bind.annotation.*;

@XmlRootElement(name = "employee")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(propOrder = {"id", "firstName", "lastName", "position"})
public class Employee {

    @XmlAttribute(name = "id")
    @JsonProperty("id")
    private final int id;
    @XmlElement(name = "firstName")
    @JsonProperty("firstName")
    private final String firstName;
    @XmlElement(name = "lastName")
    @JsonProperty("lastName")
    private final String lastName;
    @XmlElement(name = "position", type = Position.class)
    @JsonProperty("position")
    private final Position position;

    private Employee(Builder builder) {
        this.id = builder.id;
        this.firstName = builder.firstName;
        this.lastName = builder.lastName;
        this.position = builder.position;
    }

    public int getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public Position getPosition() {
        return position;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", position=" + position +
                '}';
    }

    public static class Builder {
        private int id;
        private String firstName;
        private String lastName;
        private Position position;

        public Builder setId(int id) {
            this.id = id;
            return this;
        }

        public Builder setFirstName(String firstName) {
            this.firstName = firstName;
            return this;
        }

        public Builder setLastName(String lastName) {
            this.lastName = lastName;
            return this;
        }

        public Builder setPosition(Position position) {
            this.position = position;
            return this;
        }

        public Employee build() {
            return new Employee(this);
        }
    }
}
