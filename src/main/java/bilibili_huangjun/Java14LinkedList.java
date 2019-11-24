package bilibili_huangjun;

import java.util.LinkedList;

public class Java14LinkedList {
    public static void main(String[] args) {
        LinkedList list=new LinkedList();
        list.add("{}");
        list.add("{}");
        list.add("{}");
        list.add("{}");
        list.add("{}");
        list.add("{}");
        list.offerFirst("");
        list.toString();
        Byte [] bytes={null,null};
        System.out.println(list);
    }
}
