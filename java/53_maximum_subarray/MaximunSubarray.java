package com.meizu.thirdparty;

/**
 * @describe :
 * @usage :
 * <p>
 * </p>
 * Created by caixi on 17-11-7.
 */

public class MaximunSubarray {

    /*
     * Find the contiguous subarray within an array (containing at least one number) which has the largest sum.
     *
     * example : [-2,1,-3,4,-1,2,1,-5,4] ; [4,-1,2,1] has the largest sum = 6.
     *
     * reference :
     */
    public int maxSubArray(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int max = Integer.MIN_VALUE;
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            if (sum < 0) {
                sum = nums[i];
            } else {
                sum += nums[i];
            }
            if (sum > max) {
                max = sum;
            }
        }
        return max;
    }

}
