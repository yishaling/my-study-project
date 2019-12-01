package bilibili_huangjun;

public class Java31ObjectSyncCode {
    static int i = 1;

     synchronized   void say() {
       i++;

    }

    public static void main(String[] args) throws  Exception{
        new Java31ObjectSyncCode().m();
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
