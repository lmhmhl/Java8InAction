package optional;

import java.util.*;

import static java.util.stream.Collectors.toList;

/**
 * @program: java8demo
 * @description:
 * @author: LMH
 * @create: 2021-05-12
 **/
public class example {


    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(1, 2, 3);
        //Optional<List<Integer>> list1 = Optional.of(list);
        Optional<List> optCar = Optional.empty();
        List list1 = optCar.orElse(Arrays.asList(12, 3));
        System.out.println(list1);

        Optional<List<Integer>> list2 = Optional.ofNullable(list);
        List<Integer> list3 = list2.orElse(Arrays.asList(1, 23, 4));
        System.out.println(list3);
        Optional<Integer> integer = list2.map(List::size);
        List<Integer> collect = list2.get().stream().map(n -> n + 1).collect(toList());
        System.out.println(collect);
        integer.ifPresent(System.out::println);

        func();
    }

    public static void func() {
        Map<String, Integer> map = new HashMap<>();
        map.put("2", 2);
        map.put("1", 1);
        Optional<Integer> integer = Optional.ofNullable(map.get("3"));
        System.out.println(integer.orElse(0));
        if (map.get("3") != null) {
            System.out.println(map.get("3"));
        } else {
            System.out.println(0);
        }
    }

    public static void func1() {
        Properties props = new Properties();
        props.setProperty("a", "5");
        props.setProperty("b", "true");
        props.setProperty("c", "-3");

    }

    public int readDuration(Properties props, String name) {
        return Optional.ofNullable(props.getProperty(name))
                .flatMap(str -> Optional.of(Integer.parseInt(str))).filter(i -> i > 0)
                .orElse(0);
    }
}