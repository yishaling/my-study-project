package bilibili_huangjun;

public class Java19NoNameInnerClass<T extends Java19NoNameInnerClass> {
    int i=1;
    public static void main(String[] args) {
            new Java19NoNameInnerClass().method();

    }
    void method(){
        new Interface(){

            @Override
            public void print() {
                System.out.println(i);
            }
        }.print();
    }
    interface Interface{
        void  print();
    }
}
