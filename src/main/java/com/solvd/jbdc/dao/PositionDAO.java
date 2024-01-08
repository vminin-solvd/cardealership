package com.solvd.jbdc.dao;

import com.solvd.models.Position;
import com.solvd.util.ConnectionPool;
import com.solvd.interfaces.IPositionDAO;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class PositionDAO implements IPositionDAO {
    private static final Logger LOGGER = LogManager.getLogger(PositionDAO.class);
    private ConnectionPool connectionPool = ConnectionPool.getInstance();

    public void saveEntity(Position position) {
        Connection connection = connectionPool.getConnection();
        String query = "INSERT INTO positions (id, position_name) VALUES ((?), (?))";
        try (PreparedStatement ps = connection.prepareStatement(query)) {
            ps.setInt(1, position.getId());
            ps.setString(2, position.getPositionName());
            ps.executeUpdate();
        } catch (SQLException e) {
            LOGGER.info("Error saving position entity: ", e);
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
    public List<Position> getAll(){
        Connection connection = connectionPool.getConnection();
        String query = "SELECT * FROM positions";
        List<Position> positions = new ArrayList<>();
        try (PreparedStatement ps = connection.prepareStatement(query)) {
            ps.execute();
            try (ResultSet rs = ps.getResultSet()) {
                while (rs.next()) {
                    Position position = new Position();
                    position.setId(rs.getInt("id"));
                    position.setPositionName(rs.getString("position_name"));
                    positions.add(position);
                }
            }
        } catch (SQLException e) {
            LOGGER.info("Error getting all position entities: ", e);
        } finally {
            if( connection != null) {
                try {
                    connectionPool.releaseConnection(connection);
                } catch (SQLException e) {
                    LOGGER.info("Error releasing connection: ", e);
                }
            }
        }
        return positions;
    }


    @Override
    public Position getEntityById(int id) {
        Connection connection = connectionPool.getConnection();
        String query = "SELECT * FROM positions WHERE id = (?)";
        Position position = new Position();
        try (PreparedStatement ps = connection.prepareStatement(query)) {
            ps.setInt(1, id);
            ps.execute();
            try (ResultSet rs = ps.getResultSet()) {
                while (rs.next()) {
                    position.setId(rs.getInt("id"));
                    position.setPositionName((rs.getString("position_name")));
                }
            }
        } catch (SQLException e) {
            LOGGER.info("Error getting position entity by ID: ", e);
        } finally {
            if (connection != null) {
                try {
                    connectionPool.releaseConnection((connection));
                } catch (SQLException e) {
                    LOGGER.info("Error releasing connection: ", e);
                }
            }
        }
        return position;
    }

    @Override
    public void updateEntity(Position position) {
        Connection connection = connectionPool.getConnection();
        String query = "UPDATE positions SET position_name = (?) WHERE id = (?)";
        try (PreparedStatement ps = connection.prepareStatement(query)) {
            ps.setString(1, position.getPositionName());
            ps.setInt(2, position.getId());
            ps.executeUpdate();
        } catch (SQLException e) {
            LOGGER.info("Error updating position entity: ", e);
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
        String query = "DELETE FROM positions WHERE id = (?)";
        try (PreparedStatement ps = connection.prepareStatement(query)) {
            ps.setInt(1, id);
            ps.execute();
        } catch (SQLException e) {
            LOGGER.info("Error removing position entity by ID: ", e);
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
    public Position getPositionByName(String positionName) {
        Connection connection = connectionPool.getConnection();
        String query = "SELECT * FROM positions WHERE position_name = (?)";
        Position position = null;
        try (PreparedStatement ps = connection.prepareStatement(query)) {
            ps.setString(1, positionName);
            ps.execute();
            try (ResultSet rs = ps.getResultSet()) {
                while (rs.next()) {
                    position = new Position();
                    position.setId(rs.getInt("id"));
                    position.setPositionName(rs.getString("position_name"));
                }
            }
        } catch (SQLException e) {
            LOGGER.info("Error getting position entity by name: ", e);
        } finally {
            if (connection != null) {
                try {
                    connectionPool.releaseConnection(connection);
                } catch (SQLException e) {
                    LOGGER.info("Error releasing connection: ", e);
                }
            }
        }
        return position;
    }
}
