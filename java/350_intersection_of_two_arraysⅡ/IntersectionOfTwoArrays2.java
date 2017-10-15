package com.meizu;

import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;
import java.util.Stack;

/**
 * @describe :
 * @usage :
 * <p>
 * </p>
 * Created by caixi on 17-10-14.
 */
public class IntersectionOfTwoArrays2 {

    /*
     * Given two arrays, write a function to compute their intersection.
     *
     *   Example:
     *   Given nums1 = [1, 2, 2, 1], nums2 = [2, 2], return [2, 2].
     *
     *   Note:
     *   Each element in the result should appear as many times as it shows in both arrays.
     *   The result can be in any order.
     */

    /* wrong solution */
    public int[] intersect1(int[] nums1, int[] nums2) {
        Set<Integer> nums1Set = new HashSet<>();
        LinkedList<Integer> intersect = new LinkedList<>();

        for (int i = 0; i < nums1.length; i++) {
            nums1Set.add(nums1[i]);
        }

        for (int i = 0; i < nums2.length; i++) {
            if (nums1Set.contains(nums2[i])) {
                intersect.add(nums2[i]);
            }
        }

        int[] result = new int[intersect.size()];
        int pos = 0;
        for (Integer num: intersect) {
            result[pos] = num;
            pos++;
        }
        return result;
    }

    /* reference : http://www.jianshu.com/p/42e05094bbaa */
    public int[] intersect2(int[] nums1, int[] nums2) {

        List<Integer>  intersect = new LinkedList<>();

        Arrays.sort(nums1);
        Arrays.sort(nums2);

        int i = 0;
        int j = 0;

        while (i < nums1.length && j < nums2.length) {
            if (nums1[i] < nums2[j]) {
                i++;
            } else if (nums1[i] > nums2[j]) {
                j++;
            } else {
                intersect.add(nums1[i]);
                i++;
                j++;
            }
        }

        int[] result = new int[intersect.size()];
        int m = 0;

        for (Integer num: intersect) {
            result[m] = num;
            m++;
        }

        return result;
    }
}
