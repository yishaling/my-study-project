package enjoy.enjoy.spring.core.spring_03_life_cycle;

import enjoy.enjoy.spring.core.spring_03_life_cycle.configs.BeanConfig;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class MainClass {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext configApplicationContext=new AnnotationConfigApplicationContext(BeanConfig.class);
//        configApplicationContext.close();
    }
}
