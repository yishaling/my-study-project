package bilibili_huangjun;

import java.util.Map;

/**
 * 泛型
 */

public class Java20_21_GenericParadigm<T> {
    public static void main(String[] args) {

    }
    void dosth(Map<String,? extends  T> map){

    }
   static class Generic<T>{
        void doSth(T t){

        }
    }
}
