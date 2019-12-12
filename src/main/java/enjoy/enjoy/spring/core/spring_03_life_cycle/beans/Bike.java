package enjoy.enjoy.spring.core.spring_03_life_cycle.beans;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;

public class Bike {
    public Bike() {
        System.out.println("Bike:constructor...");
    }

    public void initMethod() {
        System.out.println("Bike:initMethod...");
    }

    public void destroyBean() {
        System.out.println("Bike:destroyBean...");
    }


}
