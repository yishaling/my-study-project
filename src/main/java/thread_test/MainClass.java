package thread_test;

public class MainClass {
    static boolean isrunning=true;
    public static void main(String[] args) {
            new Thread(()->{
                long l1=System.currentTimeMillis();
                System.out.println("");
                while (isrunning){
                }
                System.out.println("结束");
                long l2=System.currentTimeMillis();
                System.out.println("时间:"+(l2-l1));
            }).start();         new Thread(()->{
                long l1=System.currentTimeMillis();
                System.out.println("");
                while (isrunning){
                }
                System.out.println("结束");
                long l2=System.currentTimeMillis();
                System.out.println("时间:"+(l2-l1));
            }).start();         new Thread(()->{
                long l1=System.currentTimeMillis();
                System.out.println("");
                while (isrunning){
                }
                System.out.println("结束");
                long l2=System.currentTimeMillis();
                System.out.println("时间:"+(l2-l1));
            }).start();         new Thread(()->{
                long l1=System.currentTimeMillis();
                System.out.println("");
                while (isrunning){
                }
                System.out.println("结束");
                long l2=System.currentTimeMillis();
                System.out.println("时间:"+(l2-l1));
            }).start();
            new Thread(()->{
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                isrunning=false;
            }).start();
    }
}
