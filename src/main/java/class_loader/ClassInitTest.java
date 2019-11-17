package class_loader;
import class_loader.ImportClass;
public class ClassInitTest {
    public static void main(String[] args) throws ClassNotFoundException {
        //只是引用不会初始化P
//        P p;
        //被引入也不会初始化
//        ImportClass importClass;
        // final 的不会被初始化
//        System.out.println(P.i);
        //不是final 的不会被初始化
//        System.out.println(P.j);
        //子类初始化 被使用了才会被加载
//        X x=new X();
        //打印类不会被 初始化
//        System.out.println(P.class);
        Class.forName("class_loader.ImportClass");
    }


    static class T{

        public static  T t=new T();
        public static int count=2;
        private T(){
            count++;
        }
    }
    static class P{
        static final int i=9;
        static int j=8;
        static {
            System.out.println("P");
        }
    }
    static class X extends P{

    }
}
