/**
 * @describe : 给定一个十进制整数N,求出从1到N的所有整数中出现”1”的个数
 *              1. 核心思路就是, 双重循环, 内部循环使用递归的思想, 余数为1
 * @usage :
 * <p>
 * <p>
 * Created by cxmax on 2017/11/30.
 */

public class Count1 {

    public static void main(String[] args) {
        count1(2000);
    }

    public static int count1(int x) {
        if (x < 0) {
            return 0;
        }

        int count = 0;
        int tmp;
        for (int i = 0; i < x; i++) {
            tmp = i;
            while (tmp != 0) {
                if (tmp % 10 == 1) {
                    count++;
                }
                tmp = tmp / 10;
            }
        }

        return count;
    }
}
