package bilibili_huangjun;

public class Java35Thread {
    public static void main(String[] args) {
        Thread t=new Thread(()->{
            for(;;){
                try {
                    Thread.sleep(1000);
                    Thread.yield();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(1);
            }


        });

        t.start();
//        t.start();// 这里报错
//        t.setDaemon(true);// 这里报错
        t.setName("xxxx");
t.destroy();
        System.out.println(t.getName());
//        t.start();
    }
}
