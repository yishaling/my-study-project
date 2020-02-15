package design_pattern;

/**
 * 设计模式之适配器模式
 */


/**
 * 两孔插座
 */
interface TwoCavity{
    void twoCavity();
}

/**
 * 三孔插座
 */
interface ThreeCavity{
    void threeCavity();
}

/**
 * 两孔 三孔适配器
 */
class CavityAdapter implements TwoCavity,ThreeCavity{

    @Override
    public void twoCavity() {
        System.out.println("twoCavity");
    }

    @Override
    public void threeCavity() {
        System.out.println("threeCavity");
    }
}
public class AdapterDemo {
    public static void main(String[] args) {
        TwoCavity twoCavity = new CavityAdapter();
        twoCavity.twoCavity();
        ThreeCavity threeCavity = new CavityAdapter();
        threeCavity.threeCavity();
    }
}
