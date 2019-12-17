package hero_test.hero_08_callback;

public class HeroMainClass {

    public static void main(String[] args) {
        CallBackServer server=new CallBackServer();
        UserEntity userEntity = new UserEntity();
        server.save(userEntity,(userEntity2)->{
            System.out.println(" 已调用回调");
            System.out.println(userEntity2);
            return null;
        });
        System.out.println("Main-thread");
    }

}
