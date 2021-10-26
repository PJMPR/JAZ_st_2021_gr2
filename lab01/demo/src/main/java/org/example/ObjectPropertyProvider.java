package org.example;


import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ObjectPropertyProvider {

    public List<Method> getPublicGetters(Class<?> clazz){
        return Arrays
                .stream(clazz.getDeclaredMethods())
                .filter(m->
                        new SimpleMethod(m).isGetter())
                .toList();
    }


    public List<Method> getPublicSetters(Class<?> clazz){
        List<Method> methods = Arrays.stream(clazz.getDeclaredMethods()).toList();
        List<Method> result = new ArrayList<>();
        for (Method m :methods ) {
            if(new SimpleMethod(m).isSetter())
                result.add(m);
        }

        return result;
    }


    public List<Field> getFieldsForPublicProperties(Class<?> clazz){

        List<Method> props = getPublicGetters(clazz);
        props.addAll(getPublicSetters(clazz));
        List<Field> fields = Arrays.stream(clazz.getDeclaredFields()).toList();
        List<Field> result = new ArrayList<>();
        for (Field field : fields) {
            for (Method method : props) {
                if(new SimpleMethod(method)
                        .getFieldName()
                        .equals(field.getName())
                        &&!result.contains(field))
                    result.add(field);
            }
        }

        return result;

    }


}
