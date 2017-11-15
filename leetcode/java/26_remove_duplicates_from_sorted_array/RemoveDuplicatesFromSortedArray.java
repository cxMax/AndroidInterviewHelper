package com.meizu.thirdparty;

/**
 * @describe :
 * @usage :
 * <p>
 * </p>
 * Created by caixi on 17-11-3.
 */

public class RemoveDuplicatesFromSortedArray {

    /*
     * Given a sorted array, remove the duplicates in place such that each element appear only once and return the new length.
     *
     * Do not allocate extra space for another array, you must do this in place with constant memory.
     *
     * reference : https://leetcode.com/problems/remove-element/solution/
     */
    public int removeDuplicates(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        int noDuplicate = 0;
        for (int i = 1; i < nums.length; i ++) {
            if (nums[i] != nums[noDuplicate]) {
                nums[++noDuplicate] = nums[i];
            }
        }
        return noDuplicate + 1;
    }

}
