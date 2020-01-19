package javassist_01.utils;

import javassist_01.annotations.Column;

import java.lang.reflect.Field;
import java.util.Map;

/**
 * 反射过慢
 * @param <T>
 */
@Deprecated
public final class EntityHelper<T> {

    public T setValues(T object,Map<String,String> map) throws IllegalAccessException {
        Class clzz=object.getClass();
        Field[] fields = clzz.getFields();
        for(Field f:fields){
            Column annotation = f.getAnnotation(Column.class);
            String value = annotation.value();
            String resultValue = map.get(value);
            f.setAccessible(true);
            f.set(object,resultValue);

        }
        return object;

    }
}
