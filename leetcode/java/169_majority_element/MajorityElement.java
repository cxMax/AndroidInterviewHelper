package com.meizu.thirdparty;

import java.util.Arrays;

/**
 * @describe : 找出数组出现最多的元素
 * @usage :
 * <p>
 * </p>
 * Created by caixi on 17-12-12.
 */

public class MajorityElement {

    public int majorityElement(int[] nums) {
        Arrays.sort(nums);
        return nums[nums.length/2];
    }

    /**
     * Moore voting algorithm
     * @param nums
     * @return
     */
    public int majorityElement1(int[] nums) {
        int ret = 0;
        int count = 0;
        for (int num : nums){
            if (count == 0) {
                ret = num;
            }
            if (num != ret) {
                count--;
            } else {
                count++;
            }
        }
        return ret;
    }

}
