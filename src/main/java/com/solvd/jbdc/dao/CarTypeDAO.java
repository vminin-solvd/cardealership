package com.solvd.jbdc.dao;

import com.solvd.models.CarType;
import com.solvd.util.ConnectionPool;
import com.solvd.interfaces.ICarTypeDAO;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CarTypeDAO implements ICarTypeDAO {

    private final Logger LOGGER = LogManager.getLogger(CarTypeDAO.class);
    private ConnectionPool connectionPool = ConnectionPool.getInstance();

    @Override
    public void saveEntity(CarType carType) {
        Connection connection = connectionPool.getConnection();
        String query = "INSERT INTO car_types (id, car_type) VALUES ((?), (?))";
        try (PreparedStatement ps = connection.prepareStatement(query)) {
            ps.setInt(1, carType.getId());
            ps.setString(2, carType.getCarType());
            ps.executeUpdate();
        } catch (SQLException e) {
            LOGGER.info("Error saving car type entity: ", e);
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
    public List<CarType> getAll(){
        Connection connection = connectionPool.getConnection();
        String query = "SELECT * FROM car_types";
        List<CarType> carTypes = new ArrayList<>();
        try (PreparedStatement ps = connection.prepareStatement(query)) {
            ps.execute();
            try (ResultSet rs = ps.getResultSet()) {
                while (rs.next()) {
                    CarType carType = new CarType();
                    carType.setId(rs.getInt("id"));
                    carType.setCarType(rs.getString("car_type"));
                    carTypes.add(carType);
                }
            }
        } catch (SQLException e) {
            LOGGER.info("Error getting all car types", e);
        } finally {
            if( connection != null) {
                try {
                    connectionPool.releaseConnection(connection);
                } catch (SQLException e) {
                    LOGGER.info("Error releasing connection: ", e);
                }
            }
        }
        return carTypes;
    }


    @Override
    public CarType getEntityById(int id) {
        Connection connection = connectionPool.getConnection();
        String query = "SELECT * FROM car_types WHERE id = (?)";
        CarType carType = null;
        try (PreparedStatement ps = connection.prepareStatement(query)) {
            ps.setInt(1, id);
            ps.execute();
            try (ResultSet rs = ps.getResultSet()) {
                while (rs.next()) {
                    carType.setId(rs.getInt("id"));
                    carType.setCarType(rs.getString("car_type"));
                }
            }
        } catch (SQLException e) {
            LOGGER.info("Error getting car type entity by ID: ", e);
        } finally {
            if (connection != null) {
                try {
                    connectionPool.releaseConnection((connection));
                } catch (SQLException e) {
                    LOGGER.info("Error releasing connection: ", e);
                }
            }
        }
        return carType;
    }

    @Override
    public void updateEntity(CarType carType) {
        Connection connection = connectionPool.getConnection();
        String query = "UPDATE car_types SET car_type = (?) WHERE id = (?)";
        try (PreparedStatement ps = connection.prepareStatement(query)) {
            ps.setString(2, carType.getCarType());
            ps.setInt(1, carType.getId());
            ps.executeUpdate();
        } catch (SQLException e) {
            LOGGER.info("Error updating car type entity: ", e);
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
        String query = "DELETE FROM car_types WHERE id = (?)";
        try (PreparedStatement ps = connection.prepareStatement(query)) {
            ps.setInt(1, id);
            ps.executeUpdate();
        } catch (SQLException e) {
            LOGGER.info("Error removing car type entity by ID: ", e);
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
    public CarType getCarTypeByName(String carTypeName) {
        Connection connection = connectionPool.getConnection();
        String query = "SELECT * FROM car_types WHERE car_type = (?)";
        CarType carType = null;
        try (PreparedStatement ps = connection.prepareStatement(query)) {
            ps.setString(1, carTypeName);
            ps.execute();
            try (ResultSet rs = ps.getResultSet()) {
                while (rs.next()) {
                    carType = new CarType();
                    carType.setId(rs.getInt("id"));
                    carType.setCarType(rs.getString("car_type"));
                }
            }
        } catch (SQLException e) {
            LOGGER.info("Error retrieving car type by name: ", e);
        } finally {
            if (connection != null) {
                try {
                    connectionPool.releaseConnection(connection);
                } catch (SQLException e) {
                    LOGGER.info("Error releasing connection: ", e);
                }
            }
        }
        return carType;
    }
}
