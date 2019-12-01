package bilibili_huangjun;

public class Java31StaticSyncCode {
    static int i=1;
    static synchronized void say(){
        i++;
    }
    public static void main(String[] args) {
        for(int j=0;j<1001;j++){
            new Thread(()->{
                say();
            }).start();
        }

        System.out.println(i);
    }
}
