package future;

import java.util.concurrent.*;

/**
 * @program: java8demo
 * @description:
 * @author: LMH
 * @create: 2021-05-13
 **/
public class future {
    static ExecutorService executor = Executors.newCachedThreadPool();

    public static void main(String[] args) {
        Future<Integer> submit = executor.submit(() -> dosometing());
        try {
            System.out.println("wait");
            System.out.println(submit.get(4, TimeUnit.SECONDS));
        } catch (InterruptedException | ExecutionException | TimeoutException e) {
            e.printStackTrace();
        }
    }

    private static int dosometing() throws InterruptedException {
        Thread.sleep(3000);
        return 1;
    }

}
