package com.solvd;

import com.solvd.factory.CarFactory;
import com.solvd.models.*;
import com.solvd.parser.jackson.JacksonUtil;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.text.ParseException;

public class JacksonMain {

    private final static Logger LOGGER = LogManager.getLogger(JacksonMain.class);

    public static void main(String[] args) throws ParseException {
        String path = System.getProperty("user.dir") + "/src/main/resources/carSaleOutput.json";
        Position position = new Position.Builder()
                .setId(1)
                .setPositionName("Sales Associate")
                .build();
        Employee employee = new Employee.Builder()
                .setId(1)
                .setFirstName("Pushkin")
                .setLastName("Minin")
                .setPosition(position)
                .build();
        CarType carType = new CarType.Builder()
                .setId(1)
                .setCarType("Sedan")
                .build();
        Manufacturer manufacturer = new Manufacturer.Builder()
                .setId(1)
                .setManufacturerName("Lexus")
                .build();
        CarFactory carFactory = new CarFactory();
        Car car = carFactory.createCar(1,20000, "LS430", "2001", true, carType, manufacturer);
        Customer customer = new Customer.Builder()
                .setId(1)
                .setFirstName("Victor")
                .setLastName("Minin")
                .build();
        CarSale carSale = new CarSale.Builder()
                .setId(1)
                .setCustomer(customer)
                .setEmployee(employee)
                .setCar(car)
                .build();
        JacksonUtil jacksonParser = new JacksonUtil();
        jacksonParser.marshal(carSale, path);
        carSale = jacksonParser.unmarshal(CarSale.class, path);
        LOGGER.info("CarSale: " + carSale);
    }
}
