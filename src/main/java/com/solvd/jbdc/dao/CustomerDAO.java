package com.solvd.jbdc.dao;

import com.solvd.models.Customer;
import com.solvd.util.ConnectionPool;
import com.solvd.interfaces.ICustomerDAO;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CustomerDAO implements ICustomerDAO {

    private final Logger LOGGER = LogManager.getLogger(CustomerDAO.class);
    private ConnectionPool connectionPool = ConnectionPool.getInstance();

    public void saveEntity(Customer customer) {
        Connection connection = connectionPool.getConnection();
        String query = "INSERT INTO customers (id, first_name, last_name) VALUES ((?), (?), (?))";
        try (PreparedStatement ps = connection.prepareStatement(query)) {
            ps.setInt(1, customer.getId());
            ps.setString(2, customer.getFirstName());
            ps.setString(3, customer.getLastName());
            ps.executeUpdate();
        } catch (SQLException e) {
            LOGGER.info("Error saving customer entity: ", e);
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
    public List<Customer> getAll() {
        Connection connection = connectionPool.getConnection();
        String query = "SELECT * FROM customers";
        List<Customer> customers = new ArrayList<>();
        try (PreparedStatement ps = connection.prepareStatement(query)) {
            ps.executeQuery();
            try (ResultSet rs = ps.getResultSet()) {
                while (rs.next()) {
                    Customer customer = new Customer();
                    customer.setId(rs.getInt("id"));
                    customer.setFirstName(rs.getString("first_name"));
                    customer.setLastName(rs.getString("last_name"));
                    customers.add(customer);
                }
            }
        } catch (SQLException e) {
            LOGGER.info("Error getting all customer entities: ", e);
        } finally {
            if (connection != null) {
                try {
                    connectionPool.releaseConnection(connection);
                } catch (SQLException e) {
                    LOGGER.info("Error releasing connection: ", e);
                }
            }
        }
        return customers;
    }


    @Override
    public Customer getEntityById(int id) {
        Connection connection = connectionPool.getConnection();
        String query = "SELECT * FROM customers WHERE id = (?)";
        Customer customer = new Customer();
        try (PreparedStatement ps = connection.prepareStatement(query)) {
            ps.setInt(1, id);
            ps.executeQuery();
            try (ResultSet rs = ps.getResultSet()) {
                while (rs.next()) {
                    customer.setId(rs.getInt("id"));
                    customer.setFirstName(rs.getString("first_name"));
                    customer.setLastName(rs.getString("last_name"));
                }
            }
        } catch (SQLException e) {
            LOGGER.info("Error getting customer entity by ID: ", e);
        } finally {
            if (connection != null) {
                try {
                    connectionPool.releaseConnection((connection));
                } catch (SQLException e) {
                    LOGGER.info("Error releasing connection: ", e);
                }
            }
        }
        return customer;
    }

    @Override
    public void updateEntity(Customer customer) {
        Connection connection = connectionPool.getConnection();
        String query = "UPDATE customers SET first_name = (?), last_name = (?) WHERE id = (?)";
        try (PreparedStatement ps = connection.prepareStatement(query)) {
            ps.setString(1, customer.getFirstName());
            ps.setString(2, customer.getLastName());
            ps.setInt(3, customer.getId());
            ps.executeUpdate();
        } catch (SQLException e) {
            LOGGER.info("Error updating customer entity: ", e);
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
    public void removeEntityById(int id) {
        Connection connection = connectionPool.getConnection();
        String query = "DELETE FROM customers WHERE id = (?)";
        try (PreparedStatement ps = connection.prepareStatement(query)) {
            ps.setInt(1, id);
            ps.executeQuery();
        } catch (SQLException e) {
            LOGGER.info("Error removing customer entity by ID: ", e);
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
    public Customer getCustomerByFirstName(String firstName) {
        Connection connection = connectionPool.getConnection();
        String query = "SELECT FROM customers WHERE first_name = (?)";
        Customer customer = null;
        try (PreparedStatement ps = connection.prepareStatement(query)) {
            ps.setString(1, firstName);
            ps.executeQuery();
            try (ResultSet rs = ps.getResultSet()) {
                while (rs.next()) {
                    customer = new Customer();
                    customer.setId(rs.getInt("id"));
                    customer.setFirstName(rs.getString("first_name"));
                    customer.setLastName(rs.getString("last_name"));
                }
            }
        } catch (SQLException e) {
            LOGGER.info("Error getting customer entity by first name: ", e);
        } finally {
            if (connection != null) {
                try {
                    connectionPool.releaseConnection(connection);
                } catch (SQLException e) {
                    LOGGER.info("Error releasing connection: ", e);
                }
            }
        }
        return customer;
    }
}
