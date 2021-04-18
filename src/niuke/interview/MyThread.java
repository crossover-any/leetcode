package niuke.interview;

import java.util.concurrent.Callable;
import java.util.concurrent.FutureTask;

/**
 * @Classname MyThread
 * @Description TODO
 * @Date 2020/1/1 18:26
 * @Created by Tengxq
 */
public class MyThread implements Callable<Integer> {
    @Override
    public Integer call() throws Exception {
        System.out.println("****");
        return 1024;
    }

    public static void main(String[] args) throws Exception {
        MyThread myThread = new MyThread();
        FutureTask<Integer> task = new FutureTask<>(myThread);
        System.out.println(task.get());
        new Thread(task).start();
        System.out.println(task.get());
    }
}
