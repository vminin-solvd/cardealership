package com.solvd.jbdc.dao;

import com.solvd.models.ServiceType;
import com.solvd.util.ConnectionPool;
import com.solvd.interfaces.IServiceTypeDAO;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ServiceTypeDAO implements IServiceTypeDAO {

    private final Logger LOGGER = LogManager.getLogger(ServiceTypeDAO.class);
    private ConnectionPool connectionPool = ConnectionPool.getInstance();

    public void saveEntity(ServiceType serviceType) {
        Connection connection = connectionPool.getConnection();
        String query = "INSERT INTO service_types (id, service_type) VALUES ((?), (?))";
        try (PreparedStatement ps = connection.prepareStatement(query)) {
            ps.setInt(1, serviceType.getId());
            ps.setString(2, serviceType.getServiceType());

        } catch (SQLException e) {
            LOGGER.info("Error saving service type entity: ", e);
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
    public List<ServiceType> getAll(){
        Connection connection = connectionPool.getConnection();
        String query = "SELECT * FROM service_types";
        List<ServiceType> serviceTypes = new ArrayList<>();
        try (PreparedStatement ps = connection.prepareStatement(query)) {
            ps.execute();
            try (ResultSet rs = ps.getResultSet()) {
                while (rs.next()) {
                    ServiceType serviceType = new ServiceType();
                    serviceType.setId(rs.getInt("id"));
                    serviceType.setServiceType(rs.getString("service_type"));
                    serviceTypes.add(serviceType);
                }
            }
        } catch (SQLException e) {
            LOGGER.info("Error getting all service type entities: ", e);
        } finally {
            if( connection != null) {
                try {
                    connectionPool.releaseConnection(connection);
                } catch (SQLException e) {
                    LOGGER.info("Error releasing connection: ", e);
                }
            }
        }
        return serviceTypes;
    }

    @Override
    public ServiceType getEntityById(int id) {
        Connection connection = connectionPool.getConnection();
        String query = "SELECT * FROM service_types WHERE id = (?)";
        ServiceType serviceType = new ServiceType();
        try (PreparedStatement ps = connection.prepareStatement(query)) {
            ps.setInt(1, id);
            ps.execute();
            try (ResultSet rs = ps.getResultSet()) {
                while (rs.next()) {
                    serviceType.setId(rs.getInt("id"));
                    serviceType.setServiceType((rs.getString("service_type")));
                }
            }
        } catch (SQLException e) {
            LOGGER.info("Error getting service type entity by ID: ", e);
        } finally {
            if (connection != null) {
                try {
                    connectionPool.releaseConnection((connection));
                } catch (SQLException e) {
                    LOGGER.info("Error releasing connection: ", e);
                }
            }
        }
        return serviceType;
    }

    @Override
    public void updateEntity(ServiceType serviceType) {
        Connection connection = connectionPool.getConnection();
        String query = "UPDATE service_types SET service_type = (?) WHERE id = (?)";
        try (PreparedStatement ps = connection.prepareStatement(query)) {
            ps.setString(1, serviceType.getServiceType());
            ps.setInt(2, serviceType.getId());
        } catch (SQLException e) {
            LOGGER.info("Error updating service type entity: ", e);
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
        String query = "DELETE FROM service_types WHERE id = (?)";
        try (PreparedStatement ps = connection.prepareStatement(query)) {
            ps.setInt(1, id);
            ps.execute();
        } catch (SQLException e) {
            LOGGER.info("Error removing service type entity by ID: ", e);
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
    public ServiceType getServiceTypeByName(String serviceTypeName) {
        Connection connection = connectionPool.getConnection();
        String query = "SELECT FROM service_types WHERE service_type = (?)";
        ServiceType serviceType = null;

        try (PreparedStatement ps = connection.prepareStatement(query)) {
            ps.setString(1, serviceTypeName);
            ps.execute();
            try (ResultSet rs = ps.getResultSet()) {
                while (rs.next()) {
                    serviceType.setId(rs.getInt("id"));
                    serviceType.setServiceType(rs.getString("service_type"));
                }
            }
        } catch (SQLException e) {
            LOGGER.info("Error getting service type entity by name: ", e);
        } finally {
            if (connection != null) {
                try {
                    connectionPool.releaseConnection(connection);
                } catch (SQLException e) {
                    LOGGER.info("Error releasing connection: ", e);
                }
            }
        }
        return serviceType;
    }
}
