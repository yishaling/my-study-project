package hero_test.hero_08_callback;

import java.io.IOException;
import java.util.function.Function;

public class HeroMainClass {

    public static void main(String[] args) {
        new Thread(new InputClass((bytes -> {
            soutMsg(new String(bytes));
            return null;
        }))).start();
        System.out.println("--------------已经准备完毕-----------");

    }
    public static class  InputClass implements Runnable{
        Function<byte[], Object> function;
        InputClass(){}
        InputClass(Function<byte[], Object> function){
            this.function=function;
        }

        @Override
        public void run() {
            for(;;){
                try {
                    byte[] bytes=new byte[1024];
                    System.in.read(bytes);
                    function.apply(bytes);
//                    System.out.println("有输入");
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
    public static void soutMsg(String  input){
        System.out.println("this time input :  "+input);
    }
}
