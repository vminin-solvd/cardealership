package com.solvd;

import com.solvd.models.*;
import com.solvd.parser.jaxb.JAXBUtil;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.text.ParseException;

public class JAXBMain {
        private final static Logger LOGGER = LogManager.getLogger(JAXBMain.class);

        public static void main(String[] args) throws ParseException {
                String path = System.getProperty("user.dir") + "/src/main/resources/carSaleOutput.xml";
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
                Car car = new Car.Builder()
                        .setId(1)
                        .setIsSold(true)
                        .setCarType(carType)
                        .setYear("2001")
                        .setPrice(20000)
                        .setModel("LS430")
                        .setManufacturer(manufacturer)
                        .build();
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
                JAXBUtil jaxbParser = new JAXBUtil();
                jaxbParser.marshal(carSale, path);
                carSale = (CarSale) JAXBUtil.unmarshal(CarSale.class, path);
                LOGGER.info("CarSale: " + carSale);
        }
}
