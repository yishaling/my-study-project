package enjoy.enjoy.spring.core.spring_04.configs;

import enjoy.enjoy.spring.core.spring_04.beans.Plane;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BeanConfigs {
    @Bean
    public Plane Plane(){
        return new Plane();
    }
}
