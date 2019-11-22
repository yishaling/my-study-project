package bilibili_huangjun;

/**
 *7、Java Core之深入分析JVM字节码和常量池原理
 */
public class Java07 {
    public static void main(String[] args) {
         String s1 = "p";
         String s2 = "p";
         String s3 = s2 + "p";
        System.out.println(s3.intern() == s1); // true
        System.out.println(s1 == s2); // true
    }

    public void method() {
        privateMethod();// 这里首先会 aload_0 这个是栈帧的this 的位置
        a();
    }

    private void privateMethod() {

    }

    private static void a() {

    }

    public void out1(int i) {
        System.out.println(i + 1);
    }

    public void out1(long i) {
        System.out.println(i + 1);
    }
    public void out1(String i) {
        System.out.println(i + 1);
    }
    class ABBB {

    }


}
