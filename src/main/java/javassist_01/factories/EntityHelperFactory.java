package javassist_01.factories;

import hero_test.hero_08_callback.UserEntity;
import javassist.*;
import javassist_01.utils.AbstractEntityHelper;

import java.util.HashMap;
import java.util.Map;

/**
 * 创建每个实体对应的helper
 */
public class EntityHelperFactory {
    public static void main(String[] args) {
        try {
            EntityHelperFactory.getEntityHelper(UserEntity.class);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public static AbstractEntityHelper getEntityHelper(Class clzz) throws Exception {
        if(clzz==null){
            return null;
        }
        ClassPool  classPool=ClassPool.getDefault();
        classPool.appendSystemPath();
        //需要引入的类
        //相当于 import java.util.Map;
        classPool.importPackage(Map.class.getName());
        //相当于 import  javassist_01.entity.UserInfo;
        classPool.importPackage(clzz.getName());
        //拿到父类 并包装
        CtClass ctClass = classPool.getCtClass(AbstractEntityHelper.class.getName());
        //取名字 就是某个 xxx_helper
        String helperName=clzz.getName()+"_helper";

        // 生成一个字节码 相当于写一了一个 public class xxx extends xxx.xxx.AbstractEntityHelper{}
        // 让 xxx_helper extends  AbstractEntityHelper
        CtClass helperClass = classPool.makeClass(helperName,ctClass);
        //生成构造器 public xxxEntity_helper(){}
        CtConstructor ctConstructor=new CtConstructor(new CtClass[0],helperClass);
        ctConstructor.setBody("{}");
        //创建一个方法
        StringBuilder methodStrBuilder=new StringBuilder();
        methodStrBuilder.append("public Object setValue(java.util.Map map){\n");
        methodStrBuilder.append("return null;");
        methodStrBuilder.append("}");
        CtMethod ctMethod=CtMethod.make(methodStrBuilder.toString(),helperClass);
        Class<?> heplerClassObject = helperClass.toClass();

        return (AbstractEntityHelper) heplerClassObject.newInstance();
    }
}
