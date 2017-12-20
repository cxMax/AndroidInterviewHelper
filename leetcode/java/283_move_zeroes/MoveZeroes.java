/**
 * @describe : 把数组中的0 , 移动到数组尾部
 * @usage :
 * <p>
 * <p>
 * Created by cxmax on 2017/12/20.
 */

public class MoveZeroes {

    public static void moveZeroes(int[] nums) {
        if (nums == null || nums.length == 0) return;
        int j = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                int tmp = nums[j];
                nums[j] = nums[i];
                nums[i] = tmp;
                j++;
            }
        }
    }

    public static void main(String[] args) {
        int[] arr = new int[]{0, 1, 0, 3, 5};
        moveZeroes(arr);
        for (Integer i : arr) {
            System.out.println(i);
        }
    }
}
