package enjoy.enjoy.spring.core.spring_02.config;

import enjoy.enjoy.spring.core.spring_02.beans.FactoryBeanTest;
import org.springframework.beans.factory.FactoryBean;

public class MyFactoryBean implements FactoryBean<FactoryBeanTest> {
    @Override
    public FactoryBeanTest getObject() throws Exception {
        return new FactoryBeanTest();
    }

    @Override
    public Class<FactoryBeanTest> getObjectType() {
        return FactoryBeanTest.class;
    }
    public boolean isSingleton() {
        return true;
    }

}