package juc;

import java.util.*;
import java.util.concurrent.CopyOnWriteArrayList;

public class ArrayListNotSafeDemo {
    public static void main(String[] args) {
        //1.list 不是线程安全的
      //  ArrayList<String> list = new ArrayList<>();
        //2. Vector 是线程安全的，但并发性下降
     //   Vector<String> list = new Vector<>();
        // 3.用synchronizedList
      //  List<String> list = Collections.synchronizedList(new ArrayList<>());
        CopyOnWriteArrayList<String> list = new CopyOnWriteArrayList<>();
        for (int i = 0; i < 30; i++) {
            new Thread(()->{
                list.add(UUID.randomUUID().toString().substring(0,8));
                System.out.println(list);
            },"T"+i).start();
        }
    }
}

/*

    List<String> list = new ArrayList<>();

        for (int i = 0; i < 30; i++) {
        new Thread(() -> {
        list.add(UUID.randomUUID().toString().substring(0, 8));
        System.out.println(list);
        }, String.valueOf(i)).start();
        }
        */
