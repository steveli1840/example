package juc;

import java.util.concurrent.CountDownLatch;

public class TestCoutDownLatch {
    public static void main(String[] args) throws InterruptedException {
        int total = 5;
        CountDownLatch countDownLatch = new CountDownLatch(5);
        for (int i = 1; i <= total; i++) {
            new Thread(()->{
                System.out.println(Thread.currentThread().getName()+"被灭了");
                System.out.println("current account: "+ countDownLatch.getCount());
                countDownLatch.countDown();
            },"T"+i).start();
        }
        countDownLatch.await();
        System.out.println("current account: "+ countDownLatch.getCount());
        System.out.println("execute");
    }
}

/*
    int total = 5;
    CountDownLatch countDownLatch = new CountDownLatch(total);

        for (int i = 1; i <= total; i++) {
                new Thread(() -> {
                System.out.println(Thread.currentThread().getName() + " has been slayed!");
                countDownLatch.countDown();
                }, "t" + i).start();
                }

                countDownLatch.await();

                System.out.println("execute!");
*/

