package forkjoin;

import parallel.main;

import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.ForkJoinTask;
import java.util.concurrent.RecursiveTask;
import java.util.stream.IntStream;
import java.util.stream.LongStream;

/**
 * @program: java8demo
 * @description:
 * @author: LMH
 * @create: 2021-05-09
 **/
public class ForkJoinCalculator extends RecursiveTask<Long> {

    private final long[] number;
    private final int start;
    private final int end;

    public static final long THRESHOLD = 10_000;

    public ForkJoinCalculator(long[] number) {
        this(number, 0, number.length);
    }

    private ForkJoinCalculator(long[] number, int start, int end) {
        this.number = number;
        this.start = start;
        this.end = end;
    }

    @Override
    protected Long compute() {
        int length = end - start;
        if (length <= THRESHOLD) {
            return computeSequentially();
        }
        ForkJoinCalculator leftTask = new ForkJoinCalculator(number, start, start + length / 2);
        leftTask.fork();
        ForkJoinCalculator rightTask = new ForkJoinCalculator(number, start + length / 2, end);
        Long rightRes = rightTask.compute();
        Long leftRes = leftTask.join();
        return leftRes + rightRes;
    }

    private Long computeSequentially() {
        long sum = 0;
        for (int i = start; i < end; i++) {
            sum += number[i];
        }
        return sum;
    }

    public static long forkJoinSum(long n) {
        long[] numbers = LongStream.rangeClosed(1, n).toArray();
        ForkJoinTask<Long> task = new ForkJoinCalculator(numbers);
        return new ForkJoinPool().invoke(task);
    }

    public static void main(String[] args) {
        System.out.println( main.measureSumPerf(ForkJoinCalculator::forkJoinSum,10000000));
    }


}

