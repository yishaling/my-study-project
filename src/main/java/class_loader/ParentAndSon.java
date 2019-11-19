package class_loader;

public class ParentAndSon {
    public static void main(String[] args) {
        System.out.println(new Son());
    }

    static class Parent{
        static {
            System.out.println("Parent static");
        }
        {
            System.out.println("parent init ");
        }
        Parent(){
            System.out.println("Parent instance");
        }
    }
    static class  Son  extends  Parent{
        static {
            System.out.println("Son static");
        }
        {
            System.out.println("Son init");
        }
        Son(){
            System.out.println("Son instance");
        }
    }
}
