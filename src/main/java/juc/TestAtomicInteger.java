package juc;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

public class TestAtomicInteger {
    private static AtomicInteger atomicInteger =  new AtomicInteger(0);

    public static void main(String[] args) {
        for (int i = 1; i <= 10; i++) {
            new Thread(()->{
                for (int j = 0; j < 1000 ; j++) {
                    add();
                }
            }).start();
        }
/*        try {
            TimeUnit.SECONDS.sleep(2);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }*/
        while (Thread.activeCount()>2){}
        System.out.println(atomicInteger.get());
    }

    static void add(){
        atomicInteger.incrementAndGet();
    }
}


/*
    private static AtomicInteger atomicInteger = new AtomicInteger(0);

    public static void main(String[] args) {
        for (int i = 1; i <= 10; i++) {
            new Thread(() -> {
                for (int j = 0; j < 1000; j++) {
                    add();
                }
            }, "t" + i).start();
        }
        try { TimeUnit.SECONDS.sleep(2); } catch (InterruptedException e) { e.printStackTrace(); }

        System.out.println(atomicInteger.get());
    }

    private static void add() {
        atomicInteger.incrementAndGet();
    }*/
