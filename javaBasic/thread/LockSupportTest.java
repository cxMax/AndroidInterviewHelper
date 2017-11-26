package com.meizu.thirdparty;

import java.util.concurrent.locks.LockSupport;

/**
 * @describe :
 * @usage :
 * <p>
 * </p>
 * Created by caixi on 17-11-17.
 */

public class LockSupportTest {

    private static Thread mainThread;

    public static void main(String[] args) {

        ThreadA ta = new ThreadA("ta");
        // 获取主线程
        mainThread = Thread.currentThread();

        System.out.println(Thread.currentThread().getName() + " start ta");
        ta.start();

        System.out.println(Thread.currentThread().getName() + " block");
        // 主线程阻塞
        LockSupport.park(mainThread);

        System.out.println(Thread.currentThread().getName() + " continue");
    }

    static class ThreadA extends Thread {

        public ThreadA(String name) {
            super(name);
        }

        public void run() {
            System.out.println(Thread.currentThread().getName() + " wakup others");
            // 唤醒“主线程”
            LockSupport.unpark(mainThread);
        }
    }


    public static class ObjectLockTest {
        static class ThreadA extends Thread {

            public ThreadA(String name) {
                super(name);
            }

            public void run() {
                synchronized (this) { // 通过synchronized(this)获取“当前对象的同步锁”
                    System.out.println(Thread.currentThread().getName() + " wakup others");
                    notify();    // 唤醒“当前对象上的等待线程”
                }
            }
        }

        public static void main(String[] args) {

            ThreadA ta = new ThreadA("ta");

            synchronized (ta) { // 通过synchronized(ta)获取“对象ta的同步锁”
                try {
                    System.out.println(Thread.currentThread().getName() + " start ta");
                    ta.start();

                    System.out.println(Thread.currentThread().getName() + " block");
                    // 主线程等待
                    ta.wait();

                    System.out.println(Thread.currentThread().getName() + " continue");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
