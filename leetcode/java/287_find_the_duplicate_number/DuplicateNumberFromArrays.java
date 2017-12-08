package com.meizu.thirdparty;

/**
 * @describe : find the duplicate number from an array , and return it
 * @usage :
 * <p>
 * </p>
 * Created by caixi on 17-12-7.
 */

public class DuplicateNumberFromArrays {

    public int findDuplicate(int[] nums) {
        if (nums.length > 1) {
            int low = 0;
            int high = nums.length - 1;
            while (low <= high) {
                int mid = (low + high) >>> 1;
                int cnt = 0;
                for (int a : nums) {
                    if (a <= mid) {
                        ++cnt;
                    }
                }
                if (cnt <= mid) {
                    low = mid + 1;
                } else {
                    high = mid - 1;
                }
            }
            return low;
        }
        return -1;
    }
}
