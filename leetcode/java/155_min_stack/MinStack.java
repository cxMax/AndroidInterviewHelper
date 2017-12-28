package com.meizu.thirdparty;

import java.util.Stack;

public class MinStack {

    static class Element {
        final int value;
        final int min;

        Element(final int value, final int min) {
            this.value = value;
            this.min = min;
        }
    }

    final Stack<Element> stack = new Stack<>();

    public void push(int x) {
        final int min = stack.empty() ? x : Math.min(stack.peek().min,  x);
        stack.push(new Element(x, min));
    }

    public void pop()
    {
        stack.pop();
    }

    public int top()
    {
        return stack.peek().value;
    }

    public int getMin()
    {
        return stack.peek().min;
    }

}
