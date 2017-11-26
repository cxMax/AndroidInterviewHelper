package com.meizu.thirdparty;

import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @describe :
 * @usage :
 * <p>
 * </p>
 * Created by caixi on 17-11-24.
 */

public class ConcurrentHashMapTest {

    private static Map<String, String> map = new ConcurrentHashMap<String, String>();

    public static void main(String[] args) {

        // 同时启动两个线程对map进行操作！
        new MyThread("ta").start();
        new MyThread("tb").start();
    }

    private static void printAll() {
        String key, value;
        Iterator iter = map.entrySet().iterator();
        while (iter.hasNext()) {
            Map.Entry entry = (Map.Entry) iter.next();
            key = (String) entry.getKey();
            value = (String) entry.getValue();
            System.out.print(key + " - " + value + ", ");
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
                String val = Thread.currentThread().getName() + i;
                map.put(String.valueOf(i), val);
                // 通过“Iterator”遍历map。
                printAll();
            }
        }
    }
}
