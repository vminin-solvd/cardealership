package com.solvd.factory;

import com.solvd.interfaces.CarSaleAbstractFactory;

public class CarSaleFactory implements CarSaleAbstractFactory {

    @Override
    public CarFactory getCarFactory() {
        return new CarFactory();
    }

    @Override
    public CarTypeFactory getCarTypeFactory() {
        return new CarTypeFactory();
    }

    @Override
    public CustomerFactory getCustomerFactory() {
        return new CustomerFactory();
    }

    @Override
    public EmployeeFactory getEmployeeFactory() {
        return new EmployeeFactory();
    }

    @Override
    public ManufacturerFactory getManufacturerFactory() {
        return new ManufacturerFactory();
    }

    @Override
    public PositionFactory getPositionFactory() {
        return new PositionFactory();
    }
}
