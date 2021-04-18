package designPattern;

/**
 * @Classname Singleton
 * @Description 静态内部类的方式
 * @Date 2019/11/25 22:49
 * @Created by Tengxq
 */
public class Singleton {
    private Singleton(){

    }

    private static class SingletonHolder{
        private static final Singleton instance = new Singleton();
    }

    public static final Singleton getInstance(){
        return SingletonHolder.instance;
    }
}
