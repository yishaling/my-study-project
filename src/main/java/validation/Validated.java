package validation;

import validation.flaginfo_validation.RegexType;

import java.lang.annotation.*;

@Documented
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
public @interface Validated {

    //是否可以为空
    boolean nullable() default false;

    //最大长度
    int maxLength() default 99999;

    //最小长度
    int minLength() default 0;

    //提供几种常用的正则验证
    RegexType regexType() default RegexType.NONE;

    //自定义正则验证
    String regexExpression() default "";

    //参数或者字段描述,这样能够显示友好的异常信息
    String description() default "";


}
