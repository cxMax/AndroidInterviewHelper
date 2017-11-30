/**
 * @describe :
 * @usage :
 * <p>
 * <p>
 * Created by cxmax on 2017/11/30.
 */

public class CountPrimes {

    public static void main(String[] args) {

    }

    public int countPrimes(int n) {
        int count = 0;
        for (int i = 2; i < n; i++) {
            if (isPrime(i)) {
                count++;
            }
        }
        return count;
    }

    private static boolean isPrime(int x) {
        if (x <= 1) {
            return false;
        }
        for (int i = 2; i * i <= x; i++) {
            if (x % i == 0) {
                return false;
            }
        }
        return true;
    }
}
