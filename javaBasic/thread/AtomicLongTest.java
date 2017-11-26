package com.meizu.thirdparty;

import java.util.concurrent.atomic.AtomicLong;

/**
 * @describe :
 * @usage :
 * <p>
 * </p>
 * Created by caixi on 17-11-17.
 */

public class AtomicLongTest {

    public static void main(String[] args) {
        AtomicLong atoLong = new AtomicLong();
        atoLong.set(10000);
        System.out.printf("%20s : %s\n", "get()", atoLong.get());
        System.out.printf("%20s : %s\n", "intValue()", atoLong.intValue());
        System.out.printf("%20s : %s\n", "longValue()", atoLong.longValue());
        System.out.printf("%20s : %s\n", "doubleValue()", atoLong.doubleValue());
        System.out.printf("%20s : %s\n", "floatValue()", atoLong.floatValue());

        System.out.printf("%20s : %s\n", "getAndDecrement()", atoLong.getAndDecrement());
        System.out.printf("%20s : %s\n", "decrementAndGet()", atoLong.decrementAndGet());
        System.out.printf("%20s : %s\n", "getAndIncrement()", atoLong.getAndIncrement());
        System.out.printf("%20s : %s\n", "incrementAndGet()", atoLong.incrementAndGet());

        System.out.printf("%20s : %s\n", "addAndGet(0x10)", atoLong.addAndGet(16));
        System.out.printf("%20s : %s\n", "getAndAdd(0x10)", atoLong.getAndAdd(16));

        System.out.printf("\n%20s : %s\n", "get()", atoLong.get());

        System.out.printf("%20s : %s\n", "compareAndSet()", atoLong.compareAndSet(10032, 10032));
        System.out.printf("%20s : %s\n", "get()", atoLong.get());
    }
}
