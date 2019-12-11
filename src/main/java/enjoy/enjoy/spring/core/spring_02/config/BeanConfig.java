package enjoy.enjoy.spring.core.spring_02.config;

import enjoy.enjoy.spring.core.spring_02.bean_condition.WindowsCondition;
import enjoy.enjoy.spring.core.spring_02.beans.UserController;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Conditional;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BeanConfig {
    @Bean
    @Conditional(WindowsCondition.class)
    public UserController userController (){
        System.out.println("bean:userController creating....");
        return  new UserController();
    }
}
