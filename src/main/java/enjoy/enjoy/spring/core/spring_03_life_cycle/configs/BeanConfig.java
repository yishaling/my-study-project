package enjoy.enjoy.spring.core.spring_03_life_cycle.configs;

import enjoy.enjoy.spring.core.spring_03_life_cycle.beans.Bike;
import org.springframework.aop.framework.ProxyFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BeanConfig {
    @Bean(initMethod = "initMethod",destroyMethod = "distrory")
    public Bike Bike(){
        ProxyFactory factory=new ProxyFactory();
        return new Bike();
    }
}
