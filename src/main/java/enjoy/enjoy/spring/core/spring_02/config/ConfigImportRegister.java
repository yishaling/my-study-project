package enjoy.enjoy.spring.core.spring_02.config;

import enjoy.enjoy.spring.core.spring_02.beans.RegisterBean;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.beans.factory.support.RootBeanDefinition;
import org.springframework.context.annotation.ImportBeanDefinitionRegistrar;
import org.springframework.core.type.AnnotationMetadata;

public class ConfigImportRegister implements ImportBeanDefinitionRegistrar {
    /**
     *
     * @param importingClassMetadata
     *              当前类注册信息
     * @param registry: beanDefinition 定义信息
     *              把所有需要添加到容器中的bean加入
     */
    public void registerBeanDefinitions(AnnotationMetadata importingClassMetadata, BeanDefinitionRegistry registry) {
        boolean b = registry.containsBeanDefinition("BeanConfig2");
        if(b){
            RootBeanDefinition rootBeanDefinition=new RootBeanDefinition(RegisterBean.class);
            registry.registerBeanDefinition("RegisterBean",rootBeanDefinition);
        }
    }

}
