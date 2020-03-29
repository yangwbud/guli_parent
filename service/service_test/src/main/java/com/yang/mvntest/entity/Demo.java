package com.yang.mvntest.entity;


import com.yang.mvntest.an.Cloumn;
import com.yang.mvntest.an.TName;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;

public class Demo {
    public static void main(String[] args) {
        User user = new User("dayang", 88, "female");
        Class clazz = user.getClass();
        TName tName = (TName) clazz.getAnnotation(TName.class);
        String value = tName.value();
        System.out.println(value);

        Field[] fields = clazz.getDeclaredFields();
        for (Field field : fields) {
            field.setAccessible(true);
            Cloumn annotation = field.getAnnotation(Cloumn.class);
            if(annotation!=null){
                try {
                    Object o = field.get(user);
                    System.out.println(o);
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                }
            }
        }


    }
}
