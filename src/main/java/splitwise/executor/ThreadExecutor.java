package splitwise.executor;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.*;

@Slf4j
public class ThreadExecutor {
    public static void main(String[] args) {
        ExecutorService executorService = new ThreadPoolExecutor(2, 4, 10,
                TimeUnit.SECONDS, new ArrayBlockingQueue<>(2),
                Thread::new, (r, executor) -> log.error("Failed to execute task: {}", r.toString()));
        for (int i=1;i<=10;i++){
            int finalI = i;
            Future<?> future = executorService.submit(() -> {
                try {
                    Thread.sleep(3000);
                } catch (InterruptedException e) {
                    log.error("Inte");
                }
                log.info("submitting task: {}, processed by: {}", finalI, Thread.currentThread().getName());
            });
        }
    }
}
class CustomThreadFactory implements ThreadFactory{

    @Override
    public Thread newThread(Runnable r) {
        return new Thread(r);
    }
}
