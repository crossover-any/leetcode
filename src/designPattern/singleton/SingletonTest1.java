package designPattern.singleton;

/**
 * @Classname SingletonTest1
 * @Description  饿汉式（静态常量实现或者静态代码块） 优点：线程安全  缺点：有可能会造成空间浪费的问题
 * @Date 2019/12/30 21:30
 * @Created by Tengxq
 */
public class SingletonTest1 {
    public static void main(String[] args) {

    }

}
class Singleton{

    private final static Singleton instance = new Singleton();

    private Singleton(){

    }

    public Singleton getInstance(){
        return instance;
    }

}
