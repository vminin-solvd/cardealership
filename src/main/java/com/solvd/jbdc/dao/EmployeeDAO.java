package com.solvd.jbdc.dao;

import com.solvd.models.Employee;
import com.solvd.util.ConnectionPool;
import com.solvd.interfaces.iEmployeeDAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class EmployeeDAO implements iEmployeeDAO {
    private ConnectionPool connectionPool = ConnectionPool.getInstance();

    public void saveEntity(Employee employee) {
        Connection connection = connectionPool.getConnection();
        String query = "INSERT INTO employees (id, first_name, last_name) VALUES ((?), (?), (?))";
        try (PreparedStatement ps = connection.prepareStatement(query)) {
            ps.setInt(1, employee.getId());
            ps.setString(2, employee.getFirstName());
            ps.setString(3, employee.getLastName());

        } catch (SQLException e) {
            System.out.println(e); // FIXME Replace with LOGGER
        } finally {
            if (connection != null) {
                try {
                    connectionPool.releaseConnection(connection);
                } catch (SQLException e) {
                    System.out.println(e); // FIXME Replace with LOGGER
                }
            }
        }
    }

    @Override
    public List<Employee> getAll(){
        Connection connection = connectionPool.getConnection();
        String query = "SELECT * FROM employees";
        List<Employee> Employees = new ArrayList<>();
        try (PreparedStatement ps = connection.prepareStatement(query)) {
            ps.execute();
            try (ResultSet rs = ps.getResultSet()) {
                while (rs.next()) {
                    Employee employee = new Employee();
                    employee.setId(rs.getInt("id"));
                    employee.setFirstName(rs.getString("first_name"));// FIXME
                    employee.setLastName(rs.getString("last_name"));// FIXME
                    Employees.add(employee);
                }
            }
        } catch (SQLException e) {
            System.out.println(e); // FIXME Replace with LOGGER
        } finally {
            if( connection != null) {
                try {
                    connectionPool.releaseConnection(connection);
                } catch (SQLException e) {
                    System.out.println(); // FIXME Replace with LOGGER
                }
            }
        }
        return Employees;
    }


    @Override
    public Employee getEntityById(int id) {
        Connection connection = connectionPool.getConnection();
        String query = "SELECT * FROM employees WHERE id = (?)";
        Employee employee = new Employee();
        try (PreparedStatement ps = connection.prepareStatement(query)) {
            ps.setInt(1, id);
            ps.execute();
            try (ResultSet rs = ps.getResultSet()) {
                while (rs.next()) {
                    employee.setId(rs.getInt("id"));
                    employee.setFirstName((rs.getString("first_name")));
                    employee.setLastName((rs.getString("last_name")));
                }
            }
        } catch (SQLException e) {
            System.out.println(e); // FIXME Replace with LOGGER
        } finally {
            if (connection != null) {
                try {
                    connectionPool.releaseConnection((connection));
                } catch (SQLException e) {
                    System.out.println(e); // FIXME Replace with LOGGER
                }
            }
        }


        return employee;
    }

    @Override
    public void updateEntity(Employee employee) {
        Connection connection = connectionPool.getConnection();
        String query = "UPDATE employees SET first_name = (?) AND last_name = (?) WHERE id = (?)"; // FIXME MUST UPDATE LASTNAME ALSO
        try (PreparedStatement ps = connection.prepareStatement(query)) {
            ps.setString(1, employee.getFirstName());
            ps.setString(2, employee.getLastName());
            ps.setInt(3, employee.getId());
        } catch (SQLException e) {
            System.out.println(e); // FIXME Replace with LOGGER
        } finally {
            if (connection != null) {
                try {
                    connectionPool.releaseConnection(connection);
                } catch (SQLException e) {
                    System.out.println(e); // FIXME Replace with LOGGER
                }
            }
        }
    }

    @Override
    public void removeEntityById(int id) {
        Connection connection = connectionPool.getConnection();
        String query = "DELETE FROM employees WHERE id = (?)";
        try (PreparedStatement ps = connection.prepareStatement(query)) {
            ps.setInt(1, id);
            ps.execute();
        } catch (SQLException e) {
            System.out.println(e); // FIXME Replace with LOGGER
        } finally {
            if (connection != null) {
                try {
                    connectionPool.releaseConnection(connection);
                } catch (SQLException e) {
                    System.out.println(e); // FIXME Replace with LOGGER
                }
            }
        }
    }
    @Override
    public Employee getEmployeeByLastName(String lastName) {
        return null;
    }
}
