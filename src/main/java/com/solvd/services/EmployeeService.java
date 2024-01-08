package com.solvd.services;

import com.solvd.interfaces.IEmployeeDAO;
import com.solvd.jbdc.dao.EmployeeDAO;
import com.solvd.models.Employee;

import java.util.List;

public class EmployeeService implements IEmployeeDAO {

    EmployeeDAO employeeDAO = new EmployeeDAO();

    @Override
    public void saveEntity(Employee employee) {
        employeeDAO.saveEntity(employee);
    }

    @Override
    public Employee getEntityById(int id) {
        return employeeDAO.getEntityById(id);
    }

    @Override
    public void updateEntity(Employee employee) {
        employeeDAO.updateEntity(employee);
    }

    @Override
    public void removeEntityById(int id) {
        employeeDAO.removeEntityById(id);
    }

    @Override
    public List<Employee> getAll() {
        return employeeDAO.getAll();
    }

    @Override
    public List<Employee> getEmployeeByLastName(String lastName) {
        return employeeDAO.getEmployeeByLastName(lastName);
    }
}
