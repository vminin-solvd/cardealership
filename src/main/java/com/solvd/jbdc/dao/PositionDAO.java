package com.solvd.jbdc.dao;

import com.solvd.models.Position;
import com.solvd.util.ConnectionPool;
import com.solvd.interfaces.iPositionDAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class PositionDAO implements iPositionDAO{
    private ConnectionPool connectionPool = ConnectionPool.getInstance();

    public void saveEntity(Position position) {
        Connection connection = connectionPool.getConnection();
        String query = "INSERT INTO positions (id, position_name) VALUES ((?), (?))";
        try (PreparedStatement ps = connection.prepareStatement(query)) {
            ps.setInt(1, position.getId());
            ps.setString(2, position.getPositionName());

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
                    position.setPositionName(rs.getString("position_name"));// FIXME
                    positions.add(position);
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


        return position;
    }

    @Override
    public void updateEntity(Position position) {
        Connection connection = connectionPool.getConnection();
        String query = "UPDATE positions SET position_name = (?) WHERE id = (?)"; // FIXME MUST UPDATE LASTNAME ALSO
        try (PreparedStatement ps = connection.prepareStatement(query)) {
            ps.setString(1, position.getPositionName());
            ps.setInt(2, position.getId());
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
        String query = "DELETE FROM positions WHERE id = (?)";
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
    public Position getPositionByName(String positionName) {
        return null;
    }
}
