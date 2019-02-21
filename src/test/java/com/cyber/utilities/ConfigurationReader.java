package com.cyber.utilities;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ConfigurationReader {
    private static Properties properties;

    static{

        //this is the path to the location of the file
        String path="configuration.properties";

        try {
            //java can not read files directly ,it needs inputstream to read files
            //inputstream takes the location of the file as a constructor
            FileInputStream fileInputStream=new FileInputStream(path);

            //properrties is used to read spesifically properties files,files with the value pairs
            properties=new Properties();

            //file contents are load the properties from inputstream
            properties.load(fileInputStream);
            //all input stream must be closed
            fileInputStream.close();

        } catch (IOException e) {
            e.printStackTrace();
        }



    }

    //returns the value of spesific property
    public static String getProperty(String property){
        return properties.getProperty(property);

    }
}
