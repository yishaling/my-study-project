package enjoy.enjoy.spring.core.spring_03_life_cycle.configs;

import enjoy.enjoy.spring.core.spring_03_life_cycle.beans.Bike;
import enjoy.enjoy.spring.core.spring_03_life_cycle.beans.CyBike;
import enjoy.enjoy.spring.core.spring_03_life_cycle.beans.Jsr250Bike;
import enjoy.enjoy.spring.core.spring_03_life_cycle.beans.MyBeanPostProcessor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BeanConfig {
    @Bean(initMethod = "initMethod", destroyMethod = "destroyBean")
    public Bike Bike() {
        return new Bike();
    }

    @Bean
    public CyBike CyBike() {
        return new CyBike();
    }

    @Bean
    public Jsr250Bike Jsr250Bike() {
        return new Jsr250Bike();
    }

    @Bean
    public MyBeanPostProcessor PostProcessBike() {
        return new MyBeanPostProcessor();
    }
}
