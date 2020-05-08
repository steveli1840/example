package juc;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

public class TestCycliBarrier {
    public static void main(String[] args) {
        int total = 5;
        CyclicBarrier cyclicBarrier = new CyclicBarrier(total,()->{
           System.out.println("发起进攻");
        });

        for (int i = 1; i <= 5; i++) {
            new Thread(()->{
                System.out.println(Thread.currentThread().getName()+ "大招已经好了");
                try {
                    cyclicBarrier.await();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } catch (BrokenBarrierException e) {
                    e.printStackTrace();
                }
            },"t"+i).start();
        }
    }
}

/*
    int total = 5;
    CyclicBarrier cyclicBarrier = new CyclicBarrier(total, () -> {
        System.out.println("发起进攻！");
    });

        for (int i = 1; i <= total; i++) {
                new Thread(() -> {
                System.out.println(Thread.currentThread().getName() + "大招已经好了！");
                try {
                cyclicBarrier.await();
                } catch (InterruptedException | BrokenBarrierException e) {
                e.printStackTrace();
                }
                }, "t" + i).start();
                }*/
