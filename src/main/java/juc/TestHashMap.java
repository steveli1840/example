package juc;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;

public class TestHashMap {
    public static void main(String[] args) {
        //1. HashMap 不是安全的
      //  HashMap<String, String> map = new HashMap<>();
        //2. 使用synchronizedMap
       // Map<String, String> map = Collections.synchronizedMap(new HashMap<>());

        //3. 使用ConcurrentHashMap
        ConcurrentHashMap<String, String> map = new ConcurrentHashMap<>();
/*        for (int i = 0; i < 30; i++) {
            map.put("H"+i,UUID.randomUUID().toString().substring(0,8));
            System.out.println(map);
            System.out.println("H"+i+":\t"+map.get("H" + i));
        }*/

        for (int i = 0; i < 30; i++) {
            new Thread(()->{
                map.put(Thread.currentThread().getName(), UUID.randomUUID().toString().substring(0,8));
                System.out.println(map);
            },"T"+i).start();
        }

    }
}
