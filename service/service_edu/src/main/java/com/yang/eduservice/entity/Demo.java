package com.yang.eduservice.entity;


import java.util.Random;
import java.util.concurrent.atomic.AtomicInteger;

public class Demo {
    public static void main(String[] args) throws Exception{
        AtomicInteger atomicInteger = new AtomicInteger(2);
        boolean b = atomicInteger.compareAndSet(2, 4);
        System.out.println(b);
        System.out.println(atomicInteger.get());

    }

    public static void stackOverError(){
        stackOverError();
    }
}
