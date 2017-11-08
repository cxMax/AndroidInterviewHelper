package com.meizu.thirdparty;

/**
 * @describe :
 * @usage :
 * <p>
 * </p>
 * Created by caixi on 17-11-8.
 */

public class OnePlus {

    /*
     * example :
     * 给定 [1,2,3] 表示 123, 返回 [1,2,4].
     * 给定 [9,9,9] 表示 999, 返回 [1,0,0,0].
     *
     * reference : http://www.jianshu.com/p/c822ccebbd2f
     *
     */
    public int[] plusOne(int[] digits) {
        for (int i = digits.length - 1; i >=0; i--) {
            if (digits[i] < 9) {
                digits[i] += 1;
                return digits;
            } else {
                digits[i] = 0;
            }

        }
        int[] result = new int[digits.length + 1];
        result[0] = 1;
        return result;
    }
}
