package enjoy.enjoy.spring.core.spring_05_aop_01;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;

@ComponentScan({"enjoy.enjoy.spring.core.spring_05_aop_01.beans"})
public class Spring04MainClass {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context=new AnnotationConfigApplicationContext(Spring04MainClass.class);
        Object light = context.getBean("light");
        System.out.println(light);
    }
}
