package com.meizu.thirdparty;

/**
 * @describe :
 * @usage :
 * <p>
 * </p>
 * Created by caixi on 17-10-30.
 */

public class RomanToInteger {

    /*
     * Given a roman numeral, convert it to an integer.
     *
     * Input is guaranteed to be within the range from 1 to 3999.
     * 即Ⅰ（1）、X（10）、C（100）、M（1000）、V（5）、L（50）、D（500）。记数的方法：
     *
     * reference : https://github.com/haoel/leetcode/blob/master/algorithms/cpp/romanToInteger/romanToInteger.cpp
     */
    public int romanToInt(String s) {
        if (s.length() <= 0) {
            return 0;
        }
        int result = romanCharToInt(s.charAt(0));

        for (int i = 1; i < s.length(); i++) {
            int prev = romanCharToInt(s.charAt(i - 1));
            int cur = romanCharToInt(s.charAt(i));
            if (prev < cur) {
                result = result - prev + (cur - prev);
            } else {
                result += cur;
            }
        }
        return result;
    }

    private int romanCharToInt(char ch){
        int d = 0;
        switch(ch){
            case 'I':
                d = 1;
                break;
            case 'V':
                d = 5;
                break;
            case 'X':
                d = 10;
                break;
            case 'L':
                d = 50;
                break;
            case 'C':
                d = 100;
                break;
            case 'D':
                d = 500;
                break;
            case 'M':
                d = 1000;
                break;
        }
        return d;
    }
}
