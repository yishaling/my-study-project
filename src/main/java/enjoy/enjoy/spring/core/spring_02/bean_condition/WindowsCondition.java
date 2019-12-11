package enjoy.enjoy.spring.core.spring_02.bean_condition;

import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.context.annotation.Condition;
import org.springframework.context.annotation.ConditionContext;
import org.springframework.core.env.Environment;
import org.springframework.core.type.AnnotatedTypeMetadata;

public class WindowsCondition implements Condition {
//    ReentrantLock lock=new ReentrantLock();
//    java.util.concurrent.locks.Condition l1=lock.newCondition();
    public boolean matches(ConditionContext context, AnnotatedTypeMetadata metadata) {
        ConfigurableListableBeanFactory beanFactory = context.getBeanFactory();
        Environment environment = context.getEnvironment();
        String os_name = environment.getProperty("os.name");
        System.out.println("操作系统："+os_name);
        if(os_name.contains("Windows")){
            return true;
        }
        return false;
    }
}
