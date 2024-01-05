package com.solvd.services;

import com.solvd.interfaces.iTestDriveDAO;
import com.solvd.jbdc.dao.TestDriveDAO;
import com.solvd.models.TestDrive;

import java.util.List;

public class TestDriveService implements iTestDriveDAO {

    TestDriveDAO testDriveDAO = new TestDriveDAO();

    @Override
    public void saveEntity(TestDrive testDrive) {
        testDriveDAO.saveEntity(testDrive);
    }

    @Override
    public TestDrive getEntityById(int id) {
        return testDriveDAO.getEntityById(id);
    }

    @Override
    public void updateEntity(TestDrive testDrive) {
        testDriveDAO.updateEntity(testDrive);
    }

    @Override
    public void removeEntityById(int id) {
        testDriveDAO.removeEntityById(id);
    }

    @Override
    public List<TestDrive> getAll() {
        return testDriveDAO.getAll();
    }

    @Override
    public List<TestDrive> getTestDrivesByEmployeeID(int id) {
        return testDriveDAO.getTestDrivesByEmployeeID(id);
    }
}
