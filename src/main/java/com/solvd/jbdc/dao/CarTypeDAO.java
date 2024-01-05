package com.solvd.jbdc.dao;

import com.solvd.models.CarType;
import com.solvd.util.ConnectionPool;
import com.solvd.interfaces.iCarTypeDAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CarTypeDAO implements iCarTypeDAO {
    private ConnectionPool connectionPool = ConnectionPool.getInstance();

    @Override
    public void saveEntity(CarType carType) {
        Connection connection = connectionPool.getConnection();
        String query = "INSERT INTO car_types (id, car_type) VALUES ((?), (?))";
        try (PreparedStatement ps = connection.prepareStatement(query)) {
            ps.setInt(1, carType.getId());
            ps.setString(2, carType.getCarType());
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
                    carType.setCarType(rs.getString("car_type"));// FIXME
                    carTypes.add(carType);
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
        return carTypes;
    }


    @Override
    public CarType getEntityById(int id) {
        Connection connection = connectionPool.getConnection();
        String query = "SELECT * FROM car_types WHERE id = (?)";
        CarType carType = new CarType();
        try (PreparedStatement ps = connection.prepareStatement(query)) {
            ps.setInt(1, id);
            ps.execute();
            try (ResultSet rs = ps.getResultSet()) {
                while (rs.next()) {
                    carType.setId(rs.getInt("id"));
                    carType.setCarType(rs.getString("carType"));
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


        return carType;
    }

    @Override
    public void updateEntity(CarType carType) {
        Connection connection = connectionPool.getConnection();
        String query = "UPDATE car_types SET car_type = (?) WHERE id = (?)";
        try (PreparedStatement ps = connection.prepareStatement(query)) {
            ps.setString(2, carType.getCarType());
            ps.setInt(1, carType.getId());
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
        String query = "DELETE FROM car_types WHERE id = (?)";
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
    public CarType getCarTypeByName(String carType) {
        Connection connection = connectionPool.getConnection();
        String query = "SELECT FROM car_types WHERE car_type = (?)";
        CarType carType1 = null;
        try (PreparedStatement ps = connection.prepareStatement(query)) {
            ps.setString(1, carType);
            ps.execute();
            try (ResultSet rs = ps.getResultSet()) {
                while (rs.next()) {
                    carType1.setId(rs.getInt("id"));
                    carType1.setCarType(rs.getString("car_type"));
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
        return carType1;
    }
}
