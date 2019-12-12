package enjoy.enjoy.spring.core.spring_02;

import enjoy.enjoy.spring.core.spring_02.beans.ImportBeanTest;
import enjoy.enjoy.spring.core.spring_02.beans.RegisterBean;
import enjoy.enjoy.spring.core.spring_02.beans.UserController2;
import enjoy.enjoy.spring.core.spring_02.config.BeanConfig;
import enjoy.enjoy.spring.core.spring_02.config.BeanConfig2;
import enjoy.enjoy.spring.core.spring_02.config.MyFactoryBean;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class MainClass {
    public static void main(String[] args) throws Exception {
        AnnotationConfigApplicationContext app=new AnnotationConfigApplicationContext(BeanConfig.class,BeanConfig2.class);

        UserController2 bean = app.getBean(UserController2.class);
        ImportBeanTest ImportBeanTest = app.getBean(ImportBeanTest.class);

        // 获取factoryBean
        MyFactoryBean myFactoryBean = app.getBean(MyFactoryBean.class);
        // 获取factoryBean里面的Bean
        Object myFactoryBean2 = app.getBean("myFactoryBean");
//        RegisterBean registerBean = app.getBean(RegisterBean.class);
        System.out.println(bean);
        System.out.println(ImportBeanTest);
        System.out.println(myFactoryBean);
        System.out.println(myFactoryBean2);
//        System.out.println(registerBean);
    }
}
