package com.solvd.parser;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.XMLConstants;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.stream.StreamSource;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;
import javax.xml.validation.Validator;
import java.io.File;
import java.io.IOException;

public class DOMParser {

    private static final Logger LOGGER = LogManager.getLogger(DOMParser.class);

    public static void parse() {
        String xsdFile = "src/main/resources/xml/xsd/car-sale.xsd";
        String xmlFile = "src/main/resources/xml/car-sale.xml";
        if (validate(xsdFile, xmlFile)) {
            LOGGER.info("Validated");
        } else {
            LOGGER.info("Not Validated");
        }
        File file = new File(xmlFile);
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        try {
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document document = builder.parse(file);
            document.getDocumentElement().normalize();

            NodeList customerList = document.getElementsByTagName("customer");
            for (int i = 0; i < customerList.getLength(); i++) {
                Node customerNode = customerList.item(i);
                if (customerNode.getNodeType() == Node.ELEMENT_NODE) {
                    Element customerElement = (Element) customerNode;
                    LOGGER.info("Customer ID: " + customerElement.getAttribute("id"));
                    LOGGER.info("First Name: " + customerElement.getElementsByTagName("firstName").item(0).getTextContent());
                    LOGGER.info("Last Name: " + customerElement.getElementsByTagName("lastName").item(0).getTextContent());
                }
            }

            NodeList employeeList = document.getElementsByTagName("employee");
            for (int i = 0; i < employeeList.getLength(); i++) {
                Node employeeNode = employeeList.item(i);
                if (employeeNode.getNodeType() == Node.ELEMENT_NODE) {
                    Element employeeElement = (Element) employeeNode;
                    LOGGER.info("Employee ID: " + employeeElement.getAttribute("id"));
                    LOGGER.info("First Name: " + employeeElement.getElementsByTagName("firstName").item(0).getTextContent());
                    LOGGER.info("Last Name: " + employeeElement.getElementsByTagName("lastName").item(0).getTextContent());
                    NodeList positionList = employeeElement.getElementsByTagName("position");
                    for (int j = 0; j < positionList.getLength(); j++) {

                        Node positionNode = positionList.item(j);
                        if (positionNode.getNodeType() == Node.ELEMENT_NODE) {
                            Element positionElement = (Element)positionNode;
                            LOGGER.info("Position ID: " + positionElement.getAttribute("id"));
                            LOGGER.info("Position Name: " + positionElement.getElementsByTagName("positionName").item(0).getTextContent());
                        }
                    }
                }
            }

            NodeList carList = document.getElementsByTagName("car");
            for (int i = 0; i < carList.getLength(); i++) {
                Node carNode = carList.item(i);
                if (carNode.getNodeType() == Node.ELEMENT_NODE) {
                    Element carElement = (Element) carNode;
                    LOGGER.info("Car ID: " + carElement.getAttribute("id"));
                    LOGGER.info("Price: " + carElement.getElementsByTagName("price").item(0).getTextContent());
                    LOGGER.info("Model: " + carElement.getElementsByTagName("model").item(0).getTextContent());
                    LOGGER.info("Year: " + carElement.getElementsByTagName("year").item(0).getTextContent());
                    LOGGER.info("Is Sold: " + carElement.getElementsByTagName("isSold").item(0).getTextContent());
                    boolean isSold = Boolean.parseBoolean(carElement.getElementsByTagName("isSold").item(0).getTextContent());

                    NodeList carTypeList = carElement.getElementsByTagName("carType");
                    for (int j = 0; j < carTypeList.getLength(); j++) {
                        Node carTypeNode = carTypeList.item(j);
                        if (carTypeNode.getNodeType() == Node.ELEMENT_NODE) {
                            Element carTypeElement = (Element) carTypeNode;
                            LOGGER.info("Car Type ID: " + carTypeElement.getAttribute("id"));
                            LOGGER.info("Car Type Name: " + carTypeElement.getElementsByTagName("carType").item(0).getTextContent());
                        }
                    }

                    NodeList manufacturerList = carElement.getElementsByTagName("manufacturer");
                    for (int j = 0; j < manufacturerList.getLength(); j++) {
                        Node manufacturerNode = manufacturerList.item(j);
                        if (manufacturerNode.getNodeType() == Node.ELEMENT_NODE) {
                            Element manufacturerElement = (Element) manufacturerNode;
                            LOGGER.info("Manufacturer ID: " + manufacturerElement.getAttribute("id"));
                            LOGGER.info("Manufacturer Name: " + manufacturerElement.getElementsByTagName("manufacturerName").item(0).getTextContent());
                        }
                    }
                }
            }
        } catch (ParserConfigurationException | IOException | SAXException e) {
            throw new RuntimeException(e);
        }
    }

    public static boolean validate(String xsdFile, String xmlFile) {
        try {
            SchemaFactory factory = SchemaFactory.newInstance(XMLConstants.W3C_XML_SCHEMA_NS_URI);
            Schema schema = factory.newSchema(new File(xsdFile));
            Validator validator = schema.newValidator();
            validator.validate(new StreamSource(new File(xmlFile)));
        } catch (IOException | SAXException e) {
            LOGGER.info(e);
            return false;
        }
        return true;
    }
}
