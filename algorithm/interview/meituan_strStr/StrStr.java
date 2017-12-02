/**
 * @describe : 字符串匹配
 * @usage :
 * <p>
 * <p>
 * Created by cxmax on 2017/12/2.
 */

public class StrStr {

    /**
     *
     * @param haystack 整体字符串
     * @param needle 匹配字符串
     * @return 匹配字符串的起始位置
     */
    public static int strStr(String haystack, String needle) {
        if (haystack == null || needle == null || haystack.length() < needle.length()) {
            return -1;
        }
        if (needle.length() == 0) {
            return 0;
        }
        int dif = haystack.length() - needle.length();
        for (int i = 0; i <= dif; i++) {
            if (haystack.substring(i, i + needle.length()).equals(needle)) {
                return i;
            }
        }
        return -1;
    }


    public static void main(String[] args){
        String x1 = "hello";
        String x2 = "ll";
        System.out.println(strStr(x1, x2));
    }
}
