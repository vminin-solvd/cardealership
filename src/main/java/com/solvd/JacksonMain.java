package com.solvd;

import com.solvd.models.*;
import com.solvd.parser.JacksonParser;
import com.solvd.factory.CarSaleFactoryClient;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.text.ParseException;

public class JacksonMain {

    private final static Logger LOGGER = LogManager.getLogger(JacksonMain.class);

    public static void main(String[] args) throws ParseException {
        String path = System.getProperty("user.dir") + "/src/main/resources/carSaleOutput.json";
        CarSaleFactoryClient carSaleFactoryClient = new CarSaleFactoryClient();
        CarSale carSale = carSaleFactoryClient.createCarSale();
        JacksonParser jacksonParser = new JacksonParser();
        jacksonParser.marshal(carSale, path);
        carSale = jacksonParser.unmarshal(CarSale.class, path);
        LOGGER.info("CarSale: " + carSale);
    }
}
