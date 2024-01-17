package com.solvd.jbdc.dao;

import com.solvd.interfaces.IOrderHasAdditionalServicesDAO;
import com.solvd.models.AdditionalService;
import com.solvd.models.Order;
import com.solvd.models.OrderHasAdditionalService;
import com.solvd.util.ConnectionPool;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class OrderHasAdditionalServiceDAO implements IOrderHasAdditionalServicesDAO<OrderHasAdditionalService, AdditionalService> {

    private final Logger LOGGER = LogManager.getLogger(OrderHasAdditionalServiceDAO.class);
    private ConnectionPool connectionPool = ConnectionPool.getInstance();
    private OrderDAO orderDAO = new OrderDAO();
    private AdditionalServiceDAO additionalServiceDAO = new AdditionalServiceDAO();

    @Override
    public void saveEntity(OrderHasAdditionalService orderHasAdditionalService) {
        String query = "INSERT INTO orders_has_additional_services (order_id, additional_service_id) VALUES ((?), (?))";
        Connection connection = connectionPool.getConnection();
        try (PreparedStatement ps = connection.prepareStatement(query)) {
            ps.setInt(1, orderHasAdditionalService.getOrder().getId());
            ps.setInt(2, orderHasAdditionalService.getAdditionalService().getId());
            ps.executeUpdate();
        } catch (SQLException e) {
            LOGGER.info("Error saving order has additional service entity: ", e);
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
    public OrderHasAdditionalService getEntityById(int id) {
        String query = "SELECT * FROM orders_has_additional_services WHERE order_id = (?)";
        Connection connection = connectionPool.getConnection();
        OrderHasAdditionalService orderHasAdditionalService = null;
        try (PreparedStatement ps = connection.prepareStatement(query)) {
            ps.setInt(1, id);
            ps.executeQuery();
            try (ResultSet rs = ps.getResultSet()) {
                while (rs.next()) {
                    Order order = orderDAO.getEntityById(rs.getInt("order_id"));
                    AdditionalService additionalService = additionalServiceDAO.getEntityById(rs.getInt("additional_service_id"));
                    orderHasAdditionalService = new OrderHasAdditionalService();
                    orderHasAdditionalService.setOrder(order);
                    orderHasAdditionalService.setAdditionalService(additionalService);
<<<<<<< HEAD
=======

>>>>>>> 4090ae0d12fe9235a22700eb0bbffb25fe8ebc37
                }
            }
        } catch (SQLException e) {
            LOGGER.info("Error getting order has additional service entity: ", e);
        } finally {
            if (connection != null) {
                try {
                    connectionPool.releaseConnection(connection);
                } catch (SQLException e) {
                    LOGGER.info("Error releasing connection: ", e);
                }
            }
        }
        return orderHasAdditionalService;
    }

    @Override
    public void updateEntity(OrderHasAdditionalService orderHasAdditionalService) {
        String query = "UPDATE orders_has_additional_services SET additional_service_id = (?) WHERE order_id = (?)";
        Connection connection = connectionPool.getConnection();
        try (PreparedStatement ps = connection.prepareStatement(query)) {
            ps.setInt(1, orderHasAdditionalService.getOrder().getId());
            ps.setInt(2, orderHasAdditionalService.getAdditionalService().getId());
            ps.executeUpdate();
        } catch (SQLException e) {
            LOGGER.info("Error updating order has additional service entity: ", e);
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
        String query = "DELETE FROM orders_has_additional_services WHERE order_id = ?";
        Connection connection = connectionPool.getConnection();
        try (PreparedStatement ps = connection.prepareStatement(query)) {
            ps.setInt(1, id);
            int rowsAffected = ps.executeUpdate();
            if (rowsAffected < 1) {
                LOGGER.info("No Order Has Additional Service entity found with order_id: " + id);
            }
        } catch (SQLException e) {
            LOGGER.error("Error removing Order Has Additional Service entity by order_id: ", e);
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
    public List<OrderHasAdditionalService> getAll() {
        String query = "SELECT * FROM orders_has_additional_service";
        Connection connection = connectionPool.getConnection();
        List<OrderHasAdditionalService> orderHasAdditionalServices = new ArrayList<>();
        try (PreparedStatement ps = connection.prepareStatement(query)) {
            ps.executeQuery();
            try (ResultSet rs = ps.getResultSet()) {
                while (rs.next()) {
                    Order order = orderDAO.getEntityById(rs.getInt("order_id"));
                    AdditionalService additionalService = additionalServiceDAO.getEntityById(rs.getInt("additional_service_id"));
                    OrderHasAdditionalService orderHasAdditionalService = new OrderHasAdditionalService();
                    orderHasAdditionalService.setOrder(order);
                    orderHasAdditionalService.setAdditionalService(additionalService);
                    orderHasAdditionalServices.add(orderHasAdditionalService);
                }
            }
        } catch (SQLException e) {
            LOGGER.info("Error getting order has additional service entity: ", e);
        } finally {
            if (connection != null) {
                try {
                    connectionPool.releaseConnection(connection);
                } catch (SQLException e) {
                    LOGGER.info("Error releasing connection: ", e);
                }
            }
        }
        return orderHasAdditionalServices;
    }

    @Override
    public List<AdditionalService> getAllServicesById(int id) {
        String query = "SELECT * FROM orders_has_additional_service WHERE order_id = (?)";
        Connection connection = connectionPool.getConnection();
        List<AdditionalService> additionalServices = new ArrayList<>();
        try (PreparedStatement ps = connection.prepareStatement(query)) {
            ps.setInt(1, id);
            ps.executeQuery();
            try (ResultSet rs = ps.getResultSet()) {
                while (rs.next()) {
                    AdditionalService additionalService = additionalServiceDAO.getEntityById(rs.getInt("additional_service_id"));
                    additionalServices.add(additionalService);
                }
            }
        } catch (SQLException e) {
            LOGGER.info("Error getting all services by ID: ", e);
        } finally {
            if (connection != null) {
                try {
                    connectionPool.releaseConnection(connection);
                } catch (SQLException e) {
                    LOGGER.info("Error releasing connection: ", e);
                }
            }
        }
        return additionalServices;
    }
}
