package juc;

import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;

public class TestConcurrentHashMap {
    public static void main(String[] args) {
        ConcurrentHashMap<String, String> map = new ConcurrentHashMap<>();
        for (int i = 0; i < 10; i++) {
            final int tmp = i;
            new Thread(()->{
                map.put("T"+tmp, UUID.randomUUID().toString());
            }).start();
        }
        while (Thread.activeCount()>2){}
        System.out.println(map);
    }
}
