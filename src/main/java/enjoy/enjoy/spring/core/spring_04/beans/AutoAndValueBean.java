package enjoy.enjoy.spring.core.spring_04.beans;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;

public class AutoAndValueBean {
    @Value("1")
    private Integer age;
    @Value("this is  a name ")
    private String name;
    @Value("${mine.color}")
    private String color;
    @Qualifier("Plane")
    @Autowired
    private PlaneBean planeBean;
    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public PlaneBean getPlaneBean() {
        return planeBean;
    }

    public void setPlaneBean(PlaneBean planeBean) {
        this.planeBean = planeBean;
    }
}
