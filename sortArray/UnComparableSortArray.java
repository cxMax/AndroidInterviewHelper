package com.meizu.thirdparty;

import java.util.ArrayList;
import java.util.Collections;

/**
 * @describe :
 * @usage :
 * <p>
 * </p>
 * Created by caixi on 17-11-8.
 */

public class UnComparableSortArray {

    /*
     * 记数排序 :  计数排序需要占用大量空间，它仅适用于数据比较集中的情况。比如 [0~100]，[10000~19999] 这样的数据
     *
     * 需要三个数组
     *
     * reference : https://www.cnblogs.com/zer0Black/p/6169858.html
     */
    public int[] countSort(int[] array) {
        if (array == null || array.length ==0) {
            return array;
        }

        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;

        //找出数组中的最大最小值
        for (int i = 0; i < array.length; i++) {
            max = Math.max(max, array[i]);
            min = Math.min(min, array[i]);
        }

        int[] help = new int[max];

        //找出每个数字出现的次数
        for (int i = 0; i < array.length; i++) {
            int mapPos = array[i] - min;
            help[mapPos]++;
        }

        int index = 0;
        for (int i = 0; i < help.length; i++) {
            while (help[i]-- > 0) {
                array[index++] = i + min;
            }
        }

        return array;
    }

    /*
     * 桶排序 :
     *
     * reference : http://blog.csdn.net/u010853261/article/details/54933236
     */
    public int[] bucketSort(int[] arr) {
        if (arr == null || arr.length ==0) {
            return arr;
        }

        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        for(int i = 0; i < arr.length; i++){
            max = Math.max(max, arr[i]);
            min = Math.min(min, arr[i]);
        }

        // 数组大小是100
        int[] sorted = new int[max+1];

        for(int i=0; i<arr.length; i++){
            sorted[arr[i]] = arr[i];//把数据放到对应索引的位置
        }

        // 所以这里还得建一个数组来承接
        int[] bucketArr = new int[arr.length];
        int m = 0;
        for (Integer i : sorted) {
            if (i > 0) {
                bucketArr[m] = i;
                m++;
            }
        }


        return bucketArr;
    }

    /*
     * 基数排序 :
     *
     * reference :
     * https://www.cnblogs.com/Braveliu/archive/2013/01/21/2870201.html
     * https://www.cnblogs.com/haozhengfei/p/29ba40edbf659f2dbc6b429c2818c594.html
     */
    public int[] radixSort(int[] arr) {
        if (arr == null || arr.length ==0) {
            return arr;
        }

        int length = arr.length;
        int divisor = 1;// 定义每一轮的除数，1,10,100...
        int[][] bucket = new int[10][length];// 定义了10个桶，以防每一位都一样全部放入一个桶中
        int[] count = new int[10];// 统计每个桶中实际存放的元素个数
        int digit;// 获取元素中对应位上的数字，即装入那个桶
        for (int i = 1; i <= 3; i++) {// 经过4次装通操作，排序完成
            for (int temp : arr) {// 计算入桶
                digit = (temp / divisor) % 10;
                bucket[digit][count[digit]++] = temp;
            }
            int k = 0;// 被排序数组的下标
            for (int b = 0; b < 10; b++) {// 从0到9号桶按照顺序取出
                if (count[b] == 0)// 如果这个桶中没有元素放入，那么跳过
                continue;
                for (int w = 0; w < count[b]; w++) {
                    arr[k++] = bucket[b][w];
                }
                count[b] = 0;// 桶中的元素已经全部取出，计数器归零
            }
            divisor *= 10;
        }
        return arr;
    }
}
