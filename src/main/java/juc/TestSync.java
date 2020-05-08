package juc;

public class TestSync {
    volatile static int a =0;

    public static void main(String[] args) {
        for (int i = 0; i < 10; i++) {
            new Thread(()->{
                for (int j = 0; j < 1000 ; j++) {
                    add();
                }
            }).start();
        }
        while (Thread.activeCount()>2){}
        System.out.println(a);
    }

     static void add(){
        a++;
    }
}


//    private static int sharedVar = 0;
//
//    public static void main(String[] args) {
//        for (int i = 0; i < 10; i++) {
//            new Thread(()->{
//                for (int j = 0; j < 1000; j++) {
//                    add();
//                }
//            }).start();
//        }
//
//        while (Thread.activeCount()>2){}
//        System.out.println(sharedVar);
//    }
//
//    private synchronized static void add() {
//        sharedVar++;
//    }