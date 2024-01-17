package com.solvd.interfaces;

import com.solvd.factory.*;

public interface CarSaleAbstractFactory {
    CarFactory getCarFactory();
    CarTypeFactory getCarTypeFactory();
    CustomerFactory getCustomerFactory();
    EmployeeFactory getEmployeeFactory();
    ManufacturerFactory getManufacturerFactory();
    PositionFactory getPositionFactory();
}
