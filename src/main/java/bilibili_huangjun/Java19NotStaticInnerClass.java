package bilibili_huangjun;

public class Java19NotStaticInnerClass {
    private static  int i=100;
    public static void main(String[] args) {
        Java19NotStaticInnerClass java19NotStaticInnerClass =new Java19NotStaticInnerClass();
        NotStaticClass notStaticClass= java19NotStaticInnerClass.new NotStaticClass();
        notStaticClass.print();
    }
    class NotStaticClass{
        public void print(){
            System.out.println(i);
        }
    }

}
