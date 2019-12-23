package enjoy.enjoy.spring.core.spring_05_aop_01.configs;

import org.springframework.context.annotation.*;
import org.springframework.core.type.AnnotatedTypeMetadata;

@Configuration
public class BeanConfigs {
    @Configuration
    @Conditional(ConditionBean.class)
    public static class Config1{

    }
    @Configuration
    @Import(Config1.class)
   public  static class  Config2{

    }
    public static class  ConditionBean implements Condition{

        @Override
        public boolean matches(ConditionContext context, AnnotatedTypeMetadata metadata) {
            return false;
        }
    }

}
