package com.solvd.jbdc.dao;

import com.solvd.models.Car;
import com.solvd.util.ConnectionPool;
import com.solvd.interfaces.ICarDAO;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CarDAO implements ICarDAO {

    private final Logger LOGGER = LogManager.getLogger(CarDAO.class);
    private ConnectionPool connectionPool = ConnectionPool.getInstance();

    @Override
    public List<Car> getAll() {
        Connection connection = connectionPool.getConnection();
        String query = "SELECT * FROM cars";
        List<Car> cars = new ArrayList<>();
        try (PreparedStatement ps = connection.prepareStatement(query)) {
            ps.executeQuery();
            try (ResultSet rs = ps.getResultSet()) {
                while (rs.next()) {
                    Car car = new Car();
                    car.setId(rs.getInt("id"));
                    car.setPrice(rs.getInt("price"));
                    car.setModel(rs.getString("model"));
                    car.setYear(rs.getString("year"));
                    car.setSold(rs.getBoolean("is_sold"));
                    car.setCarType(new CarTypeDAO().getEntityById(rs.getInt("car_type_id")));
                    car.setManufacturer(new ManufacturerDAO().getEntityById(rs.getInt("manufacturer_id")));
                    cars.add(car);}
            }
        } catch (SQLException e) {
            LOGGER.info("Error getting all cars: ", e);
        } finally {
            if( connection != null) {
                try {
                    connectionPool.releaseConnection(connection);
                } catch (SQLException e) {
                    LOGGER.info("Error releasing connection: ", e);
                }
            }
        }
        return cars;
    }

    @Override
    public void saveEntity(Car car) {
        Connection connection = connectionPool.getConnection();
        String query = "INSERT INTO cars (price, model, year, is_sold, car_type_id, manufacturer_id) VALUES (?, ?, ?, ?, ?, ?)";
        try (PreparedStatement ps = connection.prepareStatement(query)) {
            ps.setInt(1, car.getPrice());
            ps.setString(2, car.getModel());
            ps.setString(3, car.getYear());
            ps.setBoolean(4, car.isSold());
            ps.setInt(5, car.getCarType().getId());
            ps.setInt(6, car.getManufacturer().getId());
            ps.executeUpdate();
        } catch (SQLException e) {
            LOGGER.error("Error saving car entity: ", e);
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
    public Car getEntityById(int id) {
        Connection connection = connectionPool.getConnection();
        String query = "SELECT * FROM cars WHERE id = (?)";
        Car car = new Car();
        try (PreparedStatement ps = connection.prepareStatement(query)) {
            ps.setInt(1, id);
            ps.executeQuery();
            try (ResultSet rs = ps.getResultSet()) {
                while (rs.next()) {
                    car.setId(rs.getInt("id"));
                    car.setPrice(rs.getInt("price"));
                    car.setModel(rs.getString("model"));
                    car.setYear(rs.getString("year"));
                    car.setSold(rs.getBoolean("is_sold"));
                    car.setCarType(new CarTypeDAO().getEntityById(rs.getInt("car_type_id")));
                    car.setManufacturer(new ManufacturerDAO().getEntityById(rs.getInt("manufacturer_id")));
                }
            }
        } catch (SQLException e) {
            LOGGER.info("Error getting car by ID: ", e);
        } finally {
            if (connection != null) {
                try {
                    connectionPool.releaseConnection((connection));
                } catch (SQLException e) {
                    LOGGER.info("Error releasing connection: ", e);
                }
            }
        }
        return car;
    }

    @Override
    public void updateEntity(Car car) {
        Connection connection = connectionPool.getConnection();
        String query = "UPDATE cars SET price = ?, model = ?, year = ?, is_sold = ?, car_type_id = ?, manufacturer_id = ? WHERE id = ?";
        try (PreparedStatement ps = connection.prepareStatement(query)) {
            ps.setInt(1, car.getPrice());
            ps.setString(2, car.getModel());
            ps.setString(3, car.getYear());
            ps.setBoolean(4, car.isSold());
            ps.setInt(5, car.getCarType().getId());
            ps.setInt(6, car.getManufacturer().getId());
            ps.setInt(7, car.getId());
            ps.executeUpdate();
        } catch (SQLException e) {
            LOGGER.error("Error updating car entity: ", e);
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
        String query = "DELETE FROM cars WHERE id = ?";
        try (PreparedStatement ps = connection.prepareStatement(query)) {
            ps.setInt(1, id);
            ps.executeUpdate();
        } catch (SQLException e) {
            LOGGER.error("Error removing car entity: ", e);
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
    public List<Car> getCarsByModel(String model) {
        List<Car> cars = new ArrayList<>();
        Connection connection = connectionPool.getConnection();
        String query = "SELECT * FROM cars WHERE model = ?";
        try (PreparedStatement ps = connection.prepareStatement(query)) {
            ps.setString(1, model);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Car car = new Car();
                car.setId(rs.getInt("id"));
                car.setPrice(rs.getInt("price"));
                car.setModel(rs.getString("model"));
                car.setYear(rs.getString("year"));
                car.setSold(rs.getBoolean("is_sold"));
                car.setCarType(new CarTypeDAO().getEntityById(rs.getInt("car_type_id")));
                car.setManufacturer(new ManufacturerDAO().getEntityById(rs.getInt("manufacturer_id")));
                cars.add(car);
            }
        } catch (SQLException e) {
            LOGGER.error("Error retrieving cars by model: ", e);
        } finally {
            if (connection != null) {
                try {
                    connectionPool.releaseConnection(connection);
                } catch (SQLException e) {
                    LOGGER.error("Error releasing connection: ", e);
                }
            }
        }
        return cars;
    }
}

