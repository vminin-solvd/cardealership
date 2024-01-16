package com.solvd;

import com.solvd.models.*;
import com.solvd.parser.jackson.JacksonUtil;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.text.ParseException;

public class JacksonMain {

    private final static Logger LOGGER = LogManager.getLogger(JacksonMain.class);

    public static void main(String[] args) throws ParseException {
        String path = System.getProperty("user.dir") + "/src/main/resources/carSaleOutput.json";
        CarSale carSale = new CarSale();
        carSale.setId(1);
        Customer customer = new Customer();
        customer.setId(1);
        customer.setFirstName("Victor");
        customer.setLastName("Minin");
        carSale.setCustomer(customer);
        Employee employee = new Employee();
        employee.setId(1);
        employee.setFirstName("Pushkin");
        employee.setLastName("Minin");
        Position position = new Position();
        position.setId(1);
        position.setPositionName("Sales Associate");
        employee.setPosition(position);
        carSale.setEmployee(employee);
        Car car = new Car();
        car.setId(1);
        CarType carType = new CarType();
        carType.setId(1);
        carType.setCarType("Sedan");
        car.setCarType(carType);
        car.setPrice(20000);
        car.setModel("LS430");
        Manufacturer manufacturer = new Manufacturer();
        manufacturer.setId(1);
        manufacturer.setManufacturerName("Lexus");
        car.setManufacturer(manufacturer);
        car.setSold(true);
        car.setYear("2001");
        carSale.setCar(car);

        JacksonUtil jacksonParser = new JacksonUtil();
        jacksonParser.marshal(carSale, path);
        carSale = jacksonParser.unmarshal(CarSale.class, path);
        LOGGER.info("CarSale: " + carSale);
    }
}
