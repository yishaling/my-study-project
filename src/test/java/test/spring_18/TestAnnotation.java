package test.spring_18;

import org.junit.Test;
import test.spring_18.annotations.Autowared;
import test.spring_18.annotations.Inject;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;

public class TestAnnotation {
    public static void main(String[] args) {

    }
    @Test
    public void test() throws Exception{
        UserController userController=new UserController();
        Class<? extends UserController> controllerClass = userController.getClass();
        Field[] declaredFields = controllerClass.getDeclaredFields();
        for(Field f:declaredFields){
            Autowared annotation = f.getAnnotation(Autowared.class);
            if(null !=annotation){
                f.setAccessible(true);
                Class<?> injectClazz = f.getType();
                Annotation[] annotations = injectClazz.getAnnotations();
                boolean isInject=false;
                for(Annotation a:annotations){
                    Inject inject = a.getClass().getAnnotation(Inject.class);
                    Annotation[] injects = a.getClass().getAnnotations();

                    System.out.println(inject);
//                    if(a.getClass().getAnnot(Inject.class)!=null){
//                        isInject=true;
//                    }
        }

        if(isInject){
            Object o = injectClazz.getConstructor().newInstance();
            f.set(userController,o);
        }else {
            throw new Exception(controllerClass.getName()+"'s Field '"+ f.getName()+"'  autowared field has no @Service or @Controller ");
        }
    }

        }
        UserService userService = userController.getUserService();
        System.out.println(userService);

    }
}
