package com.meizu.thirdparty;

/**
 * @describe :
 * @usage :
 * <p>
 * </p>
 * Created by caixi on 17-11-25.
 */

public class ClassReflectionTest {

    public static void main(String[] args) {

        try {
            // 方法1：Class.forName("类名字符串")  （注意：类名字符串必须是全称，包名+类名）
            //Class cls1 = Class.forName("com.skywang.test.Person");
            Class<?> cls1 = Class.forName("com.meizu.thirdparty.ClassReflectionTest.Person");
            //Class<Person> cls1 = Class.forName("com.skywang.test.Person");

            // 方法2：类名.class
            Class cls2 = Person.class;

            // 方法3：实例对象.getClass()
            Person person = new Person();
            Class cls3 = person.getClass();

            // 方法4："类名字符串".getClass()
            String str = "com.meizu.thirdparty.ClassReflectionTest.Person";
            Class cls4 = str.getClass();

            System.out.printf("cls1=%s, cls2=%s, cls3=%s, cls4=%s\n", cls1, cls2, cls3, cls4);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    static class Person {
        public Person() {
            System.out.println("create Person");
        }
    }
}
