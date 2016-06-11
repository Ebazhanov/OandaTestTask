package com.oanda.utils;

import com.oanda.basetest.SeleniumBaseTestClass;

import java.io.*;
import java.util.Properties;

/**
 * Created by Evgeny  on 28.05.2016 9:15
 * .
 */

public class PropertiesReader {

    protected final static Properties prop = new Properties();

    public static String getProperty(String key) {
        return prop.getProperty(key);
    }

    @SuppressWarnings("TryFinallyCanBeTryWithResources")
    public static void readPropertiesFileWithAccountsTestData() throws IOException {
        InputStream inputStream = SeleniumBaseTestClass.class.getClassLoader().getResourceAsStream("testdata.properties");
        try {
            Reader reader = new InputStreamReader(inputStream, "UTF-8");
            try {
                prop.load(reader);
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
        } finally {
            inputStream.close();
        }
    }
}
