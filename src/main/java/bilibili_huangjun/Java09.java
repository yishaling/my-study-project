package bilibili_huangjun;

import com.alibaba.fastjson.JSONArray;

/**
 * 9、Java Core 之 另类深入分析集合源码
 */
public class Java09 {
    public static void main(String[] args) {
        new Java09().sout();
    }

    void sout() {
        new impl().sout();
    }

    interface inter {
        //当有 *一个*接口的时候则不必重写
        default void sout() {
            System.out.println("interface 1 default sout");
        }
    }

    interface inter2 {
        //当有 *第二个*接口具有相同的方法时  实现类必须重写
        default void sout() {
        }
    }

    class impl extends superClass implements inter, inter2 {


    }

    class superClass {
        // 被继承了相当于子类复写了
        public void sout() {

        }
    }


}

