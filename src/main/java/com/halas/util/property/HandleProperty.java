package com.halas.util.property;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.IOException;
import java.util.Objects;
import java.util.Properties;

public final class HandleProperty {
    private static final String PATH_TO_PROPERTIES = "properties/config.properties";
    private static final Logger LOG = LogManager.getLogger(HandleProperty.class);

    private HandleProperty() {
    }

    public static String getValueProperty(String key) {
        Properties properties = new Properties();
        try {
            properties.load(Objects.requireNonNull(HandleProperty.class.getClassLoader().getResourceAsStream(PATH_TO_PROPERTIES)));
            return properties.getProperty(key);
        } catch (IOException e) {
            LOG.error("File properties does not exist!");
            LOG.error("Class: " + e.getClass());
            LOG.error("Message: " + e.getMessage());
            LOG.error(e.getStackTrace());
        }
        return "";
    }
}
