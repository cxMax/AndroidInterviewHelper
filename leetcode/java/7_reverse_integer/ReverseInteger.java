package com.meizu.flyme.gamecenter.fragment;

/**
 * @describe :
 * @usage :
 * <p>
 * </p>
 * Created by caixi on 17-10-17.
 */

public class ReverseInteger {

    /*
     * Reverse digits of an integer.

     * Example1: x = 123, return 321
     * Example2: x = -123, return -321
     */


    /* reference : http://blog.csdn.net/nomasp/article/details/48675979 */
    public int reverse(int x) {

        int reverse = 0;
        while (x != 0) {
            if(reverse > Integer.MAX_VALUE / 10 || reverse < Integer.MIN_VALUE / 10) {
                return 0;

            }
            reverse = reverse * 10 + x % 10;
            x = x / 10;
        }
        return reverse ;
    }

}
