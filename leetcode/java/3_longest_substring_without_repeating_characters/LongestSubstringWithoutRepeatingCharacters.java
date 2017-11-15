package com.cxmax.danmakuview.library.utils;

import java.util.HashSet;
import java.util.TreeSet;

/**
 * @describe :
 * @usage :
 * <p>
 * <p>
 * Created by cxmax on 2017/10/17.
 */

public class LongestSubstringWithoutRepeatingCharacters {

    /*
     * Given a string, find the length of the longest substring without repeating characters.
     *  Examples:
     *
     *  Given "abcabcbb", the answer is "abc", which the length is 3.
     */


    public int lengthOfLongestSubstring(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }

        HashSet<Character> result = new HashSet<>();
        int max = 0;
        int start = 0;

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (!result.contains(c)) {
                result.add(c);
            } else {
                max = Math.max(max , result.size());
                while (start < i && s.charAt(start) != c) {
                    result.remove(s.charAt(start));
                    start++;
                }
                start++;
            }
        }

        max = Math.max(max , result.size());
        return max;
    }

}
