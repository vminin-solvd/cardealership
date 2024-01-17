package com.solvd.factory;

import com.solvd.interfaces.CarSaleAbstractFactory;
import com.solvd.models.*;

public class CarSaleFactoryClient {

    public CarSale createCarSale() {
        CarSaleAbstractFactory factory = new CarSaleFactory();
        Position position = factory.getPositionFactory().createPosition(1, "Sales Associate");
        Employee employee = factory.getEmployeeFactory().createEmployee(1, "Pushkin", "Minin", position);
        CarType carType = factory.getCarTypeFactory().createCarType(1, "Sedan");
        Manufacturer manufacturer = factory.getManufacturerFactory().createManufacturer(1, "Lexus");
        Car car = factory.getCarFactory().createCar(1, 20000, "LS430", "2001", true, carType, manufacturer);
        Customer customer = factory.getCustomerFactory().createCustomer(1, "Victor", "Minin");

        CarSale carSale = new CarSale.Builder()
                .setId(1)
                .setCustomer(customer)
                .setEmployee(employee)
                .setCar(car)
                .build();
        return carSale;
    }
}
