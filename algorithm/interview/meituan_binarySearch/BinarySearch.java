/**
 * @describe :
 * @usage :
 * <p>
 * <p>
 * Created by cxmax on 2017/12/2.
 */

public class BinarySearch {

    // 非递归
    public static int binarySearch(int[] array,int fromIndex,int toIndex,int value){
        int low = fromIndex;
        int heigh = toIndex - 1;
        while (low <= heigh) {
            int mid = (low + heigh) >>> 1;
            int midVal = array[mid];
            if (midVal < value) {
                low = mid + 1;
            } else if (midVal > value) {
                heigh = mid - 1;
            } else {
                return mid;
            }
        }
        return -1;
    }

    // 递归实现
    public static int binarySearch1(int[] array,int fromIndex,int toIndex,int value){
        if (fromIndex > toIndex) {
            return -1;
        }
        int mid = (fromIndex + toIndex) >>> 1;
        if (array[mid] < value) {
            return binarySearch(array, mid + 1, toIndex, value);
        } else if (array[mid] > value) {
            return binarySearch1(array, fromIndex, mid - 1, value);
        } else {
            return mid;
        }
    }

    public static void main(String[] args){
        int[] a={2,3,5,7,9,13,18};
        System.out.println(binarySearch(a,0,7,18));
        System.out.println(binarySearch1(a,0,7,18));
    }
}
