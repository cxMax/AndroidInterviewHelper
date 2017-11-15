package com.keyboard3;

import android.text.TextUtils;

/**
 * @describe :
 * @usage :
 * <p>
 * </p>
 * Created by caixi on 17-10-21.
 */

public class PalindromeNumber {


    /*
     * Determine whether an integer is a palindrome. Do this without extra space.
     *
     * eg :
     *  if the input is 1221, if we can revert the last part of the number "1221" from "21" to "12",
     *  and compare it with the first half of the number "12", since 12 is the same as 12,
     *  we know that the number is a palindrome.
     */

    /**
     *
     * @param x  1221
     * @return
     */
    public boolean isPalindrome1(int x) {
        String strX = String.valueOf(x);
        int middle = x % 2 == 0 ? strX.length() / 2 - 1 : strX.length() / 2 ;

        String front = strX.substring(0, middle);

        StringBuilder back = new StringBuilder();

        for (int i = strX.length() - 1; i > middle; i--) {
            back.append(strX.charAt(i));
        }

        return front.equals(back.toString());
    }

    /**
     * 121
     * @param x
     * @return
     */
    public boolean IsPalindrome(int x) {
        if (x < 0 || (x % 10 == 0 && x != 0)) {
            return false;
        }

        int reverse = 0;
        while (x > reverse) {
            reverse = reverse * 10 + x % 10;
            x /= 10 ;
        }

        return x == reverse || x == reverse/10;
    }
}
