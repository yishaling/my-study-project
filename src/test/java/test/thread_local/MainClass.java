package test.thread_local;

public class MainClass {
   static final  ThreadLocal local=new ThreadLocal();
    public static void main(String[] args) {
        for(;;){
            new Thread(()->{
                local.set(new byte[1024*1024]);
                local.remove();
                System.gc();
            }).start();
        }

    }

}
