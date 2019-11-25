package bilibili_huangjun;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Java10 {
    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<>();
        list.add(null);
        System.out.println(list.size());
        list.remove(0);
        System.out.println(list.size());
        Iterator<Integer> iterator = list.iterator();

        while (iterator.hasNext()) {
            iterator.next();
                iterator.remove();
            System.out.println(list.size());
        }
    }
}
