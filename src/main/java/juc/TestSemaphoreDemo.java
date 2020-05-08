package juc;

import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;

public class TestSemaphoreDemo {
    public static void main(String[] args) {
        int total = 10;
        int spot = 2;
        Semaphore semaphore = new Semaphore(spot);
        for (int i = 1; i <=total; i++) {
            new Thread(()->{
                try {
                    semaphore.acquire();
                    System.out.println(Thread.currentThread().getName()+ "停车");
                    TimeUnit.SECONDS.sleep(2);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }finally {
                    semaphore.release();
                    System.out.println(Thread.currentThread().getName()+ "释放车位");
                }
            },"T"+i).start();
        }
    }
}

/*
    int total = 10;
    int bufTotal = 2;
    Semaphore semaphore = new Semaphore(bufTotal);

        for (int i = 1; i <= total; i++) {
                new Thread(() -> {
                try {
                // acquire 得到
                semaphore.acquire();
                System.out.println(Thread.currentThread().getName() + " got buff");
                TimeUnit.SECONDS.sleep(2);
                System.out.println(Thread.currentThread().getName() + " lost buff");
                } catch (InterruptedException e) {
                e.printStackTrace();
                } finally {
                // release 释放
                semaphore.release();
                }
                }, "t" + i).start();
                }
       */
