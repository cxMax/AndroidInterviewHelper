package com.meizu.thirdparty;

/**
 * @describe :
 * @usage :
 * <p>
 * </p>
 * Created by caixi on 17-11-16.
 */

public class ArrayQueue {

    private int[] array;
    private int count;

    public ArrayQueue(int sz) {
        array = new int[sz];
        count = 0;
    }

    // 将val添加到队列的末尾
    public void add(int val) {
        array[count++] = val;
    }

    // 返回“队列开头元素”
    public int front() {
        return array[0];
    }

    // 返回“栈顶元素值”，并删除“栈顶元素”
    public int pop() {
        int ret = array[0];
        count--;
        for (int i = 1; i < count; i++) {
            array[i - 1] = array[i];
        }
        return ret;
    }

    // 返回“栈”的大小
    public int size() {
        return count;
    }

    // 返回“栈”是否为空
    public boolean isEmpty() {
        return size() == 0;
    }

    public static class ArrayQueueTest {
        public static void main(String[] args) {
            int tmp = 0;
            ArrayQueue astack = new ArrayQueue(12);

            // 将10, 20, 30 依次推入栈中
            astack.add(10);
            astack.add(20);
            astack.add(30);

            // 将“栈顶元素”赋值给tmp，并删除“栈顶元素”
            tmp = astack.pop();
            System.out.printf("tmp=%d\n", tmp);

            // 只将“栈顶”赋值给tmp，不删除该元素.
            tmp = astack.front();
            System.out.printf("tmp=%d\n", tmp);

            astack.add(40);

            System.out.printf("isEmpty()=%b\n", astack.isEmpty());
            System.out.printf("size()=%d\n", astack.size());
            while (!astack.isEmpty()) {
                System.out.printf("size()=%d\n", astack.pop());
            }
        }
    }
}
