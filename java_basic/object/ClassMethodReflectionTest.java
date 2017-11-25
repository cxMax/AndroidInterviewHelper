package com.meizu.thirdparty;

import java.lang.reflect.Method;

/**
 * @describe :
 * @usage :
 * <p>
 * </p>
 * Created by caixi on 17-11-25.
 */

public class ClassMethodReflectionTest {

    public static void main(String[] args) {

        // getDeclaredMethod() 的测试函数
        testGetDeclaredMethod() ;

        // getMethod() 的测试函数
        testGetMethod() ;

        // getEnclosingMethod() 的测试函数
        testGetEnclosingMethod() ;
    }

    /**
     * getDeclaredMethod() 的测试函数
     */
    public static void testGetDeclaredMethod() {
        try {
            // 获取Person类的Class
            Class<?> cls = Class.forName("com.meizu.thirdparty.ClassMethodReflectionTest.Person");
            // 根据class，调用类的默认构造函数(不带参数)
            Object person = cls.newInstance();

            // 获取Person中的方法
            Method mSetName = cls.getDeclaredMethod("setName", new Class[]{String.class});
            Method mGetName = cls.getDeclaredMethod("getName", new Class[]{});
            Method mSetAge  = cls.getDeclaredMethod("setAge", new Class[]{int.class});
            Method mGetAge  = cls.getDeclaredMethod("getAge", new Class[]{});
            Method mSetGender = cls.getDeclaredMethod("setGender", new Class[]{Gender.class});
            Method mGetGender = cls.getDeclaredMethod("getGender", new Class[]{});

            // 调用获取的方法
            mSetName.invoke(person, new Object[]{"Jimmy"});
            mSetAge.invoke(person, new Object[]{30});
            mSetGender.setAccessible(true);    // 因为Person中setGender()是private的，所以这里要设置为可访问
            mSetGender.invoke(person, new Object[]{Gender.MALE});
            String name = (String)mGetName.invoke(person, new Object[]{});
            Integer age = (Integer)mGetAge.invoke(person, new Object[]{});
            mGetGender.setAccessible(true);    // 因为Person中getGender()是private的，所以这里要设置为可访问
            Gender gender = (Gender)mGetGender.invoke(person, new Object[]{});

            // 打印输出
            System.out.printf("%-30s: person=%s, name=%s, age=%s, gender=%s\n",
                    "getDeclaredMethod()", person, name, age, gender);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * getMethod() 的测试函数
     */
    public static void testGetMethod() {
        try {
            // 获取Person类的Class
            Class<?> cls = Class.forName("com.skywang.test.Person");
            // 根据class，调用类的默认构造函数(不带参数)
            Object person = cls.newInstance();

            // 获取Person中的方法
            Method mSetName = cls.getMethod("setName", new Class[]{String.class});
            Method mGetName = cls.getMethod("getName", new Class[]{});
            //Method mSetAge  = cls.getMethod("setAge", new Class[]{int.class});         // 抛出异常，因为setAge()是protected权限。
            //Method mGetAge  = cls.getMethod("getAge", new Class[]{});                  // 抛出异常，因为getAge()是protected权限。
            //Method mSetGender = cls.getMethod("setGender", new Class[]{Gender.class}); // 抛出异常，因为setGender()是private权限。
            //Method mGetGender = cls.getMethod("getGender", new Class[]{});             // 抛出异常，因为getGender()是private权限。

            // 调用获取的方法
            mSetName.invoke(person, new Object[]{"Phobe"});
            //mSetAge.invoke(person, new Object[]{38});
            //mSetGender.invoke(person, new Object[]{Gender.FEMALE});
            String name = (String)mGetName.invoke(person, new Object[]{});
            //Integer age = (Integer)mGetAge.invoke(person, new Object[]{});
            //Gender gender = (Gender)mGetGender.invoke(person, new Object[]{});

            // 打印输出
            System.out.printf("%-30s: person=%s\n",
                    "getMethod()", person);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * getEnclosingMethod() 的测试函数
     */
    public static void testGetEnclosingMethod() {
        try {
            // 获取Person类的Class
            Class<?> cls = Class.forName("com.skywang.test.Person");
            // 根据class，调用类的默认构造函数(不带参数)
            Object person = cls.newInstance();

            // 根据class，调用Person类中有内部类InnerB的函数
            Method mGetInner = cls.getDeclaredMethod("getInner", new Class[]{});

            // 根据构造函数，创建相应的对象
            mGetInner.invoke(person, new Object[]{});

            System.out.printf("%-30s: person=%s\n",
                    "getEnclosingMethod", person);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    enum Gender{
        MALE, FEMALE
    }

    class Person {
        private Gender gender;  // 性别
        private int age;        // 年龄
        private String name;    // 姓名

        public Person() {
            this("unknown", 0, Gender.FEMALE);
        }
        public Person(String name, int age, Gender gender) {
            this.name = name;
            this.age = age;
            this.gender = gender;
        }

        // 获取”姓名“。权限是 public
        public String getName() {
            return name;
        }
        // 设置”姓名“。权限是 public
        public void setName(String name) {
            this.name = name;
        }
        // 获取”年龄“。权限是 protected
        protected int getAge() {
            return age;
        }
        // 设置”年龄“。权限是 protected
        protected void setAge(int age) {
            this.age = age;
        }
        // 获取“性别”。权限是 private
        private Gender getGender() {
            return gender;
        }
        // 设置“性别”。权限是 private
        private void setGender(Gender gender) {
            this.gender = gender;
        }


        // getInner() 中有内部类InnerB，用来测试getEnclosingMethod()
        public void getInner() {
            // 内部类
            class InnerB{
            }
            // 获取InnerB的Class对象
            Class cls = InnerB.class;

            // 获取“封闭该内部类(InnerB)”的构造方法
            Method cst = cls.getEnclosingMethod();

            System.out.println("call--\"getInner()\" cst="+cst);
        }


        @Override
        public String toString() {
            return "("+name+", "+age+", "+gender+")";
        }
    }
}
