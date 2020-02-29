package enjoy.enjoy.spring.core.spring_01;

import enjoy.enjoy.spring.core.spring_01.beans.MyPrototypeBean;
import enjoy.enjoy.spring.core.spring_01.beans.MySingletonBean;
import enjoy.enjoy.spring.core.spring_01.factory_beans.MyBean;
import enjoy.enjoy.spring.core.spring_01.factory_beans.MyFactoryBean;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class BeanMainClass {
    public static void main(String[] args) throws Exception {
        AnnotationConfigApplicationContext app=new AnnotationConfigApplicationContext(BeanConfig.class,BeanConfig.class);
        System.out.println("start....");
        //---------------------------------
        //单例Bean-
        MySingletonBean mySingletonBean =app.getBean(MySingletonBean.class);
        //从FactoryBean中创建单例Bean
        MyBean mySingletonBeanFactoryBeansBean =app.getBean(MyBean.class);

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
