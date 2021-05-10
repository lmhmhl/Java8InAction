package lambda.Fruit;

import lambda.Fruit.Apple;
import lambda.Fruit.Banana;
import lambda.Fruit.Fruit;

import java.util.HashMap;
import java.util.function.Function;

/**
 * @program: java8demo
 * @description:
 * @author: LMH
 * @create: 2021-04-30
 **/

public class hashmap {
    static HashMap<String, Function<Integer, Fruit>> map = new HashMap<>();

    static {
        map.put("apple", Apple::new);
        map.put("banana", Banana::new);
    }

    public static Fruit getFruit(String name, int weight) {
        return map.get(name.toLowerCase()).apply(weight);
    }

    public static void main(String[] args) {
        System.out.println(getFruit("banana",1 ).getClass());
        System.out.println(getFruit("aPple",2));
    }
}