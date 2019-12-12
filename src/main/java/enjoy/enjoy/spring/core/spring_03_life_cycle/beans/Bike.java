package enjoy.enjoy.spring.core.spring_03_life_cycle.beans;

public class Bike {
    public Bike() {
        System.out.println("Bike:constructor...");
    }

    public void initMethod() {
        System.out.println("Bike:initMethod...");
    }

    public void distrory() {
        System.out.println("Bike:distrory...");
    }
}
