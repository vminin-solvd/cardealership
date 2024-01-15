package com.solvd.parser.jaxb;

import com.solvd.JAXBMain;
import com.solvd.models.Car;
import com.solvd.models.CarSale;
import com.solvd.models.Customer;
import com.solvd.models.Employee;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import java.io.File;

public class JAXBParser {

    private final static Logger LOGGER = LogManager.getLogger(JAXBParser.class);

    public static void marshal(CarSale carSale){
        try {
            JAXBContext context = JAXBContext.newInstance(CarSale.class, Customer.class, Employee.class, Car.class);
            Marshaller marshaller = context.createMarshaller();
            marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
            marshaller.marshal(carSale, new File(System.getProperty("user.dir") + "/src/main/resources/carSaleOutput.xml"));
        } catch(JAXBException e) {
            throw new RuntimeException(e);
        }
    }

    public static CarSale unmarshal() {
        CarSale carSale;
        try {
            JAXBContext context = JAXBContext.newInstance(CarSale.class, Customer.class, Employee.class, Car.class);
            carSale = (CarSale) context.createUnmarshaller().unmarshal(new File(System.getProperty("user.dir") + "/src/main/resources/carSaleOutput.xml"));
        } catch (JAXBException e) {
            throw new RuntimeException(e);
        }
        return carSale;
    }
}
