package com.meizu.cloud.app.utils.recover;

import java.util.concurrent.atomic.AtomicBoolean;

/**
 * @describe :
 * @usage :
 * <p>
 * </p>
 * Created by caixi on 17-12-21.
 */

public class MyThreadTest {

    public static boolean flag = true;
//    public static AtomicBoolean flag = new AtomicBoolean(true);


    static class MyThread1 extends Thread {
//        @Override
//        public void run() {
//            if (flag) {
//                System.out.println("我成功了！");
//                flag = false;
//            }
//        }
//    }
    }

    //    static class MyThread extends Thread{
//        @Override
//        public void run() {
//            if (flag.compareAndSet(true, false)) {
//                System.out.println("我成功了！");
//            }
//        }
//    }
//
    static Runnable myRunnable = new Runnable() {
        @Override
        public void run() {
            synchronized (MyThreadTest.class) {
                if (flag) {
                    System.out.println("我成功了！");
                    flag = false;
                }
            }
        }
    };

    public static void main(String[] args) {
        for (int j = 0; j < 100; j++) {
            Thread t = new Thread(myRunnable);
            t.start();
        }
    }
}
