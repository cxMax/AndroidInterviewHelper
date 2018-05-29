package com.smartisan.filemanager.tablet.search;

import java.util.Arrays;

/**
 * @desribe :
 * @usage :
 * <p>
 *     Input: [1,4,3,2]
 *     Output: 4
 *     4 = min(1, 2) + min(3, 4).
 * </p>
 * Created by caixi on 18-4-20.
 */
public class ArrayPartition {

    public static int arrayPairSum(int[] nums) {
        if (nums.length == 0) return 0;
        Arrays.sort(nums);
        int result = 0;
        for (int i = 0; i < nums.length; i+=2) {
            result += nums[i];
        }
        return result;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{1,4,3,2};
        System.out.println("sum is = " + arrayPairSum(nums));
    }
}
