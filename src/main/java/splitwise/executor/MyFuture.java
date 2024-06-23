package splitwise.executor;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.*;

@Slf4j
public class MyFuture {
    public static void main(String[] args) {
        ExecutorService executorService=new ThreadPoolExecutor(2,2,2,
                TimeUnit.SECONDS,new ArrayBlockingQueue<>(2));
        Future<Integer> callableFuture = executorService.submit(() -> 45);
        try {
            Integer returned = callableFuture.get();
            log.info("Got: {}", returned);
        } catch (InterruptedException | ExecutionException e) {
            throw new RuntimeException(e);
        }

        Future<?> runnableFuture = executorService.submit(() -> log.info("Inside 45"));
        try {
            Object o = runnableFuture.get();
            log.info("Got: {}", o);
        } catch (InterruptedException | ExecutionException e) {
            throw new RuntimeException(e);
        }
    }
}
