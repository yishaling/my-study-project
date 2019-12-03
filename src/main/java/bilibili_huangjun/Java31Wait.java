package bilibili_huangjun;

public class Java31Wait {
    private  static final  Object lock=new Object();
    public void notifyLock() throws Exception{
        synchronized (lock){
            while (true){
                lock.notify();
                Thread.sleep(100);
                System.out.println(""+Thread.currentThread());
            }

        }
    }
    public static void main(String[] args) {
                new Thread(new LockThread()).start();
                new Thread(new NotifyThread()).start();
    }
    static  class LockThread implements Runnable{

        @Override
        public void run() {
            synchronized (lock){
                while (true){
                    try {
                        System.out.println("LockThread:"+Thread.currentThread());
                        lock.wait();
                        Thread.sleep(2000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }

                }

            }
        }
    }  static  class NotifyThread implements Runnable{

        @Override
        public void run() {
            synchronized (lock){
                while (true){
                    try {
                        lock.notify();
                        Thread.sleep(2000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println("NotifyThread:"+Thread.currentThread());
                }

            }
        }
    }
}
