package com.meizu.thirdparty;

/**
 * @describe :
 * @usage :
 * <p>
 * </p>
 * Created by caixi on 17-11-7.
 */

public class SearchInsertPosition {

    /*
     * Given a sorted array and a target value, return the index if the target is found.
     * If not, return the index where it would be if it were inserted in order.
     *
     * example : Input: [1,3,5,6], 5 ; Output: 2
     *
     * 有序数组找目标值 , 一般用二分查找算法来实现 ;
     *
     * reference :
     *
     * 二分查找算法 : http://blog.csdn.net/as02446418/article/details/47428737
     * solution : https://leetcode.com/problems/search-insert-position/discuss/
     *
     */
    public int searchInsert(int[] nums, int target) {
        int low = 0;
        int high = nums.length;

        while (low < high) {
            int middle = (low + high) / 2;
            if (nums[middle] < target) {
                low = middle + 1;
            } else {
                high = middle;
            }
        }
        
        return low;

    }
}
