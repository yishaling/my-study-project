package bilibili_huangjun;

/**
 * 8、Java Core 之字节码与多态 动态绑定
 */
public class Java08 {
    public static void main(String[] args) {
        Person p=new Man();
        ((Man)p).a();
        new Java08().method1(new Man());
    }
//    public  void method1(Man m){
//        System.out.println("method1 Man");
//    }
    public  void method1(Person m){
        System.out.println("method1 Person");
    }
  static   class  Man extends Person{
        void a(){

        }
    }
   static class Person{
        void a(){

        }

    }
}
