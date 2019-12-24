package jvm.jvm_119;

/**
 * 死锁
 */
public class JVM119MainClass {
    public static final String lock1 = "1";
    public static final String lock2 = "2";

    public static void main(String[] args) {

        new Thread(() -> {
            synchronized (lock1) {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                invoke2();
            }
        }).start();
        new Thread(() -> {
            synchronized (lock2) {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                invoke1();
            }
        }).start();


//        List<byte [] > list=new ArrayList<>();
//        for(;;){
//            list.add(new byte[1024]);
//            try {
//                Thread.sleep(1000);
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
//        }
    }

    public static void invoke1() {
        synchronized (lock1) {
            System.out.println("invoke1");
        }

    }

    public static void invoke2() {
        synchronized (lock2) {
            System.out.println("invoke2");
        }
    }
}
