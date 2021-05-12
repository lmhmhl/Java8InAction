package designPattern.observer;

/**
 * @program: java8demo
 * @description:
 * @author: LMH
 * @create: 2021-05-11
 **/
public class main {
    public static void main(String[] args) {
        Feed f = new Feed();
        f.registerObserver((String tweet)->{if (tweet != null && tweet.contains("wine")) {
            System.out.println("Today cheese, wine and news! " + tweet);
        }});
        f.registerObserver(new Guardian());
        f.registerObserver(new LeMonde());
        f.notifyObservers("The queen said her favourite book is Java 8 in Action!");
    }
}
