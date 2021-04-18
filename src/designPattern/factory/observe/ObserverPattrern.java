package designPattern.factory.observe;

import java.util.ArrayList;
import java.util.List;

/**
 * @Classname ObserverPattrern
 * @Description 观察者模式
 * @Date 2020/2/7 14:48
 * @Created by Tengxq
 */
public class ObserverPattrern {
    public static void main(String[] args) {

    }


}

//抽象目标
abstract  class Subject{
    protected List<Observer> observers = new ArrayList<>();

    public void add(Observer observer){
        observers.add(observer);
    }

    public void remove(Observer observer){
        observers.remove(observer);
    }

    public abstract void notifyObserver();
}

class ConcreteSubject extends Subject{
    @Override
    public void notifyObserver() {
        
    }
}

interface Observer{
    void response();
}


