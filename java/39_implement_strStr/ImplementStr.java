package com.meizu.thirdparty;

import android.text.TextUtils;

import java.util.Objects;

/**
 * @describe :
 * @usage :
 * <p>
 * </p>
 * Created by caixi on 17-11-6.
 */

public class ImplementStr {

    /*
     *  Return the index of the first occurrence of needle in haystack, or -1 if needle is not part of haystack.
     *
     *  example : Input: haystack = "hello", needle = "ll" ; Output: 2
     *
     *  reference : KMP算法 : http://www.jianshu.com/p/8146e8598490
     */
    public int strStr(String haystack, String needle) {
        if (haystack != null && needle != null) {
            int l1 = haystack.length(), l2 = needle.length();
            if (l1 < l2) {
                return -1;
            } else if (l2 == 0) {
                return 0;
            }
            int threshold = l1 - l2;
            for (int i = 0; i <= threshold; ++i) {
                if (haystack.substring(i, i + l2).equals(needle)) {
                    return i;
                }
            }

        }
        return -1;
    }

}
