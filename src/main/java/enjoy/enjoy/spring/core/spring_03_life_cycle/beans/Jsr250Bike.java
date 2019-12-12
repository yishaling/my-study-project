package enjoy.enjoy.spring.core.spring_03_life_cycle.beans;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

public class Jsr250Bike {
    /**
     * 创建的时候调用
     */
    @PostConstruct
    public void jsr250BikePost(){
        System.out.println("jsr250BikePost");
    }

    /**
     * 销毁前调用
     */
    @PreDestroy
    public void Jsr250BikeDestroy(){
        System.out.println("Jsr250BikeDestroy");
    }
}
