package bilibili_huangjun;

import java.util.concurrent.*;

public class Java36ThreadPool {
    public static void main(String[] args) {

        ExecutorService executorService1 = Executors.newFixedThreadPool(1);

        ExecutorService executorService = Executors.newCachedThreadPool();
        ScheduledExecutorService scheduledExecutorService = Executors.newScheduledThreadPool(2);
        scheduledExecutorService.schedule(new Callable<Object>() {
            public Object call(){
                System.out.println("1");
                return "";
            }
        }, 1, TimeUnit.MILLISECONDS);
    }
}
