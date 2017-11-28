package com.meizu.thirdparty;

/**
 * @describe :
 * @usage :
 * <p>
 * </p>
 * Created by caixi on 17-11-28.
 */

public class UnComparableSortArray {

    /*
     * 记数排序 :  计数排序需要占用大量空间，它仅适用于数据比较集中的情况。比如 [0~100]，[10000~19999] 这样的数据
     *
     * 需要三个数组
     *
     * reference : https://www.cnblogs.com/zer0Black/p/6169858.html
     */
    public static void countSort(int[] array) {
        if (array == null || array.length == 0) {
            return;
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

    }

    /*
     * 桶排序 :
     *
     * reference : http://www.cnblogs.com/skywang12345/p/3602737.html
     */
    public static void bucketSort(int[] arr, int max) {
        int[] buckets;

        if (arr == null || arr.length == 0 || max < 1)
            return;

        // 创建一个容量为max的数组buckets，并且将buckets中的所有数据都初始化为0。
        buckets = new int[max];

        // 1. 计数
        for (int i = 0; i < arr.length; i++)
            buckets[arr[i]]++;

        // 2. 排序
        for (int i = 0, j = 0; i < max; i++) {
            while ((buckets[i]--) > 0) {
                arr[j++] = i;
            }
        }

        buckets = null;

    }

    /*
     * 基数排序 :
     *
     * reference :
     * https://www.cnblogs.com/Braveliu/archive/2013/01/21/2870201.html
     * https://www.cnblogs.com/haozhengfei/p/29ba40edbf659f2dbc6b429c2818c594.html
     */
    public static void radixSort(int[] arr) {
        if (arr == null || arr.length == 0) {
            return;
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
    }

    public static void main(String[] args) {
        int i;
        int[] a = {20, 40, 30, 10, 60, 50};
        System.out.printf("before sort:");
        for (i = 0; i < a.length; i++)
            System.out.printf("%d ", a[i]);
        System.out.printf("\n");

//        countSort(a);
//        bucketSort(a, 100);
        radixSort(a);

        System.out.printf("after  sort:");
        for (i = 0; i < a.length; i++)
            System.out.printf("%d ", a[i]);
        System.out.printf("\n");
    }
}
