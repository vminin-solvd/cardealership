package com.solvd.jbdc.dao;

import com.solvd.models.Manufacturer;
import com.solvd.util.ConnectionPool;
import com.solvd.interfaces.IManufacturerDAO;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ManufacturerDAO implements IManufacturerDAO {

    private final Logger LOGGER = LogManager.getLogger(ManufacturerDAO.class);
    private ConnectionPool connectionPool = ConnectionPool.getInstance();

    @Override
    public void saveEntity(Manufacturer manufacturer) {
        Connection connection = connectionPool.getConnection();
        String query = "INSERT INTO manufacturers (id, manufacturer_name) VALUES ((?), (?))";
        try (PreparedStatement ps = connection.prepareStatement(query)) {
            ps.setInt(1, manufacturer.getId());
            ps.setString(2, manufacturer.getManufacturerName());
            ps.executeUpdate();
        } catch (SQLException e) {
            LOGGER.info("Error saving manufacturer entity: ", e);
        } finally {
            if (connection != null) {
                try {
                    connectionPool.releaseConnection(connection);
                } catch (SQLException e) {
                    LOGGER.info("Error closing connection: ",e);
                }
            }
        }
    }

    @Override
    public List<Manufacturer> getAll() {
        Connection connection = connectionPool.getConnection();
        String query = "SELECT * FROM manufacturers";
        List<Manufacturer> manufacturers = new ArrayList<>();
        try (PreparedStatement ps = connection.prepareStatement(query)) {
            ps.executeQuery();
            try (ResultSet rs = ps.getResultSet()) {
                while (rs.next()) {
                    Manufacturer manufacturer = new Manufacturer();
                    manufacturer.setId(rs.getInt("id"));
                    manufacturer.setManufacturerName(rs.getString("manufacturer_name"));
                    manufacturers.add(manufacturer);
                }
            }
        } catch (SQLException e) {
            LOGGER.info("Error: getting all manufacturer entities: ",e);
        } finally {
            if (connection != null) {
                try {
                    connectionPool.releaseConnection(connection);
                } catch (SQLException e) {
                    LOGGER.info("Error releasing connection: ", e);
                }
            }
        }
        return manufacturers;
    }

    @Override
    public Manufacturer getEntityById(int id) {
        Connection connection = connectionPool.getConnection();
        String query = "SELECT * FROM manufacturers WHERE id = (?)";
        Manufacturer Manufacturer = new Manufacturer();
        try (PreparedStatement ps = connection.prepareStatement(query)) {
            ps.setInt(1, id);
            ps.executeQuery();
            try (ResultSet rs = ps.getResultSet()) {
                while (rs.next()) {
                    Manufacturer.setId(rs.getInt("id"));
                    Manufacturer.setManufacturerName(rs.getString("manufacturer_name"));
                }
            }
        } catch (SQLException e) {
            LOGGER.info("Error getting manufacturer entity by ID: ",e);
        } finally {
            if (connection != null) {
                try {
                    connectionPool.releaseConnection((connection));
                } catch (SQLException e) {
                    LOGGER.info("Error releasing connection: ", e);
                }
            }
        }
        return Manufacturer;
    }

    @Override
    public void updateEntity(Manufacturer manufacturer) {
        Connection connection = connectionPool.getConnection();
        String query = "UPDATE manufacturers SET manufacturer_name = (?) WHERE id = (?)";
        try (PreparedStatement ps = connection.prepareStatement(query)) {
            ps.setString(1, manufacturer.getManufacturerName());
            ps.setInt(2, manufacturer.getId());
            ps.executeUpdate();
        } catch (SQLException e) {
            LOGGER.info("Error updating manufacturer entity: ", e);
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
        String query = "DELETE FROM manufacturers WHERE id = (?)";
        try (PreparedStatement ps = connection.prepareStatement(query)) {
            ps.setInt(1, id);
            ps.executeQuery();
        } catch (SQLException e) {
            LOGGER.info("Error removing manufacturer entity by ID: ",e);
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
    public Manufacturer getManufacturerByName(String manufacturerName) {
        Connection connection = connectionPool.getConnection();
        String query = "SELECT FROM manufacturers WHERE manufacturer_name = (?)";
        Manufacturer manufacturer = null;
        try (PreparedStatement ps = connection.prepareStatement(query)) {
            ps.setString(1, manufacturerName);
            ps.executeQuery();
            try (ResultSet rs = ps.getResultSet()) {
                while (rs.next()) {
                    manufacturer = new Manufacturer();
                    manufacturer.setId(rs.getInt("id"));
                    manufacturer.setManufacturerName(rs.getString("manufacturer_name"));
                }
            }
        } catch (SQLException e) {
            LOGGER.info("Error getting manufacturer entity by name: ",e);
        } finally {
            if (connection != null) {
                try {
                    connectionPool.releaseConnection(connection);
                } catch (SQLException e) {
                    LOGGER.info("Error releasing connection: ", e);
                }
            }
        }
        return manufacturer;
    }
}

