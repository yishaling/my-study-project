package enjoy.enjoy.spring.core.spring_01;

import enjoy.enjoy.spring.core.spring_01.beans.MyPrototypeBean;
import enjoy.enjoy.spring.core.spring_01.beans.MySingletonBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

@Configuration
public class BeanConfig {
    /**
     * 在容器启动的时候创建Bean
     * @return
     */
    @Bean
    public MySingletonBean MySingletonBean() {
        System.out.println("MySingletonBean creating");
        return new MySingletonBean();
    }

    /**
     * 获取的时候创建Bean
     * @return
     */
    @Bean
    @Scope("prototype")
    public MyPrototypeBean myPrototypeBean() {
        System.out.println("MyPrototypeBean creating");
        return new MyPrototypeBean();
    }
}
