package com.smartisan.filemanager.model;

import java.util.Arrays;

/**
 * @desribe : 判断两个字符串，是否是由完全相同的英文字母组成， 有可能字母的顺序是颠倒的
 * @usage :
 * <p>
 *     s = "anagram", t = "nagaram", return true.
 *     s = "rat", t = "car", return false.
 * </p>
 * Created by caixi on 18-4-18.
 */
public class ValidAnagram {

    public static boolean isAnagram(String s, String t) {
        if (s == null || s.length() == 0 || t == null || t.length() == 0) {
            return false;
        }
        char[] str1 = s.toCharArray();
        char[] str2 = t.toCharArray();

        Arrays.sort(str1);
        Arrays.sort(str2);
        return Arrays.equals(str1, str2);
    }


    public static void main(String[] args) {
        String s = "anagram";
        String t = "nagaram";
        System.out.println("result = " + isAnagram(s, t));
    }
}
