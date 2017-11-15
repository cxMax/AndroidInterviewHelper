package com.meizu.thirdparty;

/**
 * @describe :
 * @usage :
 * <p>
 * </p>
 * Created by caixi on 17-10-30.
 */

public class LongestCommonPrefix {

    /*
     * Write a function to find the longest common prefix string amongst an array of strings.
     *
     * for example : {leets,  leetcode, leetc, leeds}
     * references : http://www.jianshu.com/p/63dcc0d7db75
     */
    public String longestCommonPrefix(String[] strs) {

        if (strs == null || strs.length <= 0) {
            return null;
        }
        int minLength = Integer.MAX_VALUE;
        for (String str : strs) {
            minLength = Math.min(minLength, str.length());
        }

        int low = 1;
        int high = minLength;
        while(low <= high) {
            int middle = (low + high) / 2;
            if (isCommonPrefix(strs, middle)) {
                low = middle + 1;
            } else {
                high = middle - 1;
            }
        }
        return strs[0].substring(0, (low + high) / 2);
    }

    private boolean isCommonPrefix(String[] strs, int len){
        String str1 = strs[0].substring(0, len);
        for (int i = 1; i< strs.length; i++) {
            if (!strs[i].startsWith(str1)) {
                return false;
            }
        }
        return true;
    }

}
