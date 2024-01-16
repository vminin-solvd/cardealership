package com.solvd.parser.jaxb;

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

public class JAXBUtil<T> {

    private final static Logger LOGGER = LogManager.getLogger(JAXBUtil.class);

    public static <T> void marshal(T object, String path) {
        try {
            JAXBContext context = JAXBContext.newInstance(CarSale.class, Customer.class, Employee.class, Car.class);
            Marshaller marshaller = context.createMarshaller();
            marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
            marshaller.marshal(object, new File(path));
        } catch(JAXBException e) {
            throw new RuntimeException(e);
        }
    }

    public static <T> T unmarshal(Class<T> type, String path) {
        try {
            JAXBContext context = JAXBContext.newInstance(type);
            return (T) context.createUnmarshaller().unmarshal(new File(path));
        } catch (JAXBException e) {
            throw new RuntimeException(e);
        }
    }
}
