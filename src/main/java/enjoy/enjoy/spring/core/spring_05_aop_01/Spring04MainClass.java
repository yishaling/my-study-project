package enjoy.enjoy.spring.core.spring_05_aop_01;

import enjoy.enjoy.spring.core.spring_05_aop_01.beans.LightBean;
import enjoy.enjoy.spring.core.spring_05_aop_01.beans.LightAspects;
import enjoy.enjoy.spring.core.spring_05_aop_01.configs.BeanConfigs;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.context.annotation.Import;

@ComponentScan({"enjoy.enjoy.spring.core.spring_05_aop_01.beans"})
@EnableAspectJAutoProxy
@Import(BeanConfigs.class)
public class Spring04MainClass {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context=new AnnotationConfigApplicationContext(Spring04MainClass.class);
        LightBean lightBean = context.getBean(LightBean.class);
        LightAspects LightAspects = context.getBean(LightAspects.class);
        Spring04MainClass mianBean = context.getBean(Spring04MainClass.class);
        BeanConfigs beanConfigs = context.getBean(BeanConfigs.class);

        System.out.println(LightAspects);
        System.out.println(lightBean);
        lightBean.method();
        System.out.println(mianBean);
        System.out.println(beanConfigs);
        //
    }
}
