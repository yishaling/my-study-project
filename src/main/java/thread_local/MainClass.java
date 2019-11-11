package thread_local;

public class MainClass {
   static final  ThreadLocal local=new ThreadLocal();
    public static void main(String[] args) {
        String a=null;
//        for(;;){
//            new Thread(()->{
//                local.set(new byte[10*1024*1024]);
//            }).start();
//        }

    }

}
