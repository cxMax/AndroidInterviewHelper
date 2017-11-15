package com.meizu.thirdparty;

import java.util.Stack;

/**
 * @describe :
 * @usage :
 * <p>
 * </p>
 * Created by caixi on 17-11-1.
 */

public class ValidParentheses {

    /*
     * Given a string containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is vali
     *
     * example :  valid : {s}
     *            invalid : (s}
     * reference : http://www.jianshu.com/p/eb206b2f2ae2
     */
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        for (char character: s.toCharArray()) {
            if (character == '{') {
                stack.push('}');
            } else if (character == '[') {
                stack.push(']');
            } else if (character == '(') {
                stack.push(')');
            } else if (stack.isEmpty() || stack.pop() != character) {
                return false;
            }
        }
        return stack.isEmpty();
    }
}
