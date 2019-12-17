package enjoy.enjoy.spring.core.spring_04.configs;

import enjoy.enjoy.spring.core.spring_04.beans.Bean1;
import enjoy.enjoy.spring.core.spring_04.beans.Bean2;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
@Import({Bean1.class,Bean2.class})
public class SpringBeanConfig {
}
