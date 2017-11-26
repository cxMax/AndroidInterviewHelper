package com.meizu.thirdparty;

import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.ConcurrentSkipListSet;

/**
 * @describe :
 * @usage :
 * <p>
 * </p>
 * Created by caixi on 17-11-24.
 */

public class ConcurrentSkipListSetTest {

    private static Set<String> set = new ConcurrentSkipListSet<String>();

    public static void main(String[] args) {

        // 同时启动两个线程对set进行操作！
        new MyThread("a").start();
        new MyThread("b").start();
    }

    private static void printAll() {
        String value = null;
        Iterator iter = set.iterator();
        while (iter.hasNext()) {
            value = (String) iter.next();
            System.out.print(value + ", ");
        }
        System.out.println();
    }

    private static class MyThread extends Thread {
        MyThread(String name) {
            super(name);
        }

        @Override
        public void run() {
            int i = 0;
            while (i++ < 10) {
                // “线程名” + "序号"
                String val = Thread.currentThread().getName() + (i % 6);
                set.add(val);
                // 通过“Iterator”遍历set。
                printAll();
            }
        }
    }
}
