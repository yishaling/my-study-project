package enjoy.enjoy.spring.core.spring_05_aop_01.beans;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.stereotype.Component;

/**
 * 1.before
 * 2.after
 * 3.return
 * 4.around
 * 5.Throwing
 */
@Component
@Aspect
public class LightAspects {
    {
        System.out.println("init...");
    }
    @Pointcut("execution(* enjoy.enjoy.spring.core.spring_05_aop_01.beans.*Bean.*(..))")
    public void pointcut() {
    }

    @Before("pointcut()")
    public void logBefore() {
        System.out.println("logBefore");
    }

    @After("pointcut()")
    public void logAfter() {
        System.out.println("logAfter");
    }

    @Around("pointcut()")
    public void logAround(ProceedingJoinPoint point) {
        try {
            point.proceed();
        } catch (Throwable throwable) {
            throwable.printStackTrace();
        }
        System.out.println("logAround");
    }
}
