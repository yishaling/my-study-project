package enjoy.enjoy.spring.core.spring_02.config;

import enjoy.enjoy.spring.core.spring_02.beans.UserController2;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.ImportBeanDefinitionRegistrar;

@Configuration
@Import({UserController2.class,ConfigImportSelector.class, ConfigImportRegister.class})
public class BeanConfig2 {

}
