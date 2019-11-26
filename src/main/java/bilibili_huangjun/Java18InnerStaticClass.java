package bilibili_huangjun;

/**
 * 18 字节码内部原理
 */
public class Java18InnerStaticClass {
    private static  int i=100;
    private static  int j=3000;
    private static  int k=40000;
    public static void main(String[] args) {
        StaticClass.print();
        Java18InnerStaticClass j8=new Java18InnerStaticClass();
        InnerClass innerClass = j8.new InnerClass();
//        j8.method();
        System.out.println(StaticClass.s);
        System.out.println(InnerClass.s);

    }
    static class StaticClass{
        static final String s="Static's StaticClass ";
        public static void print(){
            System.out.println(i);
            System.out.println(j);
            System.out.println(k);
        }
    }
    void method(){
        System.out.println(InnerClass.s);
    }
    class InnerClass{
      public   static final String s="Object's InnerClass ";
//        static final void method(){
//
//        }
    }


}
