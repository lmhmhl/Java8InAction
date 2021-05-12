package designPattern.observer;

/**
 * @program: java8demo
 * @description:
 * @author: LMH
 * @create: 2021-05-11
 **/
public interface Subject {
    void registerObserver(Observer o);

    void notifyObservers(String tweet);
}
