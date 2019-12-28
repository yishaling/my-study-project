//package test.spring_18;
//
//import org.junit.Test;
//import test.spring_18.annotations.Autowared;
//import test.spring_18.annotations.Service;
//
//import java.lang.reflect.Field;
//
//public class MainClass {
//    public static void main(String[] args) {
//
//    }
//    @Test
//    public void test() throws Exception{
//        UserController userController=new UserController();
//        Class<? extends UserController> controllerClass = userController.getClass();
//        Field[] declaredFields = controllerClass.getDeclaredFields();
//        for(Field f:declaredFields){
//            Autowared annotation = f.getAnnotation(Autowared.class);
//            if(null !=annotation){
//                f.setAccessible(true);
//                Class<?> injectClazz = f.getType();
//                Service instanceAnnotation = injectClazz.getAnnotation(Service.class);
//                if(instanceAnnotation!=null){
//                    Object o = injectClazz.getConstructor().newInstance();
//                    f.set(userController,o);
//                }else {
//                    throw new Exception(controllerClass.getName()+"'s Field '"+ f.getName()+"'  autowared field has no @Service or @Controller ");
//                }
//            }
//
//        }
//        UserService userService = userController.getUserService();
//        System.out.println(userService);
//
//    }
//}
