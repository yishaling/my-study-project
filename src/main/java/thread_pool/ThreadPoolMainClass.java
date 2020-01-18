package thread_pool;

import java.util.concurrent.*;

public class ThreadPoolMainClass {
    public static void main(String[] args) {
        int corePoolSize=1;
        int maximumPoolSize=1;
        long keepAliveTime=22;
        TimeUnit unit=TimeUnit.MILLISECONDS;
        BlockingQueue<Runnable> workQueue=new LinkedBlockingDeque<>();
        CountDownLatch countDownLatch=new CountDownLatch(1);
        countDownLatch.countDown();
        ThreadFactory threadFactory=new ThreadFactory() {
            @Override
            public Thread newThread(Runnable r) {
                Thread thread=new Thread(r);
//                thread.setName("xxxxxxxxxxxxxxxxxxxxxx");
                return thread;
            }
        };


        RejectedExecutionHandler handler=new RejectedExecutionHandler(){
            @Override
            public void rejectedExecution(Runnable r, ThreadPoolExecutor executor) {
                executor.execute(r);
            }
        };
        /**策略（最后一个参数）
         * Abort
         Discard
         DiscardOld 丢弃最老的
         CallerRuns
         */
        ThreadPoolExecutor threadPoolExecutor=new ThreadPoolExecutor(corePoolSize,maximumPoolSize,keepAliveTime,unit,workQueue,threadFactory,new ThreadPoolExecutor.AbortPolicy());
     for(int i=0;i<10;i++){
         threadPoolExecutor.execute(()->{
             try {
                 Thread.sleep(100);
                 System.out.println(Thread.currentThread().getName());
                 System.out.println(Thread.currentThread());
             } catch (InterruptedException e) {
                 e.printStackTrace();
             }
         });
     }
        System.out.println("-----");
    }
}
