package com.meizu;

import java.util.HashMap;
import java.util.Map;

/**
 * @describe :
 * @usage :
 * <p>
 * </p>
 * Created by caixi on 17-10-15.
 */

public class TwoSum {

    /*
     * Given an array of integers, return indices of the two numbers such that they add up to a specific target.
     * Given nums = [2, 7, 11, 15], target = 9,
     *
     * Because nums[0] + nums[1] = 2 + 7 = 9,
     * return [0, 1].
     */

    /* reference : http://www.jianshu.com/p/30b7ebdb89a0 */
    public int[] twoSum(int[] nums, int target) {

        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0 ; i < nums.length; i++) {
            map.put(nums[i] , i);
            if (map.containsKey(target - nums[i])) {
                return new int[]{i , map.get(target - nums[i])};
            }
        }
        return null;
    }


}
