package com.meizu.thirdparty;

/**
 * @describe :
 * @usage :
 * <p>
 * </p>
 * Created by caixi on 17-11-28.
 */

public class ComparableSortArray {

    /*
     * 冒泡排序 : $O(n^2)$
     *
     * reference : http://www.cnblogs.com/skywang12345/p/3596232.html
     */
    public static void bubbleSort(int[] array) {
        if (array == null || array.length <= 1) {
            return;
        }

        int i, j;
        int n = array.length;
        for (i = n - 1; i > 0; i--) {
            // 将a[0...i]中最大的数据放在末尾
            for (j = 0; j < i; j++) {
                if (array[j] > array[j + 1]) {
                    // 交换a[j]和a[j+1]
                    int tmp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = tmp;
                }
            }
        }
    }

    /*
     * 快速排序 :
     *
     * reference : https://www.cnblogs.com/xiaoming0601/p/5862860.html
     */
    public static void quickSort(int[] array) {
        if (array == null || array.length <= 1) {
            return;
        }
        quickSort(array, 0, array.length - 1);
    }

    private static void quickSort(int[] array, int low, int high) {
        if (low < high) {
            int mid = getMiddle(array, low, high);
            quickSort(array, low, mid - 1);
            quickSort(array, mid + 1, high);
        }
    }

    private static int getMiddle(int[] array, int low, int high) {
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
    * 插入排序 : 平均O(n^2),最好O(n),最坏O(n^2);空间复杂度O(1);稳定;简单
    *
    * reference : https://www.cnblogs.com/zengzhihua/p/4456730.html
    */
    public static void insertSort(int[] array) {
        if (array == null || array.length <= 1) {
            return;
        }
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
    }

    /*
     * 希尔排序 (缩小增量排序) : $[O(n),O(n^2)]$;空间复杂度O(1);不稳定;较复杂
     *
     * reference :
     * http://www.cnblogs.com/skywang12345/p/3597597.html
     */
    public static void shellSort(int[] array) {
        if (array == null || array.length <= 1) {
            return;
        }
        int length = array.length;
        // gap为步长，每次减为原来的一半。
        for (int gap = length / 2; gap > 0; gap /= 2) {
            // 共gap个组，对每一组都执行直接插入排序
            for (int i = 0; i < gap; i++) {
                groupSort(array, length, i, gap);
            }
        }
    }

    public static void groupSort(int[] array, int length, int start, int gap) {
        for (int j = start + gap; j < length; j += gap) {
            // 如果a[j] < a[j-gap]，则寻找a[j]位置，并将后面数据的位置都后移。
            if (array[j] < array[j - gap]) {
                int tmp = array[j];
                int k = j - gap;
                while (k >= 0 && array[k] > tmp) {
                    array[k + gap] = array[k];
                    k -= gap;
                }
                array[k + gap] = tmp;
            }
        }
    }

    /*
   * 选择排序 : $O(n^2)$
   *
   * reference : http://www.cnblogs.com/shen-hua/p/5424059.html
   */
    public static void selectSort(int[] array) {
        if (array == null || array.length <= 1) {
            return;
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
    }

    /*
 * 归并排序 : $O(nlogn)$
 *
 * reference : https://www.cnblogs.com/shudonghe/p/3302888.html
 */
    public static void mergeSort(int[] array) {
        if (array == null || array.length <= 1) {
            return;
        }
        sort(array, 0, array.length - 1);
    }

    private static void sort(int[] array, int left, int right) {
        if (left >= right) {
            return;
        }

        int mid = (left + right) / 2;
        sort(array, left, mid);
        sort(array, mid + 1, right);

        merge(array, left, mid, right);
    }

    private static void merge(int[] array, int left, int mid, int right) {
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
    }

    public static void main(String[] args) {
        int i;
        int[] a = {20, 40, 30, 10, 60, 50};
        System.out.printf("before sort:");
        for (i = 0; i < a.length; i++)
            System.out.printf("%d ", a[i]);
        System.out.printf("\n");

//        bubbleSort(a);
//        quickSort(a);
//        insertSort(a);
//        shellSort(a);
//        selectSort(a);
        mergeSort(a);

        System.out.printf("after  sort:");
        for (i = 0; i < a.length; i++)
            System.out.printf("%d ", a[i]);
        System.out.printf("\n");
    }
}
