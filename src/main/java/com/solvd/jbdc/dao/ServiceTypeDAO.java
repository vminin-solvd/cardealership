package com.solvd.jbdc.dao;

import com.solvd.models.ServiceType;
import com.solvd.util.ConnectionPool;
import com.solvd.interfaces.iServiceTypeDAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ServiceTypeDAO implements iServiceTypeDAO{
    private ConnectionPool connectionPool = ConnectionPool.getInstance();

    public void saveEntity(ServiceType serviceType) {
        Connection connection = connectionPool.getConnection();
        String query = "INSERT INTO service_types (id, service_type) VALUES ((?), (?))";
        try (PreparedStatement ps = connection.prepareStatement(query)) {
            ps.setInt(1, serviceType.getId());
            ps.setString(2, serviceType.getServiceType());

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
                    serviceType.setServiceType(rs.getString("service_type"));// FIXME
                    serviceTypes.add(serviceType);
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
        return serviceTypes;
    }


    @Override
    public ServiceType getEntityById(int id) {
        Connection connection = connectionPool.getConnection();
        String query = "SELECT * FROM ServiceTypes WHERE id = (?)";
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


        return serviceType;
    }

    @Override
    public void updateEntity(ServiceType serviceType) {
        Connection connection = connectionPool.getConnection();
        String query = "UPDATE service_types SET service_type = (?) WHERE id = (?)"; // FIXME MUST UPDATE LASTNAME ALSO
        try (PreparedStatement ps = connection.prepareStatement(query)) {
            ps.setString(1, serviceType.getServiceType());
            ps.setInt(2, serviceType.getId());
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
        String query = "DELETE FROM service_types WHERE id = (?)";
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
    public ServiceType getServiceTypeByName(String serviceTypeName) {
        return null;
    }
}
