package niuke.interview;

import java.util.concurrent.TimeUnit;

/**
 * @Classname DeadLock
 * @Description TODO
 * @Date 2020/1/1 23:11
 * @Created by Tengxq
 */
class DeadThread implements Runnable{
    private String lockA;
    private String lockB;
    public DeadThread(String lockA,String lockB){
        this.lockA = lockA;
        this.lockB = lockB;
    }
    @Override
    public void run() {
        synchronized (lockA){
            System.out.println(Thread.currentThread().getName()+"已经获得了"+lockA);
            try { TimeUnit.SECONDS.sleep(2); } catch (InterruptedException e) { e.printStackTrace(); }
            
            synchronized (lockB){
                System.out.println(Thread.currentThread().getName()+"已经获得了"+lockB);
            }
        }
    }
}
public class DeadLock {
    public static void main(String[] args) {
        String lockA = "lockA";
        String lockB = "lockB";
        DeadThread deadThreadA = new DeadThread(lockA,lockB);
        DeadThread deadThreadB = new DeadThread(lockB,lockA);
        new Thread(deadThreadA,"AAA").start();
        new Thread(deadThreadB,"BBB").start();
    }
}
