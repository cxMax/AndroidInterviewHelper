package com.meizu.thirdparty;

/**
 * @describe :
 * @usage :
 * <p>
 * </p>
 * Created by caixi on 17-12-8.
 */

public class MergeTwoSortedArray {

    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int last1 = m - 1;
        int last2 = n - 1;
        int sumLast = m + n - 1;

        while (last1 > -1 && last2 > -1) {
            nums1[sumLast--] = nums1[last1] < nums2[last2] ? nums2[last2--] : nums1[last1--];
        }
        while (last2 > -1) {
            nums1[sumLast--] = nums2[last2--];
        }
    }
}
