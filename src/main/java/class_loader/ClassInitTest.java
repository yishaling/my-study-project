package class_loader;

public class ClassInitTest {
    public static void main(String[] args) {
        System.out.println(T.count);
    }


    static class T{

        public static  T t=new T();
        public static int count=2;
        private T(){
            count++;
        }
    }
}
