package future;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.*;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

/**
 * @program: java8demo
 * @description:
 * @author: LMH
 * @create: 2021-05-13
 **/
public class completableFuture {
    public static Future<Double> getPriceAsync(final double d) {
        CompletableFuture<Double> future = new CompletableFuture<>();
        new Thread(() -> {
            try {
                Thread.sleep(3000);
                System.out.println("d=" + d);
                future.complete(d);
            } catch (InterruptedException e) {
                future.completeExceptionally(e);
            }

        }).start();
        return future;
    }

    public static Future<Double> getPriceAsync1(Double d) {

        return CompletableFuture.supplyAsync(() -> {
            try {
                Thread.sleep(3000);
                return d;
            } catch (InterruptedException e) {
            }
            return null;
        });
    }
    public static List<String> getPriceAsync2(Double d) {
        List<Integer> list = Arrays.asList(1,2,3);
        List<CompletableFuture<String>> collect = list.stream().map(l -> CompletableFuture.supplyAsync(() -> {
            return String.valueOf(l);
        })).collect(Collectors.toList());
        return collect.stream().map(CompletableFuture::join).collect(Collectors.toList());
    }
    public static void main(String[] args) throws InterruptedException, ExecutionException, TimeoutException {
        Double value = getPriceAsync1(1.0).get(4, TimeUnit.SECONDS);

        System.out.println("res: " + value);
    }
}
