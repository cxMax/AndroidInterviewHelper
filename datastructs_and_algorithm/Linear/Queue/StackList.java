package com.meizu.thirdparty;

import java.util.Stack;

/**
 * @describe :
 * @usage :
 * <p>
 * </p>
 * Created by caixi on 17-11-16.
 */

public class StackList<T> {

    // 向队列添加数据时：(01) 将“已有的全部数据”都移到in中。 (02) 将“新添加的数据”添加到in中。
    private Stack<T> in = null;
    // 从队列获取元素时：(01) 将“已有的全部数据”都移到out中。(02) 返回并删除out栈顶元素。
    private Stack<T> out = null;

    // 统计计数
    private int count = 0;

    public StackList() {
        in = new Stack<T>();
        out = new Stack<T>();
        count = 0;
    }

    // 将t添加到队列中
    public void add(T t) {
        // 将“已有的全部数据”都移到in中
        while (!out.empty())
            in.push(out.pop());

        // 将“新添加的数据”添加到in中
        in.push(t);
        // 统计数+1
        count++;
    }

    // 返回队列开头的元素
    public T front() {
        // 将“已有的全部数据”都移到out中
        while (!in.empty())
            out.push(in.pop());

        // 返回out栈顶元素
        return out.peek();
    }

    // 删除并返回队列开头的元素
    public T pop() {
        // 将“已有的全部数据”都移到out中
        while (!in.empty())
            out.push(in.pop());
        // 统计数-1
        count--;

        // 返回并删除out栈顶元素
        return out.pop();
    }

    public int size() {
        return count;
    }

    public boolean isEmpty() {
        return count == 0;
    }

    public static class StackListTest {

        public static void main(String[] args) {
            int tmp;
            StackList<Integer> slist = new StackList<Integer>();

            // 将10, 20, 30 依次推入栈中
            slist.add(10);
            slist.add(20);
            slist.add(30);

            // 将“队列开头的元素”赋值给tmp，并删除“该元素”
            tmp = slist.pop();
            System.out.printf("tmp()=%d\n", tmp);

            // 只将“队列开头的元素”赋值给tmp，不删除该元素.
            tmp = slist.front();
            System.out.printf("tmp()=%d\n", tmp);

            slist.add(40);

            System.out.printf("isEmpty()=%b\n", slist.isEmpty());
            System.out.printf("size()=%d\n", slist.size());
            while (!slist.isEmpty()) {
                System.out.printf("%d\n", slist.pop());
            }
        }
    }
}
