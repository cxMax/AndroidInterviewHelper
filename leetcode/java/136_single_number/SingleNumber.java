package com.meizu.thirdparty;

/**
 * @describe : 一个数组, 数组里面的元素有连续出现两次的, 找出只出现一次的元素
 * @usage :
 * <p>
 * </p>
 * Created by caixi on 17-12-27.
 */

public class SingleNumber {

    public int singleNumber(int[] nums) {
        int ans = 0;
        int len = nums.length;
        for (int i = 0; i < len; i++) {
            ans ^= nums[i];
        }
        return ans;
    }
}
