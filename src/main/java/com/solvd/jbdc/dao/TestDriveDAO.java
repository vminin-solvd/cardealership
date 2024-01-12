package com.solvd.jbdc.dao;

import com.solvd.models.TestDrive;
import com.solvd.util.ConnectionPool;
import com.solvd.interfaces.ITestDriveDAO;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class TestDriveDAO implements ITestDriveDAO {

    private final Logger LOGGER = LogManager.getLogger(TestDriveDAO.class);
    private ConnectionPool connectionPool = ConnectionPool.getInstance();

    @Override
    public List<TestDrive> getAll() {
        Connection connection = connectionPool.getConnection();
        String query = "SELECT * FROM test_drives";
        List<TestDrive> testDrives = new ArrayList<>();
        try (PreparedStatement ps = connection.prepareStatement(query)) {
            ps.execute();
            try (ResultSet rs = ps.getResultSet()) {
                while (rs.next()) {
                    TestDrive testDrive = new TestDrive();
                    testDrive.setId(rs.getInt("id"));
                    testDrive.setCustomer(new CustomerDAO().getEntityById(rs.getInt("customer_id")));
                    testDrive.setEmployee(new EmployeeDAO().getEntityById(rs.getInt("employee_id")));
                    testDrive.setCar(new CarDAO().getEntityById(rs.getInt("car_id")));
                    testDrive.setDate(rs.getDate("date"));
                    testDrives.add(testDrive);
                }
            }
        } catch (SQLException e) {
            LOGGER.info("Error getting all test drives: ", e);
        } finally {
            if (connection != null) {
                try {
                    connectionPool.releaseConnection(connection);
                } catch (SQLException e) {
                    LOGGER.info("Error releasing connection: ", e);
                }
            }
        }
        return testDrives;
    }

    @Override
    public void saveEntity(TestDrive testDrive) {
        Connection connection = connectionPool.getConnection();
        String query = "INSERT INTO test_drives (date, car_id, customer_id, employee_id) VALUES (?, ?, ?, ?)";
        try (PreparedStatement ps = connection.prepareStatement(query)) {
            ps.setDate(1, testDrive.getDate());
            ps.setInt(2, testDrive.getCar().getId());
            ps.setInt(3, testDrive.getCustomer().getId());
            ps.setInt(4, testDrive.getEmployee().getId());
            ps.executeUpdate();
        } catch (SQLException e) {
            LOGGER.info("Error saving test drive entity: ", e);
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
    public TestDrive getEntityById(int id) {
        Connection connection = connectionPool.getConnection();
        String query = "SELECT * FROM test_drives WHERE id = (?)";
        TestDrive testDrive = new TestDrive();
        try (PreparedStatement ps = connection.prepareStatement(query)) {
            ps.setInt(1, id);
            ps.execute();
            try (ResultSet rs = ps.getResultSet()) {
                while (rs.next()) {
                    testDrive.setId(rs.getInt("id"));
                    testDrive.setCustomer(new CustomerDAO().getEntityById(rs.getInt("customer_id")));
                    testDrive.setEmployee(new EmployeeDAO().getEntityById(rs.getInt("employee_id")));
                    testDrive.setCar(new CarDAO().getEntityById(rs.getInt("car_id")));
                    testDrive.setDate(rs.getDate("date"));
                }
            }
        } catch (SQLException e) {
            LOGGER.info("Error getting test drive by ID: ", e);
        } finally {
            if (connection != null) {
                try {
                    connectionPool.releaseConnection((connection));
                } catch (SQLException e) {
                    LOGGER.info("Error releasing connection: ", e);
                }
            }
        }
        return testDrive;
    }

    @Override
    public void updateEntity(TestDrive testDrive) {
        Connection connection = connectionPool.getConnection();
        String query = "UPDATE test_drives (date, car_id, customer_id, employee_id) VALUES (?, ?, ?, ?)";
        try (PreparedStatement ps = connection.prepareStatement(query)) {
            ps.setDate(1, testDrive.getDate());
            ps.setInt(2, testDrive.getCar().getId());
            ps.setInt(3, testDrive.getCustomer().getId());
            ps.setInt(4, testDrive.getEmployee().getId());
            ps.executeUpdate();
        } catch (SQLException e) {
            LOGGER.info("Error updating test drive entity: ", e);
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
        String query = "DELETE FROM test_drives WHERE id = (?)";
        try (PreparedStatement ps = connection.prepareStatement(query)) {
            ps.setInt(1, id);
            ps.executeUpdate();
        } catch (SQLException e) {
            LOGGER.info("Error removing test drive by ID: ", e);
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
    public List<TestDrive> getTestDrivesByEmployeeID(int id) {
        List<TestDrive> testDrives = new ArrayList<>();
        Connection connection = connectionPool.getConnection();
        String query = "SELECT * FROM test_drives WHERE employee_id = ?";
        try (PreparedStatement ps = connection.prepareStatement(query)) {
            ps.setInt(1, id);
            ps.execute();
            try (ResultSet rs = ps.getResultSet()) {
                while (rs.next()) {
                    TestDrive testDrive = new TestDrive();
                    testDrive.setId(rs.getInt("id"));
                    testDrive.setCustomer(new CustomerDAO().getEntityById(rs.getInt("customer_id")));
                    testDrive.setEmployee(new EmployeeDAO().getEntityById(rs.getInt("employee_id")));
                    testDrive.setCar(new CarDAO().getEntityById(rs.getInt("car_id")));
                    testDrive.setDate(rs.getDate("date"));
                    testDrives.add(testDrive);
                }
            }
        } catch (SQLException e) {
            LOGGER.error("Error retrieving test drives by employee ID: ", e);
        } finally {
            if (connection != null) {
                try {
                    connectionPool.releaseConnection(connection);
                } catch (SQLException e) {
                    LOGGER.error("Error releasing connection: ", e);
                }
            }
        }
        return testDrives;
    }
}
