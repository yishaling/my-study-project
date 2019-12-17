package hero_test.hero_08_callback;

import java.util.function.Function;

public class CallBackServer {
    public void save(UserEntity userEntity, Function<UserEntity,Void> function){
        new Thread(()->{
            try {
                Thread.sleep(10000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            function.apply(userEntity);

            System.out.println("CallBackServer-Thread");
        }).start();

    }
}
