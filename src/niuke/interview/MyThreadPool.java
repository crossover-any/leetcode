package niuke.interview;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @Classname MyThreadPool
 * @Description TODO
 * @Date 2020/1/1 19:50
 * @Created by Tengxq
 */
public class MyThreadPool {
    public static void main(String[] args) {
        ExecutorService executorService = Executors.newFixedThreadPool(5);

        for (int i = 0; i < 20; i++) {
            executorService.execute(() -> {
                System.out.println(Thread.currentThread().getName() + " 正在办理业务");
            });
        }

        executorService.shutdown();
    }
}
