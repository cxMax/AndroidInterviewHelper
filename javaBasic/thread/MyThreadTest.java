package com.meizu.thirdparty;

import java.util.concurrent.atomic.AtomicBoolean;

/**
 * 结论： 不加volatile : 多线程操作并非原子性 , 也会进入多次
 *       volatile : 多线程操作并非原子性 , 也会进入多次
 *       AtomicBoolean : 原子操作, 真正的多线程只有一次
 *
 * Created by caixi on 17-12-18.
 */

public class MyThreadTest {

//    public static volatile boolean flag = true;
    public static volatile AtomicBoolean flag = new AtomicBoolean(true);


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

    static class MyThread extends Thread{
        @Override
        public void run() {
            if (flag.compareAndSet(true, false)) {
                System.out.println("我成功了！");
            }
        }
    }

    public static void main(String[] args) {
        for (int j = 0; j < 20; j++) {
            MyThread t = new MyThread();
            t.start();
        }
    }
}
