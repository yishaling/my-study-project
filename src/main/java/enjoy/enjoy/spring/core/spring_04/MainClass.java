package enjoy.enjoy.spring.core.spring_04;

import enjoy.enjoy.spring.core.spring_04.beans.Plane;
import enjoy.enjoy.spring.core.spring_04.configs.BeanConfigs;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class MainClass {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context=new AnnotationConfigApplicationContext(BeanConfigs.class);
        Plane bean = context.getBean(Plane.class);
        System.out.println(bean.getApplicationContext());
    }
}
