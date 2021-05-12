package designPattern.observer;

import java.util.ArrayList;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @program: java8demo
 * @description:
 * @author: LMH
 * @create: 2021-05-11
 **/
public class Feed implements Subject {
    private ConcurrentHashMap<String, Observer> map = new ConcurrentHashMap<>();

    @Override
    public void registerObserver(Observer o) {
        map.putIfAbsent(o.toString(),o);
    }

    @Override
    public void notifyObservers(String tweet) {
        map.forEach((s, observer) -> observer.notify(tweet));
    }
}
