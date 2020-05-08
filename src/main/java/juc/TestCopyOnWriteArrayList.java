package juc;

import java.util.UUID;
import java.util.concurrent.CopyOnWriteArrayList;

public class TestCopyOnWriteArrayList {
    public static void main(String[] args) {
        CopyOnWriteArrayList<String> list = new CopyOnWriteArrayList<>();
        for (int i = 1; i <= 10; i++) {
            new Thread(()->{
                list.add(UUID.randomUUID().toString());
            },"T"+i).start();
        }
        while (Thread.activeCount()>2){}
        list.forEach(System.out::println);
    }
}
