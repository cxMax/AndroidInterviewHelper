/**
 * @describe : 反转字符串单词
 * @usage :
 * <p>
 * <p>
 * Created by cxmax on 2017/11/30.
 */

public class ReverseString {

    public static void main(String[] args) {
        reverseString("hello");
    }

    public static String reverseString(String s) {
        if (s == null || s.length() == 0) {
            return "";
        }

        char[] word = s.toCharArray();
        int i = 0;
        int j = s.length() - 1;
        while (i < j) {
            char temp = word[i];
            word[i] = word[j];
            word[j] = temp;
            i++;
            j--;
        }
        return String.valueOf(word);
    }
}
