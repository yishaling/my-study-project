package GCTest;

import java.util.ArrayList;
import java.util.List;

public class GcTest {
    public static void main(String[] args) {
        System.out.println("..");
        List list=new ArrayList();
        for (;;){
            list.add(new byte[1024*1024]);
        }
    }
}
