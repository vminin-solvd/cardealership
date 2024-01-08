package com.solvd.jbdc.dao;

import com.solvd.models.AdditionalService;
import com.solvd.util.ConnectionPool;
import com.solvd.interfaces.iAdditionalServiceDAO;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class AdditionalServiceDAO implements iAdditionalServiceDAO {
    private static final Logger LOGGER = LogManager.getLogger(AdditionalServiceDAO.class);
    private ConnectionPool connectionPool = ConnectionPool.getInstance();

    @Override
    public void saveEntity(AdditionalService additionalService) {
        Connection connection = connectionPool.getConnection();
        String query = "INSERT INTO additional_service (id, service_type) VALUES ((?), (?))";
        try (PreparedStatement ps = connection.prepareStatement(query)) {
            ps.setInt(1, additionalService.getId());
            ps.setString(2, additionalService.getServiceType().getServiceType());
            ps.executeUpdate();
        } catch (SQLException e) {
            LOGGER.info("Error saving car sale entity: ", e);
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
    public List<AdditionalService> getAll(){
        Connection connection = connectionPool.getConnection();
        String query = "SELECT * FROM additional_services";
        List<AdditionalService> additionalServiceList = new ArrayList<>();
        try (PreparedStatement ps = connection.prepareStatement(query)) {
            ps.execute();
            try (ResultSet rs = ps.getResultSet()) {
                while (rs.next()) {
                    AdditionalService additionalService = new AdditionalService();
                    additionalService.setId(rs.getInt("id"));
                    ServiceTypeDAO serviceTypeDAO = new ServiceTypeDAO();
                    additionalService.setServiceType(serviceTypeDAO.getServiceTypeByName(rs.getString("service_type")));
                    additionalServiceList.add(additionalService);
                }
            }
        } catch (SQLException e) {
            LOGGER.info("Error getting all additional services: ", e);
        } finally {
            if( connection != null) {
                try {
                    connectionPool.releaseConnection(connection);
                } catch (SQLException e) {
                    LOGGER.info("Error releasing connection: ", e);
                }
            }
        }
    return additionalServiceList;
    }


    @Override
    public AdditionalService getEntityById(int id) {
        Connection connection = connectionPool.getConnection();
        String query = "SELECT * FROM additional_service WHERE id = (?)";
        AdditionalService additionalService = new AdditionalService();
        try (PreparedStatement ps = connection.prepareStatement(query)) {
            ps.setInt(1, id);
            ps.execute();
            try (ResultSet rs = ps.getResultSet()) {
                while (rs.next()) {
                    additionalService.setId(rs.getInt("id"));
                    ServiceTypeDAO serviceTypeDAO = new ServiceTypeDAO();
                    additionalService.setServiceType(serviceTypeDAO.getServiceTypeByName(rs.getString("serviceType")));
                }
            }
        } catch (SQLException e) {
            LOGGER.info("Error getting additional service entity by ID: ", e);
        } finally {
            if (connection != null) {
                try {
                    connectionPool.releaseConnection((connection));
                } catch (SQLException e) {
                    LOGGER.info("Error releasing connection: ", e);
                }
            }
        }
        return additionalService;
    }

    @Override
    public void updateEntity(AdditionalService additionalService) {
        Connection connection = connectionPool.getConnection();
        String query = "UPDATE additional_services SET service_type = (?) WHERE id = (?)";
        try (PreparedStatement ps = connection.prepareStatement(query)) {
            ps.setString(1, additionalService.getServiceType().getServiceType());
            ps.setInt(2, additionalService.getId());
        } catch (SQLException e) {
            LOGGER.info("Error updating additional service entity: ", e);
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
        String query = "DELETE FROM additional_services WHERE id = (?)";
        try (PreparedStatement ps = connection.prepareStatement(query)) {
            ps.setInt(1, id);
            ps.execute();
        } catch (SQLException e) {
            LOGGER.info("Error removing additional service entity by ID: ", e);
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
    public AdditionalService getAdditionalServiceByServiceName(String serviceName) {
        Connection connection = connectionPool.getConnection();
        String query = "SELECT FROM additional_services WHERE service_name = (?)";
        AdditionalService additionalService = null;

        try (PreparedStatement ps = connection.prepareStatement(query)) {
            ps.setString(1, serviceName);
            ps.execute();
            try (ResultSet rs = ps.getResultSet()) {
                while (rs.next()) {
                    additionalService.setId(rs.getInt("id"));
                    ServiceTypeDAO serviceTypeDAO = new ServiceTypeDAO();
                    additionalService.setServiceType(serviceTypeDAO.getServiceTypeByName(rs.getString("serviceType")));
                }
            }
        } catch (SQLException e) {
            LOGGER.info(e);
        } finally {
            if (connection != null) {
                try {
                    connectionPool.releaseConnection(connection);
                } catch (SQLException e) {
                    LOGGER.info("Error releasing connection: ", e);
                }
            }
        }
        return additionalService;
    }
}
