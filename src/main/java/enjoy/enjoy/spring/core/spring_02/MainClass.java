package enjoy.enjoy.spring.core.spring_02;

import enjoy.enjoy.spring.core.spring_02.config.BeanConfig;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class MainClass {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext app=new AnnotationConfigApplicationContext(BeanConfig.class);
    }
}
