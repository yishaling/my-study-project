package hero_test.hero_08_callback;

import java.util.function.Function;

public class CallBackServer {

    public void save(UserEntity userEntity, Function<UserEntity,Void> function){
        new Thread(()->{
            try {
                for(int i=0;i<10;i++){
                    Thread.sleep(1000);
                    System.out.println("save..."+i);
                    function.apply(userEntity);
                }

            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            System.out.println("save---over ");
        }).start();

    }
    public static  class Productor implements Runnable{

        @Override
        public void run() {

        }
    }
}
