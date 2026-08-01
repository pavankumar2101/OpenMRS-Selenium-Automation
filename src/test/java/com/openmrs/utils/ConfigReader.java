


package com.openmrs.utils;

import java.io.InputStream;
import java.util.Properties;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ConfigReader {

    private static final Logger logger = LoggerFactory.getLogger(ConfigReader.class);


    private static Properties properties;

    static {

        try {

            properties = new Properties();

            String environment = System.getProperty("env","default");


            String fileName;

            if (environment.equals("default")) {
                fileName = "config.properties";
            } else {
                fileName = "config-" + environment + ".properties";
            }

            InputStream input =
                    ConfigReader.class
                            .getClassLoader()
                            .getResourceAsStream(fileName);

            if (input == null) {
                throw new RuntimeException(
                        "Configuration file not found: " + fileName
                );
            }

            properties.load(input);

            logger.info("Configuration loaded successfully",fileName);
            logger.info("Current environment: {}",
                    properties.getProperty("environment"));

        } catch (Exception e) {

            throw new RuntimeException(
                    "Failed to load configuration file",
                    e
            );

        }
    }


    public static String getProperty(String key) {

        return properties.getProperty(key);

    }
}