package niuke.interview;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * @Classname TheadVirtualWakeUp
 * @Description 线程的虚假唤醒，为什么要用whlie判断而不是if
 * 虚假唤醒就是一些obj.wait()会在除了obj.notify()和obj.notifyAll()的其他情况被唤醒，而此时是不应该唤醒的。
 * 解决的办法是基于while来反复判断进入正常操作的临界条件是否满足：
 * @Date 2020/1/1 16:12
 * @Created by Tengxq
 */
public class TheadVirtualWakeUp {
    private List<Integer> list = new ArrayList<>();

    public synchronized void push(int value){
        list.add(value);
        notify();
    }

    public synchronized  int pop(){
        try {
            if (list.size()<1){
                System.out.println(Thread.currentThread().getName()+"正在 pop");
                wait();
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return  list.remove(list.size()-1);
    }

    public static void main(String[] args) {
        TheadVirtualWakeUp test = new TheadVirtualWakeUp();
        new Thread(()->{
            System.out.println(Thread.currentThread().getName()+"正在put");
            test.push(1);
            System.out.println(Thread.currentThread().getName()+"结束put");
        },"A").start();

        new Thread(()->{
            test.pop();
            System.out.println(Thread.currentThread().getName()+"结束 pop");
        },"B").start();

        new Thread(()->{
            test.pop();
            System.out.println(Thread.currentThread().getName()+"结束 pop");
        },"C").start();


    }
}
