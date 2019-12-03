package bilibili_huangjun;

public class Java31ObjectSyncCode {
    static int i = 1;

    void say() {
        synchronized (this) {
            i++;
        }


    }
    synchronized void say2() {
            i++;
    }

    public static void main(String[] args) throws Exception {
        for (int j = 0; j < 10; j++) {
            new Java31ObjectSyncCode().m();
        }
        Thread.sleep(2000);
        System.out.println(i);

    }

    void m() {
        for (int j = 0; j < 1000; j++) {
            new Thread(new TestRunn()).start();
        }
    }

    class TestRunn implements Runnable {

        @Override
        public void run() {
            say();
        }
    }
}
