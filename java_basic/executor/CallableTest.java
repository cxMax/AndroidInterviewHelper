package com.meizu.thirdparty;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/**
 * @describe :
 * @usage :
 * <p>
 * </p>
 * Created by caixi on 17-11-22.
 */

public class CallableTest {

    static class MyCallable implements Callable {

        @Override
        public Object call() throws Exception {
            int sum = 0;
            // 执行任务
            for (int i = 0; i < 100; i++) {
                sum += i;
            }
            return Integer.valueOf(sum);
        }
    }

    public static void main(String[] args) throws ExecutionException, InterruptedException {

        ExecutorService pool = Executors.newSingleThreadExecutor();
        Callable callable = new MyCallable();
        Future future = pool.submit(callable);
        // 输出结果
        System.out.println(future.get());
        //关闭线程池
        pool.shutdown();

    }
}
