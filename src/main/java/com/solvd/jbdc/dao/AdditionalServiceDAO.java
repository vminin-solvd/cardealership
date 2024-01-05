package com.solvd.jbdc.dao;

import com.solvd.models.AdditionalService;
import com.solvd.util.ConnectionPool;
import com.solvd.interfaces.iAdditionalServiceDAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class AdditionalServiceDAO implements iAdditionalServiceDAO {
    private ConnectionPool connectionPool = ConnectionPool.getInstance();

    @Override
    public void saveEntity(AdditionalService additionalService) {
        Connection connection = connectionPool.getConnection();
        String query = "INSERT INTO additional_service (id, service_type) VALUES ((?), (?))";
        try (PreparedStatement ps = connection.prepareStatement(query)) {
            ps.setInt(1, additionalService.getId());
            ps.setString(2, additionalService.getServiceType());
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
                    additionalService.setServiceType(rs.getString("service_type"));// FIXME
                    additionalServiceList.add(additionalService);
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
                    additionalService.setServiceType(rs.getString("serviceType"));
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


        return additionalService;
    }

    @Override
    public void updateEntity(AdditionalService additionalService) {
        Connection connection = connectionPool.getConnection();
        String query = "UPDATE additional_services SET service_type = (?) WHERE id = (?)";
        try (PreparedStatement ps = connection.prepareStatement(query)) {
            ps.setString(1, additionalService.getServiceType());
            ps.setInt(2, additionalService.getId());
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
        String query = "DELETE FROM additional_services WHERE id = (?)";
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
    public AdditionalService getAdditionalServiceByServiceName(String serviceName) {
        Connection connection = connectionPool.getConnection();
        String query = "SELECT FROM additional_services WHERE service_name = (?)";
        AdditionalService additionalService = null;

        try (PreparedStatement ps = connection.prepareStatement(query)) {
            ps.setString(2, serviceName);
            ps.execute();
            try (ResultSet rs = ps.getResultSet()) {
                while (rs.next()) {
                    additionalService.setId(rs.getInt("id"));
                    additionalService.setServiceType(rs.getString("serviceType"));
                }
            }
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
        return additionalService;
    }
}
