package enjoy.enjoy.spring.core.spring_04;

import enjoy.enjoy.spring.core.spring_04.beans.AutoAndValueBean;
import enjoy.enjoy.spring.core.spring_04.beans.PlaneBean;
import enjoy.enjoy.spring.core.spring_04.configs.BeanConfigs;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class MainClass {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context=new AnnotationConfigApplicationContext(BeanConfigs.class);
        PlaneBean bean = context.getBean(PlaneBean.class);
        AutoAndValueBean valueBean = context.getBean(AutoAndValueBean.class);
        System.out.println(bean.getApplicationContext());
        System.out.println(valueBean.getName()+valueBean.getAge());
        System.out.println(valueBean.getColor());
    }
}
