package bilibili_huangjun;

public class Java23Thread  implements Runnable{
    @Override
    public void run() {
        System.out.println("run :");
    }

    public static void main(String[] args) {
        new Thread(new Java23Thread()).start();
    }
}
