package enjoy.enjoy.spring.core.spring_04;

import enjoy.enjoy.spring.core.spring_04.beans.AutoAndValueBean;
import enjoy.enjoy.spring.core.spring_04.beans.PlaneBean;
import enjoy.enjoy.spring.core.spring_04.configs.BeanConfigs;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class MainClass {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context=new AnnotationConfigApplicationContext(BeanConfigs.class);
        //相同类型的Bean class  会被 @Primary 覆盖
        PlaneBean classBean = context.getBean(PlaneBean.class);
        //@Bean 默认Bean的name 是 方法名字
        Object plane = context.getBean("Plane");
        Object plane_name = context.getBean("Plane_name");

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
