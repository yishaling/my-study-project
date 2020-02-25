package thread_pool;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class ScheduledThreadPoolTest {
    public static void main(String[] args) {
        final ScheduledThreadPoolExecutor scheduledExecutorService = (ScheduledThreadPoolExecutor) Executors.newScheduledThreadPool(1);
        Executors.newFixedThreadPool(1);
        long l = System.currentTimeMillis();
        scheduledExecutorService.schedule(() -> {
            try {
                Thread.sleep(10000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println();
            System.out.println("第一个执行了");
            System.out.println(Thread.currentThread());
            System.out.println(System.currentTimeMillis()-l);
        }, 1, TimeUnit.SECONDS);
        try {
            Thread.sleep(999);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        scheduledExecutorService.schedule(() -> {
            System.out.println(System.currentTimeMillis()-l);
            System.out.println("第二个执行了");
            System.out.println(Thread.currentThread());
        }, 1, TimeUnit.SECONDS);
        scheduledExecutorService.schedule(() -> {
            System.out.println(System.currentTimeMillis()-l);
            System.out.println("第三个执行了");
            System.out.println(Thread.currentThread());
        }, 1, TimeUnit.SECONDS);
    }
}
