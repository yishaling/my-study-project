package bilibili_huangjun;

public class Java19NoNameInnerClass {
    public static void main(String[] args) {
        new Interface(){

            @Override
            public void print() {

            }
        }.print();
    }
    interface Interface{
        void  print();
    }
}
