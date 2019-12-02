package bilibili_huangjun;

import java.util.List;

public class Java23ExtendsAndSuper {
    public static void main(String[] args) {
        extendsList(null);
        superList(null);
    }

    public static void extendsList(List<? extends Number> list) {
    }

    public static void superList(List<? super Number> list) {
        list.add(1);
    }
}
