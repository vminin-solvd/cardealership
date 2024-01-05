package com.solvd.models;

public class Employee {
    private int id;
    private String firstName;
    private String lastName;
    private int positionId;

    public Employee() {
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setPositionId(int positionId) {
        this.positionId = positionId;
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

    public int getPositionId() {
        return positionId;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", positionId=" + positionId +
                '}';
    }
}
