package thread_pool;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.FutureTask;

public class FutureTaskTest {
//    final
    static ExecutorService service= Executors.newFixedThreadPool(1);
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        FutureTask<String> futureTask=new FutureTask<>(()->{
            System.out.println("11111");
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        },"");


//        futureTask.run();
        service.execute(futureTask);
        //这个会阻塞
        System.out.println(futureTask.get());

    }
}
