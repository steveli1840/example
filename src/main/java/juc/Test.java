package juc;

public class Test {
    private static int sharedVar = 0;

    public static void main(String[] args) {
        for (int i = 0; i < 10; i++) {
            new Thread(()->{
                for (int j = 0; j < 1000; j++) {
                    add();
                }
            },"T1").start();
        }

        while (Thread.activeCount()>2){}
        System.out.println(sharedVar);
    }

    private static void add() {
        sharedVar++;
    }
}
