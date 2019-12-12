package enjoy.enjoy.spring.core.spring_03_life_cycle.beans;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;

public class CyBike implements InitializingBean,DisposableBean {
    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println("CyBike--> InitializingBean:afterPropertiesSet...");
    }

    @Override
    public void destroy() throws Exception {
        System.out.println("CyBike--> DisposableBean :afterPropertiesSet...");
    }
}
