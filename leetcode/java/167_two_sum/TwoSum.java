package com.meizu.thirdparty;

/**
 * @describe : 排序数组两个子数求和, 值等于目标值, 返回数组
 * @usage :
 * <p>
 * </p>
 * Created by caixi on 18-1-4.
 */

public class TwoSum {

    public int[] twoSum(int[] numbers, int target) {
        int[] result = new int[2];
        if (numbers == null || numbers.length < 2) {
            return result;
        }
        int low = 0;
        int high = numbers.length - 1;
        while (low < high) {
            int total = numbers[low] + numbers[high];
            if (total == target) {
                result[0] = low + 1;
                result[1] = high + 1;
                break;
            } else if (total > target) {
                high--;
            } else {
                low++;
            }
        }
        return result;
    }

}
