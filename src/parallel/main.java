package parallel;

import java.util.Optional;
import java.util.function.Function;
import java.util.stream.LongStream;
import java.util.stream.Stream;

/**
 * @program: java8demo
 * @description:
 * @author: LMH
 * @create: 2021-05-08
 **/
public class main {
    public static void main(String[] args) {
        System.out.println(measureSumPerf(main::rangedSum, 10_000_000));
        System.out.println(measureSumPerf(main::parallelRangedSum, 10_000_000));
    }

    public static long sum(long n) {
        Optional<Long> reduce = Stream.iterate(1L, i -> i + 1).limit(n).reduce(Long::sum);
        return reduce.get();
    }

    public static long sumParallel(long n) {
        Optional<Long> reduce = Stream.iterate(1L, i -> i + 1L).limit(n).parallel().reduce(Long::sum);
        return reduce.get();
    }

    public static long rangedSum(long n) {
        return LongStream.rangeClosed(1, n).reduce(0L, Long::sum);
    }

    public static long parallelRangedSum(long n) {
        return LongStream.rangeClosed(1, n)
                .parallel()
                .reduce(0L, Long::sum);
    }

    public static long measureSumPerf(Function<Long, Long> adder, long n) {
        long fastest = Long.MAX_VALUE;
        for (int i = 0; i < 10; i++) {
            long start = System.nanoTime();
            long sum = adder.apply(n);
            long duration = (System.nanoTime() - start) / 1_000_000;
            System.out.println("Result: " + sum);
            if (duration < fastest) fastest = duration;
        }
        return fastest;
    }
}
