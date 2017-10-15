package com.meizu;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * @describe :
 * @usage :
 * <p>
 * </p>
 * Created by caixi on 17-10-14.
 */

public class IntersectionOfTwoArrays {

    /*
     * Given two arrays, write a function to compute their intersection.
     *
     *   Example:
     *   Given nums1 = [1, 2, 2, 1], nums2 = [2, 2], return [2].
     *
     *   Note:
     *   Each element in the result must be unique.
     *   The result can be in any order.
     */

    public int[] intersect1(int[] nums1, int[] nums2) {

        Set<Integer> nums1Set = new HashSet<>();
        Set<Integer> intersect = new HashSet<>();

        for (int i = 0; i < nums1.length; i++) {
            nums1Set.add(nums1[i]);
        }

        for (int j = 0; j < nums2.length; j++) {
            if (nums1Set.contains(nums2[j])) {
                intersect.add(nums2[j]);
            }
        }

        int[] result = new int[intersect.size()];
        int i = 0;
        for (Integer num : intersect) {
            result[i++] = num;
        }
        return result;

    }

    public int[] intersect2(int[] nums1, int[] nums2) {
        Set<Integer> intersect = new HashSet<>();

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
        int k = 0;
        for(int num : intersect){
            result[k++] = num;
        }
        return result;

    }


}
