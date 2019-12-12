package enjoy.enjoy.spring.core.spring_02.config;

import org.springframework.context.annotation.ImportSelector;
import org.springframework.core.type.AnnotationMetadata;
import org.springframework.stereotype.Component;


public class ConfigImportSelector implements ImportSelector {
    @Override
    public String[] selectImports(AnnotationMetadata importingClassMetadata) {
        String[] imports={"enjoy.enjoy.spring.core.spring_02.beans.ImportBeanTest"};
        return imports;
    }
}
