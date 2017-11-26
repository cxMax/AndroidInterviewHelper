package com.meizu.thirdparty;

import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/**
 * @describe :
 * @usage :
 * <p>
 * </p>
 * Created by caixi on 17-11-23.
 */

public class CopyOnWriteArrayListTest {

    private static List<String> list = new CopyOnWriteArrayList<String>();

    public static void main(String[] args) {

        // 同时启动两个线程对list进行操作！
        new MyThread("ta").start();
        new MyThread("tb").start();
    }

    private static void printAll() {
        String value = null;
        Iterator iter = list.iterator();
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
            while (i++ < 6) {
                // “线程名” + "-" + "序号"
                String val = Thread.currentThread().getName() + "-" + i;
                list.add(val);
                // 通过“Iterator”遍历List。
                printAll();
            }
        }
    }
}
