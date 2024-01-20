package com.solvd.jbdc.dao;

import com.solvd.models.Employee;
import com.solvd.models.Position;
import com.solvd.util.ConnectionPool;
import com.solvd.interfaces.IEmployeeDAO;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class EmployeeDAO implements IEmployeeDAO {

    private final Logger LOGGER = LogManager.getLogger(EmployeeDAO.class);
    private ConnectionPool connectionPool = ConnectionPool.getInstance();

    public void saveEntity(Employee employee) {
        Connection connection = connectionPool.getConnection();
        String query = "INSERT INTO employees (id, first_name, last_name, position_id) VALUES ((?), (?), (?), (?))";
        try (PreparedStatement ps = connection.prepareStatement(query)) {
            ps.setInt(1, employee.getId());
            ps.setString(2, employee.getFirstName());
            ps.setString(3, employee.getLastName());
            ps.setInt(4, employee.getPosition().getId());
            ps.executeUpdate();
        } catch (SQLException e) {
            LOGGER.info("Error saving employee entity: ", e);
        } finally {
            if (connection != null) {
                try {
                    connectionPool.releaseConnection(connection);
                } catch (SQLException e) {
                    LOGGER.error("Error closing connection: ", e);
                }
            }
        }
    }

    @Override
    public List<Employee> getAll() {
        Connection connection = connectionPool.getConnection();
        String query = "SELECT * FROM employees";
        List<Employee> employees = new ArrayList<>();
        try (PreparedStatement ps = connection.prepareStatement(query)) {
            ps.executeQuery();
            try (ResultSet rs = ps.getResultSet()) {
                while (rs.next()) {
                    Position position = new Position.Builder()
                            .setId(rs.getInt("position_id"))
                            .build();
                    Employee employee = new Employee.Builder()
                            .setId(rs.getInt("id"))
                            .setFirstName(rs.getString("first_name"))
                            .setLastName(rs.getString("last_name"))
                            .setPosition(position)
                            .build();
                    employees.add(employee);
                }
            }
        } catch (SQLException e) {
            LOGGER.info("Error getting all employees: ", e);
        } finally {
            if (connection != null) {
                try {
                    connectionPool.releaseConnection(connection);
                } catch (SQLException e) {
                    LOGGER.error("Error closing connection: ", e);
                }
            }
        }
        return employees;
    }


    @Override
    public Employee getEntityById(int id) {
        Connection connection = connectionPool.getConnection();
        String query = "SELECT * FROM employees WHERE id = (?)";
        Employee employee = null;
        try (PreparedStatement ps = connection.prepareStatement(query)) {
            ps.setInt(1, id);
            ps.executeQuery();
            try (ResultSet rs = ps.getResultSet()) {
                while (rs.next()) {
                    Position position = new Position.Builder()
                            .setId(rs.getInt("position_id"))
                            .build();
                    employee = new Employee.Builder()
                            .setId(rs.getInt("id"))
                            .setFirstName(rs.getString("first_name"))
                            .setLastName(rs.getString("last_name"))
                            .setPosition(position)
                            .build();
                }
            }
        } catch (SQLException e) {
            LOGGER.info("Error getting employee entity by ID: ", e);
        } finally {
            if (connection != null) {
                try {
                    connectionPool.releaseConnection((connection));
                } catch (SQLException e) {
                    LOGGER.info("Error closing connection: ", e);
                }
            }
        }
        return employee;
    }

    @Override
    public void updateEntity(Employee employee) {
        Connection connection = connectionPool.getConnection();
        String query = "UPDATE employees SET first_name = (?), last_name = (?), position_id = (?) WHERE id = (?)";
        try (PreparedStatement ps = connection.prepareStatement(query)) {
            ps.setString(1, employee.getFirstName());
            ps.setString(2, employee.getLastName());
            ps.setInt(3, employee.getPosition().getId());
            ps.setInt(4, employee.getId());
            ps.executeUpdate();
        } catch (SQLException e) {
            LOGGER.error("Error updating employee entity: ", e);
        } finally {
            if (connection != null) {
                try {
                    connectionPool.releaseConnection(connection);
                } catch (SQLException e) {
                    LOGGER.error("Error releasing connection: ", e);
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
            ps.executeUpdate();
        } catch (SQLException e) {
            LOGGER.info("Error removing employee: ", e);
        } finally {
            if (connection != null) {
                try {
                    connectionPool.releaseConnection(connection);
                } catch (SQLException e) {
                    LOGGER.info("Error releasing connection: ", e);
                }
            }
        }
    }

    @Override
    public List<Employee> getEmployeeByLastName(String lastName) {
        List<Employee> employees = new ArrayList<>();
        Connection connection = connectionPool.getConnection();
        String query = "SELECT * FROM employees WHERE last_name = ?";
        try (PreparedStatement ps = connection.prepareStatement(query)) {
            ps.setString(1, lastName);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Position position = new Position.Builder()
                        .setId(rs.getInt("position_id"))
                        .build();
                Employee employee = new Employee.Builder()
                        .setId(rs.getInt("id"))
                        .setFirstName(rs.getString("first_name"))
                        .setLastName(rs.getString("last_name"))
                        .setPosition(position)
                        .build();
                employees.add(employee);
            }
        } catch (SQLException e) {
            LOGGER.info("Error retrieving employees by last name: ", e);
        } finally {
            if (connection != null) {
                try {
                    connectionPool.releaseConnection(connection);
                } catch (SQLException e) {
                    LOGGER.info("Error releasing connection: ", e);
                }
            }
        }
        return employees;
    }
}
