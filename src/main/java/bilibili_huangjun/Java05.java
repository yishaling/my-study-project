package bilibili_huangjun;

/**
 * 5、Java Core之字节码与常量池和JVM内存原理
 * 6、Java Core 之 招聘与知识体系深入分析
 */
public class Java05 {
    static String string = "我的世界";
    static String a = "ab";
    static String b = "cd";
    final String c = "1";
    final String d = "2";

    public void inovke() {
        String f = c + d;
        String e = "12";
        System.out.println("inovke f==e:" + (f == e));
    }


    public static void main(String[] args) {
        char[] chars = string.toCharArray();
        for (char c : chars) {
            System.out.println("\\u" + Integer.toHexString(c));
        }
        String String2 = "我的世界";
        System.out.println(string == String2);

        final String A = "ab"; // 常量A
        final String B = "cd"; // 常量B
        // 将两个常量用+连接对s进行初始化
//        String t = new String("abcd");
        String t = "abcd";
        String s = A + B;
        if (s == t) {
            System.out.println("s等于t，它们是同一个对象");
        } else {
            System.out.println("s不等于t，它们不是同一个对象");
        }
        System.out.println(a == A);
        new Thread(() -> {
            System.out.println("b==B:" + (b == B));
        }).start();
        new Java05().inovke();
    }

}
