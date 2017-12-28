package com.meizu.thirdparty;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

public class ClassLoaderTest {

    public static class MyClassLoader extends ClassLoader {
        static {
            System.out.println("MyClassLoader");
        }
        public static final String driver = "/home/im/Desktop/";
        public static final String fileTyep = ".class";

        public Class findClass(String name) {
            byte[] data = loadClassData(name);
            return defineClass(data, 0, data.length);
        }

        public byte[] loadClassData(String name) {
            FileInputStream fis = null;
            byte[] data = null;
            try {
                File file = new File(driver + name + fileTyep);
                System.out.println(file.getAbsolutePath());
                fis = new FileInputStream(file);
                ByteArrayOutputStream baos = new ByteArrayOutputStream();
                int ch = 0;
                while ((ch = fis.read()) != -1) {
                    baos.write(ch);
                }
                data = baos.toByteArray();
            } catch (IOException e) {
                e.printStackTrace();
                System.out.println("loadClassData-IOException");
            }
            return data;
        }

    }

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        System.out.println(Thread.currentThread().getContextClassLoader());
        System.out.println(ClassLoaderTest.class.getClassLoader());
        System.out.println(System.class.getClassLoader());
        System.out.println(ClassLoader.getSystemClassLoader());
        System.out.println(ClassLoader.getSystemClassLoader().getParent());
        System.out.println(ClassLoader.getSystemClassLoader().getParent().getParent());

        testClassLoader();
    }

    private static void testClassLoader () {
        MyClassLoader cl1 = new MyClassLoader();
        //磁盘中/home/im/Desktop/Hello.class文件存在
        try {
            Class c1 = cl1.loadClass("Hello");
            Object object = c1.newInstance();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            System.out.println("main-ClassNotFoundException");
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        }
    }
}
