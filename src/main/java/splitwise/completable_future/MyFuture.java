package splitwise.completable_future;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

public class MyFuture {
    public static void main(String[] args) throws ExecutionException, InterruptedException, TimeoutException {
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(2, 5, 5, TimeUnit.SECONDS,
                new ArrayBlockingQueue<>(2), new MyThreadFactory(), new MyExecutionHandler());
//        threadPoolExecutor.allowCoreThreadTimeOut(true);

        /*List<Future<String>> futureList = new ArrayList<>();

        for (int i = 1; i <= 9; i++) {
            int finalI = i;
            futureList.add(threadPoolExecutor.submit(() -> {
                try {
                    Thread.sleep(5000);
                } catch (Exception e) {
                    System.out.println(e.getMessage());
                }
                System.out.println("Task " + finalI + " served by thread: " + Thread.currentThread().getName());
                return "Return " + finalI + " Task served by thread: " + Thread.currentThread().getName();
            }));
        }
        for (Future<String> future : futureList) {
            try {
                System.out.println("Returned: " + future.get());
            } catch (InterruptedException | ExecutionException e) {
                throw new RuntimeException(e);
            }
        }
        threadPoolExecutor.shutdown();*/

        CompletableFuture<String> stringCompletableFuture = CompletableFuture.supplyAsync(() -> {
            System.out.println("Supply Async by " + Thread.currentThread().getName());
            return "Concept ";
        }, threadPoolExecutor).thenApply((String val) -> {
            System.out.println("Then Apply by " + Thread.currentThread().getName());
            return val + "And ";
        }).thenApplyAsync((String val) -> {
            System.out.println("Then apply async by: " + Thread.currentThread().getName());
            return val + "Coding";
        });
        System.out.println(stringCompletableFuture.get());

        ExecutorService executorService=Executors.newFixedThreadPool(5);
        List<Future<Integer>> integerFutures=new ArrayList<>();
        for (int i=1;i<=8;i++){
            int finalI = i;
            integerFutures.add(executorService.submit(()-> {
                Thread.sleep(5000);
                System.out.println("Task "+finalI+" executed by: "+Thread.currentThread().getName());
                return finalI;
            }));
        }
        for (Future<Integer> future: integerFutures){
            System.out.println("Returned task: "+future.get(2, TimeUnit.SECONDS));
            future.cancel(true);

        }
        executorService.shutdown();
    }
}
