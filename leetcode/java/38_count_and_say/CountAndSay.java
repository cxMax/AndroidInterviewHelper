package com.meizu.thirdparty;

/**
 * @describe :
 * @usage :
 * <p>
 * </p>
 * Created by caixi on 17-11-7.
 */

public class CountAndSay {

    /*
     * The count-and-say sequence is the sequence of integers with the first five terms as following
     *
     * 若不能理解题意 , 请看下面这个链接
     * reference : http://blog.csdn.net/xygy8860/article/details/46821417
     */
    public String countAndSay(int n) {
        if (n == 1) {
            return String.valueOf(1);
        }
        String str = countAndSay(n - 1) + "*";
        char[] c = str.toCharArray();
        int count = 1;

        String say = "";
        for (int i = 0; i< c.length - 1; i++) {
            if (c[i] == c[i + 1]) {
                count++;
            } else {
                say = say + count + c[i];
                count = 1;
            }
        }
        return say;
    }

}
