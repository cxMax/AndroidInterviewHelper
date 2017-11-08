package com.meizu.thirdparty;

/**
 * @describe :
 * @usage :
 * <p>
 * </p>
 * Created by caixi on 17-11-8.
 */

public class ComparableSortArray {

    /*
     * 冒泡排序 : $O(n^2)$
     *
     * reference : http://www.cnblogs.com/aDiot/p/5232156.html
     */
    public int[] bubbleSort(int[] array) {
        if (array == null || array.length <= 1) {
            return array;
        }
        int length = array.length;
        for (int i = 0; i < length - 1; i++) {
            for (int j = 0; j < length - i - 1 ; j++) {
                if (array[j] > array[j + 1]) {
                    int temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                }
            }
        }
        return array;
    }

    /*
     * 插入排序 : 平均O(n^2),最好O(n),最坏O(n^2);空间复杂度O(1);稳定;简单
     *
     * reference : https://www.cnblogs.com/zengzhihua/p/4456730.html
     */
    public int[] insertSort(int[] array) {
        int temp;
        for (int i = 1; i < array.length; i++) {
            for (int j = i; j > 0; j--) {
                if (array[j] < array[j - 1]) {
                    temp = array[j - 1];
                    array[j - 1] = array[j];
                    array[j] = temp;
                }
            }
        }
        return array;
    }

    /*
     * 快速排序 :
     *
     * reference : https://www.cnblogs.com/xiaoming0601/p/5862860.html
     */
    public int[] quickSort(int[] array) {
        quickSort(array, 0, array.length - 1);
        return array;
    }

    private void quickSort(int[] array, int low, int high) {
        if (low < high) {
            int mid = getMiddle(array, low, high);
            quickSort(array, low, mid - 1);
            quickSort(array, mid + 1, high);
        }
    }

    private int getMiddle(int[] array, int low, int high) {
        int temp = array[low];
        while (low < high) {
            while (low < high && array[high] >= temp) {
                high--;
            }
            array[low] = array[high];
            while (low < high && array[low] <= temp) {
                low++;
            }
            array[high] = array[low];
        }
        array[low] = temp;
        return low;
    }

    /*
     * 选择排序 : $O(n^2)$
     *
     * reference : http://www.cnblogs.com/shen-hua/p/5424059.html
     */
    public int[] selectSort(int[] array) {
        if (array == null || array.length <= 1) {
            return array;
        }
        for (int i = 0; i < array.length - 1; i++) {
            int k = i;
            for (int j = k + 1; j < array.length; j++) {
                if (array[j] < array[k]) {
                    k = j;
                }
            }
            if (i != k) {
                int temp = array[i];
                array[i] = array[k];
                array[k] = temp;
            }
        }
        return array;
    }

    /*
     * 希尔排序 (缩小增量排序) : $[O(n),O(n^2)]$;空间复杂度O(1);不稳定;较复杂
     *
     * reference :
     * http://www.cnblogs.com/zengzhihua/p/4456734.html
     */
    public int[] shellSort(int[] array) {
        int length = array.length;
        int mid = length / 2;

        while (mid > 0) {
            for (int i = mid; i < length; i++) {
                int j = i - mid;
                while (j >= 0 && array[j] > array[j + mid]) {
                    int temp = array[j];
                    array[j] = array[j + mid];
                    array[j + mid] = temp;
                    j = j - mid;
                }
                mid = mid / 2;
            }
        }
        return array;
    }

    /*
     * 归并排序 : $O(nlogn)$
     *
     * reference : https://www.cnblogs.com/shudonghe/p/3302888.html
     */
    public int[] mergeSort(int[] array) {
        return sort(array, 0, array.length - 1);
    }

    private int[] sort(int[] array, int left, int right) {
        if (left >= right) {
            return array;
        }

        int mid = (left + right) / 2;
        sort(array, left, mid);
        sort(array, mid + 1, right);

        return merge(array, left, mid, right);
    }

    private int[] merge(int[] array, int left, int mid, int right) {
        int[] temp = new int[array.length];
        int r1 = mid + 1;
        int tIndex = left;
        int cIndex = left;

        while (left <= mid && r1 <= right) {
            if (array[left] <= array[r1]) {
                temp[tIndex++] = array[left++];
            } else {
                temp[tIndex++] = array[r1++];
            }
        }

        while (left <= mid) {
            temp[tIndex++] = array[left++];
        }

        while(r1 <= right) {
            temp[tIndex++] = array[r1++];
        }

        while(cIndex <= right) {
            array[cIndex] = temp[cIndex];
            cIndex++;
        }

        return array;
    }
}
