package com.yang.eduservice.entity;

import java.util.concurrent.CountDownLatch;

public class CountDownLatchDemo {



    public static void main(String[] args) throws InterruptedException{
        CountDownLatch countDownLatch = new CountDownLatch(4);
        for (int i = 1; i <=4 ; i++) {
            new Thread(()->{
                System.out.println(Thread.currentThread().getName()+" 来了！");
                countDownLatch.countDown();
            },Country_Enum.forEach_Enum(i).getName()).start();
        }

        countDownLatch.await();
        System.out.println("秦国一统天下！");
    }
}
