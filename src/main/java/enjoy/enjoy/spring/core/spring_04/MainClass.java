package enjoy.enjoy.spring.core.spring_04;

import enjoy.enjoy.spring.core.spring_04.beans.Bean1;
import enjoy.enjoy.spring.core.spring_04.beans.Bean2;
import enjoy.enjoy.spring.core.spring_04.configs.SpringBeanConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class MainClass {
    @Autowired
    public static void main(String[] args) {
        ExecutorService executorService = Executors.newSingleThreadExecutor();
        AnnotationConfigApplicationContext ac=new AnnotationConfigApplicationContext(SpringBeanConfig.class);
        Bean1 bean = ac.getBean(Bean1.class);
        Bean2 Bean2 = ac.getBean(Bean2.class);
        System.out.println(bean.bean2);
        System.out.println(Bean2);

    }
}
