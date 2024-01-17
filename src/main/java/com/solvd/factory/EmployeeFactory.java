package com.solvd.factory;

import com.solvd.models.Employee;
import com.solvd.models.Position;

public class EmployeeFactory {

    public static Employee createEmployee(int id, String firstName, String lastName, Position position) {
        return new Employee.Builder()
                .setId(id)
                .setFirstName(firstName)
                .setLastName(lastName)
                .setPosition(position)
                .build();
    }
}
