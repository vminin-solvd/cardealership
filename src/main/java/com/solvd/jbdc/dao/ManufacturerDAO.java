package com.solvd.jbdc.dao;

import com.solvd.models.Manufacturer;
import com.solvd.util.ConnectionPool;
import com.solvd.interfaces.iManufacturerDAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ManufacturerDAO implements iManufacturerDAO{
    private ConnectionPool connectionPool = ConnectionPool.getInstance();
    @Override
    public void saveEntity(Manufacturer manufacturer) {
        Connection connection = connectionPool.getConnection();
        String query = "INSERT INTO manufacturers (id, manufacturer_name) VALUES ((?), (?))";
        try (PreparedStatement ps = connection.prepareStatement(query)) {
            ps.setInt(1, manufacturer.getId());
            ps.setString(2, manufacturer.getManufacturerName());
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
    public List<Manufacturer> getAll(){
        Connection connection = connectionPool.getConnection();
        String query = "SELECT * FROM manufacturers";
        List<Manufacturer> Manufacturers = new ArrayList<>();
        try (PreparedStatement ps = connection.prepareStatement(query)) {
            ps.execute();
            try (ResultSet rs = ps.getResultSet()) {
                while (rs.next()) {
                    Manufacturer Manufacturer = new Manufacturer();
                    Manufacturer.setId(rs.getInt("id"));
                    Manufacturer.setManufacturerName(rs.getString("manufacturer_name"));// FIXME
                    Manufacturers.add(Manufacturer);
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
        return Manufacturers;
    }


    @Override
    public Manufacturer getEntityById(int id) {
        Connection connection = connectionPool.getConnection();
        String query = "SELECT * FROM manufacturers WHERE id = (?)";
        Manufacturer Manufacturer = new Manufacturer();
        try (PreparedStatement ps = connection.prepareStatement(query)) {
            ps.setInt(1, id);
            ps.execute();
            try (ResultSet rs = ps.getResultSet()) {
                while (rs.next()) {
                    Manufacturer.setId(rs.getInt("id"));
                    Manufacturer.setManufacturerName(rs.getString("manufacturer_name"));
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


        return Manufacturer;
    }

    @Override
    public void updateEntity(Manufacturer Manufacturer) {
        Connection connection = connectionPool.getConnection();
        String query = "UPDATE manufacturers SET manufacturer_name = (?) WHERE id = (?)";
        try (PreparedStatement ps = connection.prepareStatement(query)) {
            ps.setString(2, Manufacturer.getManufacturerName());
            ps.setInt(1, Manufacturer.getId());
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
        String query = "DELETE FROM manufacturers WHERE id = (?)";
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
    public Manufacturer getManufacturerByName(String manufacturerName) {
        return null;
    }
}
