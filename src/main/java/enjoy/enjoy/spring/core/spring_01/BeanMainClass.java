package enjoy.enjoy.spring.core.spring_01;

import enjoy.enjoy.spring.core.spring_01.beans.MyPrototypeBean;
import enjoy.enjoy.spring.core.spring_01.beans.MySingletonBean;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class BeanMainClass {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext app=new AnnotationConfigApplicationContext(BeanConfig.class,BeanConfig.class);
        System.out.println("start....");
        //---------------------------------
        //单例Bean-
        MySingletonBean mySingletonBean =app.getBean(MySingletonBean.class);
        MySingletonBean mySingletonBean2 =app.getBean(MySingletonBean.class);
        System.out.println(mySingletonBean == mySingletonBean2);
        //---------------------------------
        //---------------------------------
        //模板Bean-
        MyPrototypeBean MyPrototypeBean =app.getBean(enjoy.enjoy.spring.core.spring_01.beans.MyPrototypeBean.class);
        enjoy.enjoy.spring.core.spring_01.beans.MyPrototypeBean MyPrototypeBean2 =app.getBean(enjoy.enjoy.spring.core.spring_01.beans.MyPrototypeBean.class);
        System.out.println(MyPrototypeBean == MyPrototypeBean2);
        //----------------------------------
    }
}
