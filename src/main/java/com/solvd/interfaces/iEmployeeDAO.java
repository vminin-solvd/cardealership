package com.solvd.interfaces;

import com.solvd.models.Employee;

public interface iEmployeeDAO extends IBaseDAO<Employee> {
Employee getEmployeeByLastName(String lastName);
}
