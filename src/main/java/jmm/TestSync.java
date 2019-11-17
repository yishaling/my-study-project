package jmm;

public class TestSync {
    static  String a="9";
    static final String b="9";
    static volatile String c="9";

    public static void main(String[] args) {

    }
    synchronized void a() {

    }
    void b(){
        synchronized (a){

        }
    }
}
