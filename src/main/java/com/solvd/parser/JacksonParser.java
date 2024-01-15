package com.solvd.parser;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.File;
import java.io.IOException;

import static com.fasterxml.jackson.databind.SerializationFeature.INDENT_OUTPUT;

public class JacksonParser {

    private static final Logger LOGGER = LogManager.getLogger(JacksonParser.class);
    private static ObjectMapper objectMapper = new ObjectMapper();
    private final String path = System.getProperty("user.dir") + "/src/main/resources/carSaleOutput.json";

    static {
        objectMapper.enable(INDENT_OUTPUT);
    }

    public <T> void marshal(T object) {
        try {
            File file = new File(path);
            objectMapper.writeValue(file, object);
        } catch (IOException e) {
            LOGGER.info(e);
        }
    }

    public <T> T unmarshal(Class<T> type) {
        try {
            File file = new File(path);
            return (T) objectMapper.readValue(file, type);
        } catch (IOException e) {
            LOGGER.info(e);
        }
        throw new RuntimeException();
    }
}
