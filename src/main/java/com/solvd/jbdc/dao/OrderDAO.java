package com.solvd.jbdc.dao;

import com.solvd.models.Order;
import com.solvd.models.Customer;
import com.solvd.models.Employee;
import com.solvd.models.Car;
import com.solvd.util.ConnectionPool;
import com.solvd.interfaces.IOrderDAO;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class OrderDAO implements IOrderDAO {

    private final Logger LOGGER = LogManager.getLogger(OrderDAO.class);
    private ConnectionPool connectionPool = ConnectionPool.getInstance();

    @Override
    public List<Order> getAll() {
        List<Order> orders = new ArrayList<>();
        Connection connection = connectionPool.getConnection();
        String query = "SELECT * FROM orders";
        try (PreparedStatement ps = connection.prepareStatement(query)) {
            ps.execute();
            try (ResultSet rs = ps.getResultSet()) {
                while (rs.next()) {
                    Order order = new Order();
                    order.setId(rs.getInt("id"));
                    Employee employee = new Employee();
                    employee.setId(rs.getInt("employee_id"));
                    order.setEmployee(employee);
                    Customer customer = new Customer();
                    customer.setId(rs.getInt("customer_id"));
                    order.setCustomer(customer);
                    Car car = new Car();
                    car.setId(rs.getInt("car_id"));
                    order.setCar(car);
                    orders.add(order);
                }
            }
        } catch (SQLException e) {
            LOGGER.error("Error retrieving all orders: ", e);
        } finally {
            if (connection != null) {
                try {
                    connectionPool.releaseConnection(connection);
                } catch (SQLException e) {
                    LOGGER.error("Error releasing connection: ", e);
                }
            }
        }
        return orders;
    }

    @Override
    public void saveEntity(Order order) {
        Connection connection = connectionPool.getConnection();
        String query = "INSERT INTO orders (employee_id, customer_id, car_id) VALUES (?, ?, ?)";
        try (PreparedStatement ps = connection.prepareStatement(query)) {
            ps.setInt(1, order.getEmployee().getId());
            ps.setInt(2, order.getCustomer().getId());
            ps.setInt(3, order.getCar().getId());
            ps.executeUpdate();
        } catch (SQLException e) {
            LOGGER.error("Error saving order: ", e);
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
        public Order getEntityById(int id) {
            Order order = null;
            Connection connection = connectionPool.getConnection();
            String query = "SELECT * FROM orders WHERE id = (?)";
            try (PreparedStatement ps = connection.prepareStatement(query)) {
                ps.setInt(1, id);
                ResultSet rs = ps.executeQuery();
                if (rs.next()) {
                    order = new Order();
                    order.setId(rs.getInt("id"));
                    order.setEmployee(new EmployeeDAO().getEntityById(rs.getInt("employee_id")));
                    order.setCustomer(new CustomerDAO().getEntityById(rs.getInt("customer_id")));
                    order.setCar(new CarDAO().getEntityById(rs.getInt("car_id")));
                }
            } catch (SQLException e) {
                LOGGER.error("Error retrieving order by ID: ", e);
            } finally {
                if (connection != null) {
                    try {
                        connectionPool.releaseConnection(connection);
                    } catch (SQLException e) {
                        LOGGER.error("Error releasing connection: ", e);
                    }
                }
            }
            return order;
        }

    @Override
    public void updateEntity(Order order) {
        Connection connection = connectionPool.getConnection();
        String query = "UPDATE orders SET employee_id = (?), customer_id = (?), car_id = (?) WHERE id = (?)";
        try (PreparedStatement ps = connection.prepareStatement(query)) {
            ps.setInt(1, order.getEmployee().getId());
            ps.setInt(2, order.getCustomer().getId());
            ps.setInt(3, order.getCar().getId());
            ps.setInt(4, order.getId());
            ps.executeUpdate();
        } catch (SQLException e) {
            LOGGER.error("Error updating order: ", e);
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
        String query = "DELETE FROM orders WHERE id = (?)";
        try (PreparedStatement ps = connection.prepareStatement(query)) {
            ps.setInt(1, id);
            ps.executeUpdate();
        } catch (SQLException e) {
            LOGGER.error("Error deleting order entity: ", e);
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
    public List<Order> getOrdersByEmployeeID(int employeeId) {
        List<Order> orders = new ArrayList<>();
        Connection connection = connectionPool.getConnection();
        String query = "SELECT * FROM orders WHERE employee_id = (?)";
        try (PreparedStatement ps = connection.prepareStatement(query)) {
            ps.setInt(1, employeeId);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Order order = new Order();
                order.setId(rs.getInt("id"));

                order.setEmployee(new EmployeeDAO().getEntityById(employeeId));
                order.setCustomer(new CustomerDAO().getEntityById(rs.getInt("customer_id")));
                order.setCar(new CarDAO().getEntityById(rs.getInt("car_id")));

                orders.add(order);
            }
        } catch (SQLException e) {
            LOGGER.error("Error retrieving orders by employee ID: ", e);
        } finally {
            if (connection != null) {
                try {
                    connectionPool.releaseConnection(connection);
                } catch (SQLException e) {
                    LOGGER.error("Error releasing connection: ", e);
                }
            }
        }
        return orders;
    }
}
