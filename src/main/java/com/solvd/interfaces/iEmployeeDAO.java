package com.solvd.interfaces;

import com.solvd.models.Employee;
import java.util.List;

public interface iEmployeeDAO extends IBaseDAO<Employee> {
List<Employee> getEmployeeByLastName(String lastName);
}
