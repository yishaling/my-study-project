package bilibili_huangjun;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.ReentrantLock;

public class Java33CASAtomicInteger {
    static ExecutorService service= Executors.newFixedThreadPool(10);
  static AtomicInteger atomicInteger=new AtomicInteger(0);
    public static void main(String[] args) {
        ReentrantLock reentrantLock=new ReentrantLock();
        reentrantLock.lock();
        Thread t=new Thread();
        t.setPriority(10);
        for(;;){
            service.execute(()->{
                System.out.println(atomicInteger.addAndGet(1));
            });
          if(atomicInteger.get()==127){
              System.out.println(atomicInteger.get());
              break;
          }
        }
    }
}
