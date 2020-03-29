package com.yang.eduservice.entity;

import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;

public class SemaphoreDemo {
    public static void main(String[] args) {
        Semaphore semaphore = new Semaphore(3);
        for (int i = 0; i <7; i++) {
            new Thread(()->{
                try {
                    semaphore.acquire();
                    System.out.println(Thread.currentThread().getName()+"抢到了！");
                    try {
                        TimeUnit.SECONDS.sleep(3);
                    } catch (InterruptedException e) {

                        e.printStackTrace();
                    }
                    System.out.println(Thread.currentThread().getName()+"抢到后走了！");
                } catch (InterruptedException e) {

                    e.printStackTrace();
                }finally {
                    semaphore.release();
                }
            },String.valueOf(i)).start();
        }
    }
}
