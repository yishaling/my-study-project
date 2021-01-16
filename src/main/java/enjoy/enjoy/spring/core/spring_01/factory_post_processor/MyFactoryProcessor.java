package enjoy.enjoy.spring.core.spring_01.factory_post_processor;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

import java.util.Iterator;

@Component
@Profile("test")
public class MyFactoryProcessor  implements BeanFactoryPostProcessor {
    @Override
    public void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory) throws BeansException {
        Iterator<String> beanNamesIterator = beanFactory.getBeanNamesIterator();
        while (beanNamesIterator.hasNext()){
            System.out.println("beans : "+beanNamesIterator.next());
        }
        BeanDefinition mySingletonBean = beanFactory.getBeanDefinition("mySingletonBean");
        System.out.println("MyFactoryProcessor.postProcessBeanFactory");
    }
}
