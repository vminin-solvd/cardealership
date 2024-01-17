package com.solvd.jbdc.dao;

import com.solvd.models.CarSale;
import com.solvd.util.ConnectionPool;
import com.solvd.interfaces.ICarSaleDAO;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CarSaleDAO implements ICarSaleDAO {

    private final Logger LOGGER = LogManager.getLogger(CarSaleDAO.class);
    private ConnectionPool connectionPool = ConnectionPool.getInstance();

    @Override
    public List<CarSale> getAll() {
        Connection connection = connectionPool.getConnection();
        String query = "SELECT * FROM car_sales";
        List<CarSale> carSales = new ArrayList<>();
        try (PreparedStatement ps = connection.prepareStatement(query)) {
            ps.executeQuery();
            try (ResultSet rs = ps.getResultSet()) {
                while (rs.next()) {
                    CarSale carSale = new CarSale();
                    carSale.setId(rs.getInt("id"));
                    carSale.setCustomer(new CustomerDAO().getEntityById(rs.getInt("customer_id")));
                    carSale.setEmployee(new EmployeeDAO().getEntityById(rs.getInt("employee_id")));
                    carSale.setCar(new CarDAO().getEntityById(rs.getInt("car_id")));
                    carSales.add(carSale);
                }
            }
        } catch (SQLException e) {
            LOGGER.info("Error getting all car sales: ", e);
        } finally {
            if (connection != null) {
                try {
                    connectionPool.releaseConnection(connection);
                } catch (SQLException e) {
                    LOGGER.info("Error releasing connection: ", e);
                }
            }
        }
        return carSales;
    }

    @Override
    public void saveEntity(CarSale carSale) {
        Connection connection = connectionPool.getConnection();
        String query = "INSERT INTO car_sales (id, customer_id, employee_id, car_id) VALUES ((?), (?), (?), (?))";
        try (PreparedStatement ps = connection.prepareStatement(query)) {
            ps.setInt(1, carSale.getId());
            ps.setInt(2, carSale.getCustomer().getId());
            ps.setInt(3, carSale.getEmployee().getId());
            ps.setInt(4, carSale.getCar().getId());
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
    public CarSale getEntityById(int id) {
        Connection connection = connectionPool.getConnection();
        String query = "SELECT * FROM car_sales WHERE id = (?)";
        CarSale carSale = new CarSale();
        try (PreparedStatement ps = connection.prepareStatement(query)) {
            ps.setInt(1, id);
            ps.executeQuery();
            try (ResultSet rs = ps.getResultSet()) {
                while (rs.next()) {
                    carSale.setId(rs.getInt("id"));

                    carSale.setCustomer(new CustomerDAO().getEntityById(rs.getInt("customer_id")));
                    carSale.setEmployee(new EmployeeDAO().getEntityById(rs.getInt("employee_id")));
                    carSale.setCar(new CarDAO().getEntityById(rs.getInt("car_id")));
                }
            }
        } catch (SQLException e) {
            LOGGER.info("Error getting car sale by ID: ", e);
        } finally {
            if (connection != null) {
                try {
                    connectionPool.releaseConnection((connection));
                } catch (SQLException e) {
                    LOGGER.info("Error releasing connection: ", e);
                }
            }
        }
        return carSale;
    }

    @Override
    public void updateEntity(CarSale carSale) {
        Connection connection = connectionPool.getConnection();
        String query = "UPDATE car_sales SET customer_id = (?), employee_id = (?), car_id = (?) WHERE id = (?)";
        try (PreparedStatement ps = connection.prepareStatement(query)) {
            ps.setInt(1, carSale.getCustomer().getId());
            ps.setInt(2, carSale.getEmployee().getId());
            ps.setInt(3, carSale.getCar().getId());
            ps.setInt(4, carSale.getId());
            ps.executeUpdate();
        } catch (SQLException e) {
            LOGGER.info("Error updating car sale entity: ", e);
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
        String query = "DELETE FROM car_sales WHERE id = (?)";
        try (PreparedStatement ps = connection.prepareStatement(query)) {
            ps.setInt(1, id);
            ps.executeUpdate();
        } catch (SQLException e) {
            LOGGER.info("Error removing car sale by ID: ", e);
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
    public List<CarSale> getCarSalesByEmployeeID(int id) {
        List<CarSale> carSales = new ArrayList<>();
        Connection connection = connectionPool.getConnection();
        String query = "SELECT * FROM car_sales WHERE employee_id = ?";
        try (PreparedStatement ps = connection.prepareStatement(query)) {
            ps.setInt(1, id);
            ps.executeQuery();
            try (ResultSet rs = ps.getResultSet()){
                while (rs.next()) {
                    CarSale carSale = new CarSale();
                    carSale.setId(rs.getInt("id"));

                    carSale.setCustomer(new CustomerDAO().getEntityById(rs.getInt("customer_id")));
                    carSale.setEmployee(new EmployeeDAO().getEntityById(rs.getInt("employee_id")));
                    carSale.setCar(new CarDAO().getEntityById(rs.getInt("car_id")));

                    carSales.add(carSale);
                }
            }
        } catch (SQLException e) {
            LOGGER.error("Error retrieving car sales by employee ID: ", e);
        } finally {
            if (connection != null) {
                try {
                    connectionPool.releaseConnection(connection);
                } catch (SQLException e) {
                    LOGGER.error("Error releasing connection: ", e);
                }
            }
        }
        return carSales;
    }
}
