package com.cybertek.utilities;

import java.io.FileInputStream;
import java.util.Properties;

public class Configurations_Reader {

    private static Properties properties;

    static {
        try {
            String path = "configuration.properties";
            FileInputStream input = new FileInputStream(path);
            properties = new Properties();
            properties.load(input);
            input.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    public static String getKey(String keyName){
        return properties.getProperty(keyName);
    }
}
