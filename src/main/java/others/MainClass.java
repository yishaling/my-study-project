package others;

public class MainClass {
    public static void main(String[] args) {
        long s=Long.MAX_VALUE-Integer.MAX_VALUE;
        int mask=Integer.MAX_VALUE;
        System.out.println(s);
        System.out.println(mask);
        System.out.println(s&mask);
        System.out.println(mask&s);
    }
}
