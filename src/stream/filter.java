package stream;

import javax.crypto.spec.PSource;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static java.util.stream.Collectors.toList;

/**
 * @program: java8demo
 * @description:
 * @author: LMH
 * @create: 2021-05-04
 **/
public class filter {
    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(1, 2, 1, 3, 3, 2, 4);
        numbers.stream()
                .filter(i -> i % 2 == 0)
                .distinct().skip(1)
                .forEach(System.out::println);

        List<String> words = Arrays.asList("Java8", "Lambdas", "In", "Action");
        List<Integer> wordLengths = words.stream()
                .map(String::length).collect(toList());
        for (int string : wordLengths) {
            System.out.println(string);
        }
        System.out.println("___________________");
        List<Integer> numbers2 = Arrays.asList(1, 2, 3, 4, 5);
        List<Integer> squares =
                numbers2.stream().map(n -> n * n).collect(toList());

        for (int string : squares) {
            System.out.println(string);
        }
        System.out.println("____________________");
        List<Integer> n1 = Arrays.asList(1, 2, 3);
        List<Integer> n2 = Arrays.asList(3, 4);
        List<int[]> collect = n1.stream().
                flatMap(i -> n2.stream().filter(j -> (i + j) % 3 == 0)
                        .map(j -> new int[]{i, j})).collect(toList());


        List<Integer> someNumbers = Arrays.asList(1, 2, 3, 4, 5);
        Integer integer = someNumbers.stream().map(x -> x * x)
                .filter(x -> x % 3 == 0).findFirst().orElse(1);// 9
        System.out.println(integer);

        int multiply = someNumbers.stream().reduce(1, (a, b) -> a * b);
        System.out.println(multiply);

        Optional<Integer> max = numbers.stream().reduce(Integer::max);
        System.out.println(max.get());


        numbers.stream().count();
        int count = numbers.stream() .map(d -> 1)
                .reduce(0, (a, b) -> a + b);
    }


}
