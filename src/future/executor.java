package future;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;

/**
 * @program: java8demo
 * @description:
 * @author: LMH
 * @create: 2021-05-13
 **/
public class executor {
    static List<Integer> integers = Arrays.asList(1, 2, 3);
    private static final Executor executor = Executors.newFixedThreadPool(Math.min(400, integers.size()), new ThreadFactory() {
        @Override
        public Thread newThread(Runnable r) {
            Thread t = new Thread(r);
            t.setDaemon(true);
            return t;
        }
    });

    public static int fun() {
        return CompletableFuture.supplyAsync(() -> 1, executor).join();
    }

    public static void main(String[] args) {
        System.out.println(fun());
    }

    public static void func(){
        System.out.println("hahahahah");
        System.out.println("lalalala");
    }
}
