package com.cxmax.popup.library;

import android.util.Log;

/**
 * @describe : 猫扑素数概念 :
 *              1. 以 2 开头, 之后跟任意多个 3 的十进制整数;
 *              2. 素数
 * @usage :
 * <p>
 * <p>
 * Created by cxmax on 2017/11/30.
 */

public class MopNumber {

    public static void main(String[] args) {
        for (int i = 0; i < 1000000000; i++) {
            if (IsMopNumber(i)) {
                if (isPrime(i)) {
                    System.out.println("isMopNumber = "+i);
                }
            }
        }
    }


    public static boolean IsMopNumber(int x) {
        if (x < 10) {
            return false;
        }
        return (x % 10 == 3) && (IsMopNumber(x/10));
    }

    public static boolean isPrime(int x) {
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
