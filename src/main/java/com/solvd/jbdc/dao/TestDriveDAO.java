package com.solvd.jbdc.dao;

import com.solvd.models.TestDrive;
import com.solvd.util.ConnectionPool;
import com.solvd.interfaces.ITestDriveDAO;

import java.util.List;

public class TestDriveDAO implements ITestDriveDAO {
    private ConnectionPool connectionPool = ConnectionPool.getInstance();

    @Override
    public List getAll() {
        return null;
    }

    @Override
    public void saveEntity(TestDrive testDrive) {
    }

    @Override
    public TestDrive getEntityById(int id) {
        return null;
    }

    @Override
    public void updateEntity(TestDrive testDrive) {

    }

    @Override
    public void removeEntityById(int id) {

    }

    @Override
    public List<TestDrive> getTestDrivesByEmployeeID(int id) {
        return null;
    }
}
