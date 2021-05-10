package stream.samples;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import static java.util.Comparator.comparing;
import static java.util.Comparator.comparingInt;
import static java.util.stream.Collectors.*;

/**
 * @program: java8demo
 * @description:
 * @author: LMH
 * @create: 2021-05-06
 **/
public class main {
    public static void main(String[] args) {
        Trader raoul = new Trader("Raoul", "Cambridge");
        Trader mario = new Trader("Mario", "Milan");
        Trader alan = new Trader("Alan", "Cambridge");
        Trader brian = new Trader("Brian", "Cambridge");
        List<Transaction> transactions = Arrays.asList(
                new Transaction(brian, 2011, 300),
                new Transaction(raoul, 2012, 1000),
                new Transaction(raoul, 2011, 400),
                new Transaction(mario, 2012, 710),
                new Transaction(mario, 2012, 700),
                new Transaction(alan, 2012, 950)
        );

        //primativeStream(transactions);
        //numericRanges();
        //funGouGu();
        //streamGenerate();
        //fabbnaci();
        //summarizingInt1(transactions);
        // joining1(transactions);
        // groupingBy1(transactions);
        //Map<Boolean, List<Integer>> booleanListMap = partitionPrimes(44);
    }

    public static List<Transaction> findAndSort(List<Transaction> transactions) {
        return transactions.stream().filter(t -> t.getYear() == 2011).
                sorted(comparing((Transaction::getValue))).collect(toList());
    }

    public static Set<String> findUniqueCity(List<Transaction> transactions) {
        // return transactions.stream().map(t->t.getTrader().getCity()).distinct().collect(toList());
        return transactions.stream().map(t -> t.getTrader().getCity()).collect(toSet());
    }

    public static List<Trader> findByName(List<Transaction> transactions) {
        return transactions.stream().map(Transaction::getTrader).filter(t -> t.getCity().equals("Cambridge")).
                distinct().sorted(comparing(Trader::getName)).collect(toList());
    }

    public static String sortByName(List<Transaction> transactions) {
        String traderStr = transactions.stream()
                .map(transaction -> transaction.getTrader().getName()).distinct()
                .sorted()
                .collect(joining());

        return transactions.stream().map((t -> (t.getTrader().getName()))).distinct()
                .sorted().reduce("", (n1, n2) -> (n1 + n2));
    }

    public static boolean findAnyMilan(List<Transaction> transactions) {
        return transactions.stream().anyMatch(transaction -> transaction.getTrader().getCity().equals("Milan"));
    }

    public static void printTraderName(List<Transaction> transactions) {
        transactions.stream().filter(t -> t.getTrader().getCity().equals("Milan")).map(Transaction::getValue)
                .forEach(System.out::println);
    }

    public static int getHighestValue(List<Transaction> transactions) {
        Optional<Integer> maxVal = transactions.stream().map(Transaction::getValue).distinct().reduce(Integer::max);
        return maxVal.get();
    }

    public static int getSmallestValue(List<Transaction> transactions) {
        transactions.stream().map(Transaction::getValue).distinct().reduce((a, b) -> a > b ? b : a);
        return transactions.stream().min(comparing(Transaction::getValue)).get().getValue();
    }

    public static int sum(List<Transaction> transactions) {
        return transactions.stream().map(Transaction::getValue).reduce(0, Integer::sum);
    }

    public static void primativeStream(List<Transaction> transactions) {
        int maxCalories = transactions.stream().mapToInt(Transaction::getValue).max().orElse(1);
        System.out.println(maxCalories);
    }

    public static void numericRanges() {
        IntStream intStream = IntStream.rangeClosed(1, 100).filter(i -> i % 2 == 0);
        int sum = intStream.sum();
        System.out.println(sum);
    }

    public static void funGouGu() {
        Stream<int[]> pythagoreanTriples =
                IntStream.rangeClosed(1, 100).boxed().flatMap(a ->
                        IntStream.rangeClosed(a, 100)
                                .filter(b -> Math.sqrt(a * a + b * b) % 1 == 0).mapToObj(b ->
                                new int[]{a, b, (int) Math.sqrt(a * a + b * b)}));
        pythagoreanTriples.limit(5).forEach(t -> System.out.println(t[0] + " " + t[1] + " " + t[2]));
    }

    public static void streamGenerate() {
        Stream<String> stream = Stream.of("Java 8 ", "Lambdas ", "In ", "Action");//flux
        stream.map(String::toUpperCase).forEach(System.out::println);
        Stream<String> emptyStream = Stream.empty();//mono
        int[] numbers = {2, 3, 4, 5, 6, 7, 8};
        int sum = Arrays.stream(numbers).sum();

        Stream.iterate(0, n -> n + 2)
                .limit(10).forEach(System.out::println);

    }

    public static void fabbnaci() {
        Stream.iterate(new int[]{0, 1},
                t -> new int[]{t[1], t[0] + t[1]})
                .limit(10)
                .map(t -> t[0]).forEach(System.out::println);


        Stream.generate(Math::random)
                .limit(5).forEach(System.out::println);
    }

    public static void grouping(List<Transaction> transactions) {
        Map<Currency, List<Transaction>> transactionsByCurrencies = transactions.stream().collect(groupingBy(Transaction::getCurrency));
    }

    public static void summarizingInt1(List<Transaction> transactions) {
        IntSummaryStatistics collect = transactions.stream().collect(summarizingInt(Transaction::getValue));
        System.out.println(collect);
    }

    public static void joining1(List<Transaction> transactions) {
        String collect = transactions.stream().map(transaction -> transaction.getTrader().getName()).collect(joining(","));
        System.out.println(collect);
    }

    public static void summingWithReducing(List<Transaction> transactions) {
        Integer reduce = transactions.stream().map(Transaction::getValue).reduce(0, Integer::sum);
    }

    public static void option(List<Transaction> transactions) {
        Optional<Integer> res = transactions.stream().map(Transaction::getValue).reduce(Integer::sum);
        Integer integer = res.orElse(1);
    }

    public static void groupingBy1(List<Transaction> transactions) {
        Map<Trader, Long> collect = transactions.stream().collect(Collectors.groupingBy(Transaction::getTrader, counting()));
        System.out.println(collect);
        //group by trader and find the trader by max value in correspond group.
        Map<Trader, Optional<Transaction>> res = transactions.stream().collect(groupingBy(Transaction::getTrader, maxBy(comparingInt(Transaction::getValue))));
        Map<Trader, Transaction> res1 = transactions.stream().collect(groupingBy(Transaction::getTrader, collectingAndThen(maxBy(comparingInt(Transaction::getValue)), Optional::get)));
        System.out.println(res1);
        Set<String> collect1 = res.values().stream().map(t -> t.get().getTrader().getName()).collect(toSet());
        System.out.println(collect1);

        Integer size = transactions.stream().collect(collectingAndThen(toList(), List::size));
    }

    public static boolean isPrime(int candidate) {
        int candidateRoot = (int) Math.sqrt(candidate);
        return IntStream.rangeClosed(2, candidateRoot).boxed().noneMatch(i -> candidate % i == 0);
    }

    public static Map<Boolean, List<Integer>> partitionPrimes(int n) {
        return IntStream.rangeClosed(2, n).boxed().collect(partitioningBy(can -> isPrime(can)));
    }



}