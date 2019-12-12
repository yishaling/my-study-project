package enjoy.enjoy.spring.core.spring_03_life_cycle.beans;

import org.springframework.aop.Advisor;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;

public class MyBeanPostProcessor implements BeanPostProcessor{
    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
//        Advisor advisor=(Advisor)bean;
        System.out.println(beanName+"---> postProcessBeforeInitialization:"+bean);
        return bean;
    }

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        System.out.println(beanName+"---> postProcessAfterInitialization"+bean);
        return bean;
    }
}
