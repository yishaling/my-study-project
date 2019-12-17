package enjoy.enjoy.spring.core.spring_04;

import enjoy.enjoy.spring.core.spring_04.beans.AutoAndValueBean;
import enjoy.enjoy.spring.core.spring_04.beans.PlaneBean;
import enjoy.enjoy.spring.core.spring_04.configs.BeanConfigs;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

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
        AnnotationConfigApplicationContext context=new AnnotationConfigApplicationContext(BeanConfigs.class);
        //相同类型的Bean class  会被 @Primary 覆盖
        PlaneBean classBean = context.getBean(PlaneBean.class);
        //@Bean 默认Bean的name 是 方法名字
        Object plane = context.getBean("Plane");
        Object plane_name = context.getBean("Plane_name");
        ExecutorService executorService = Executors.newSingleThreadExecutor();
        AnnotationConfigApplicationContext ac=new AnnotationConfigApplicationContext(SpringBeanConfig.class);
        Bean1 bean = ac.getBean(Bean1.class);
        Bean2 Bean2 = ac.getBean(Bean2.class);
        System.out.println(bean.bean2);
        System.out.println(Bean2);

        System.out.println("classBean："+classBean);
        System.out.println("plane bean ："+plane);
        System.out.println("plane_name bean ："+plane_name);

        AutoAndValueBean valueBean = context.getBean(AutoAndValueBean.class);
        //获取上下文
        System.out.println(classBean.getApplicationContext());
        //获取文字
        System.out.println(valueBean.getName()+valueBean.getAge());
        //获取properties
        System.out.println(valueBean.getColor());
        //获取Autowired
        System.out.println(valueBean.getPlaneBean());
    }
}
