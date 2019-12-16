package enjoy.enjoy.spring.core.spring_04.configs;

import enjoy.enjoy.spring.core.spring_04.beans.AutoAndValueBean;
import enjoy.enjoy.spring.core.spring_04.beans.PlaneBean;
import org.springframework.context.annotation.*;

@Configuration
@Import({AutoAndValueBean.class})
@PropertySources({@PropertySource("test.properties")})
public class BeanConfigs {
    @Bean
    public PlaneBean Plane(){
        return new PlaneBean();
    }
}
