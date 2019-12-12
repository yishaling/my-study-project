package enjoy.enjoy.spring.core.spring_03_life_cycle;

import enjoy.enjoy.spring.core.spring_03_life_cycle.beans.MyBeanPostProcessor;
import enjoy.enjoy.spring.core.spring_03_life_cycle.configs.BeanConfig;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class MainClass {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext configApplicationContext=new AnnotationConfigApplicationContext(BeanConfig.class);
        System.out.println(configApplicationContext.getBean(MyBeanPostProcessor.class));
        System.out.println(configApplicationContext.getBean("environment"));
        System.out.println(configApplicationContext.getBean("systemEnvironment"));
//        System.out.println(configApplicationContext.getBean("loadTimeWeaver"));
//        System.out.println(configApplicationContext.getBean("conversionService"));
//        configApplicationContext.close();
    }
}
