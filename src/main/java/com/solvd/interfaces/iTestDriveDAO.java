package com.solvd.interfaces;

import com.solvd.models.TestDrive;

import java.util.List;

public interface iTestDriveDAO extends IBaseDAO<TestDrive> {
List<TestDrive> getTestDrivesByEmployeeID(int id);
}
