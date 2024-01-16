package com.solvd.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Vector;

public class ConnectionPool {

private static ConnectionPool instance = null;
private static final int INITIAL_POOL_SIZE = 5;
private static Vector<Connection> freeConnections = new Vector<>();
private static Vector<Connection> usedConnections = new Vector<>();

public static synchronized ConnectionPool getInstance() {
    if (instance == null) {
        instance = new ConnectionPool();
        create();
    }
    return instance;
}

public static void create() {
    for (int numConnections = 0; numConnections < INITIAL_POOL_SIZE; numConnections++) {
        freeConnections.add(createConnection(DBConfig.URL, DBConfig.USERNAME, DBConfig.PASSWORD));
    }
}

public synchronized Connection getConnection() {
    Connection connection = freeConnections.remove(freeConnections.size()-1);
    usedConnections.add(connection);
    return connection;
}

public synchronized void releaseConnection(Connection connection) throws SQLException {
    if (usedConnections.remove(connection)) {
        freeConnections.add(connection);
    } else {
        throw new SQLException("Connection has already returned");
    }

}

private static Connection createConnection(String url, String userName, String password) {
    try {
      return  DriverManager.getConnection(url, userName, password);
    } catch (SQLException e) {
        System.out.println(e.getMessage());// FIXME Replace with LOGGER
    }
    return null;
}
}
