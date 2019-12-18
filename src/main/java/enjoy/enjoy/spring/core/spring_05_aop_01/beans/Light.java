package enjoy.enjoy.spring.core.spring_05_aop_01.beans;

import org.springframework.beans.factory.BeanNameAware;
import org.springframework.context.EmbeddedValueResolverAware;
import org.springframework.stereotype.Component;
import org.springframework.util.StringValueResolver;

@Component
public class Light implements BeanNameAware ,EmbeddedValueResolverAware{
    @Override
    public void setBeanName(String name) {

    }

    @Override
    public void setEmbeddedValueResolver(StringValueResolver resolver) {
        String result=resolver.resolveStringValue("${os.name},#{3*5}");
        System.out.println(result);
    }
}
