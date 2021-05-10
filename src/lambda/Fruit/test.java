package lambda.Fruit;

import lambda.Fruit.Apple;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.function.BiPredicate;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

public class test {
    public static void main(String[] args) {
        List<String> str = Arrays.asList("a", "b", "A", "B");
        str.sort(String::compareToIgnoreCase);
        System.out.println(str);
        Function<String, Integer> stringToInteger = Integer::parseInt;
        stringToInteger.apply("88");
        BiPredicate<List<String>, String> contains =
                (list, element) -> list.contains(element);
        func(List::contains, str);
        func1(Apple::new);

        Predicate<Apple> predicate = apple -> apple.color.equals("red");

        Predicate<Apple> predicateNotRed = predicate.negate();

        Predicate<Apple> predicateAnd = predicate.and(Objects::nonNull);

        Predicate<Apple> predicateOr = predicate.or(Objects::isNull);

        Function<Integer,Integer> g=x->x+1;
        Function<Integer,Integer> f=x->x*x;
        Function<Integer, Integer> fgx = g.andThen(f);
        Function<Integer, Integer> gfx = g.compose(f);

        func2(fgx);
        func2(gfx);

    }

    private static void func(BiPredicate<List<String>, String> b, List<String> str) {
        b.test(str, "sf");
    }

    Supplier<Apple> supplier = Apple::new;

    private static Apple func1(Function<Integer, Apple> b) {
        final Apple apply = b.apply(10);
        System.out.println(apply);
        return apply;
    }

    private static void func2(Function<Integer,Integer> function){
        System.out.println(function.apply(12));
    }

}
