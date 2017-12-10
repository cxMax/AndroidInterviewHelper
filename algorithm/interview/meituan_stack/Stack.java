package com.cxmax.test1;

import java.util.ArrayList;
import java.util.List;

/**
 * @describe : 使用集合的方式实现栈
 * @usage :
 * <p>
 * <p>
 * Created by cxmax on 2017/12/10.
 */

public class Stack {
    private List<String> list;

    public Stack() {
        list = new ArrayList<>();
    }

    public String pop() {
        return list.remove(list.size() - 1);
    }

    public void push(String element) {
        list.add(element);
    }

    public boolean isEmpty() {
        return list.size() == 0;
    }

    public String peek() {
        return list.get(list.size() - 1);
    }
}
