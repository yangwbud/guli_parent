package com.yang.eduservice;

import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.Enumeration;
import java.util.Properties;
import java.util.ResourceBundle;

public class Demo {
    @Test
    public void d1(){
        ResourceBundle ct = ResourceBundle.getBundle("ct");
        Enumeration<String> keys = ct.getKeys();
        while (keys.hasMoreElements()){
            String key = keys.nextElement();
            String value = ct.getString(key);
            System.out.println("key is: "+key+" and value is: "+value);
        }
    }

    @Test
    public void d2() throws IOException {
        InputStream inputStream = Thread.currentThread().getContextClassLoader().getResourceAsStream("ct.properties");

        Properties prop = new Properties();
        prop.load(inputStream);
        Enumeration<String> keys = (Enumeration<String>) prop.propertyNames();
        while (keys.hasMoreElements()){
            String key = keys.nextElement();
            String value = prop.getProperty(key);

            System.out.println("******************");
            System.out.println("the key is: "+key+" and the value is: "+value);
        }


    }
}
