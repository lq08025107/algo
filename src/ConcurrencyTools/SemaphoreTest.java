package ConcurrencyTools;

import java.util.Date;
import java.util.concurrent.*;

public class SemaphoreTest {
    private static final int THREAD_COUNT = 30;
    private static ExecutorService threadPool = Executors.newFixedThreadPool(THREAD_COUNT);
    private static Semaphore s = new Semaphore(10);

    public static void main(String[] args){
        StringBuffer sb = new StringBuffer();
        StringBuilder sb1 = new StringBuilder();
        for(int i = 0; i < THREAD_COUNT; i++) {
            threadPool.execute(new Runnable() {
                @Override
                public void run() {
                    try {
                        s.acquire();
                        System.out.println("save data @ " + new Date());
                        TimeUnit.SECONDS.sleep(3);
                        s.release();
                    } catch (Exception ex) {}
                }
            });
        }
        threadPool.shutdown();
    }
}
