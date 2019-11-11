package test.spring_18.annotations;

import java.lang.annotation.*;


@Inject
@Documented
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
public @interface Service   {
}
