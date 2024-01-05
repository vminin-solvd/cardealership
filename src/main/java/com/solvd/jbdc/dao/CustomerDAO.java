package com.solvd.jbdc.dao;

import com.solvd.models.Customer;
import com.solvd.util.ConnectionPool;
import com.solvd.interfaces.iCustomerDAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CustomerDAO implements iCustomerDAO {
    private ConnectionPool connectionPool = ConnectionPool.getInstance();

    public void saveEntity(Customer customer) {
        Connection connection = connectionPool.getConnection();
        String query = "INSERT INTO customers (id, first_name, last_name) VALUES ((?), (?), (?))";
        try (PreparedStatement ps = connection.prepareStatement(query)) {
            ps.setInt(1, customer.getId());
            ps.setString(2, customer.getFirstName());
            ps.setString(3, customer.getLastName());
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
    public List<Customer> getAll(){
        Connection connection = connectionPool.getConnection();
        String query = "SELECT * FROM customers";
        List<Customer> Customers = new ArrayList<>();
        try (PreparedStatement ps = connection.prepareStatement(query)) {
            ps.execute();
            try (ResultSet rs = ps.getResultSet()) {
                while (rs.next()) {
                    Customer Customer = new Customer();
                    Customer.setId(rs.getInt("id"));
                    Customer.setFirstName(rs.getString("first_name"));// FIXME
                    Customer.setLastName(rs.getString("last_name"));// FIXME
                    Customers.add(Customer);
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
        return Customers;
    }


    @Override
    public Customer getEntityById(int id) {
        Connection connection = connectionPool.getConnection();
        String query = "SELECT * FROM customers WHERE id = (?)";
        Customer customer = new Customer();
        try (PreparedStatement ps = connection.prepareStatement(query)) {
            ps.setInt(1, id);
            ps.execute();
            try (ResultSet rs = ps.getResultSet()) {
                while (rs.next()) {
                    customer.setId(rs.getInt("id"));
                    customer.setFirstName(rs.getString("first_name"));// FIXME
                    customer.setLastName(rs.getString("last_name"));// FIXME
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


        return customer;
    }

    @Override
    public void updateEntity(Customer customer) {
        Connection connection = connectionPool.getConnection();
        String query = "UPDATE customers SET first_name = (?) AND last_name = (?) WHERE id = (?)"; // FIXME MUST UPDATE LASTNAME ALSO
        try (PreparedStatement ps = connection.prepareStatement(query)) {
            ps.setString(1, customer.getFirstName());
            ps.setString(2, customer.getLastName());
            ps.setInt(2, customer.getId());
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
        String query = "DELETE FROM customers WHERE id = (?)";
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
    public Customer getCustomerByFirstName(String firstName) {
        return null;
    }
}
