package bilibili_huangjun;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicInteger;

public class Java33CASCountLatch {
  static   CountDownLatch countDownLatch =new CountDownLatch(2);
    public static void main(String[] args) {
        new Thread(()->{
            countDownLatch.countDown();
        }).start();
        new Thread(()->{
            countDownLatch.countDown();
        }).start();
    }
}
