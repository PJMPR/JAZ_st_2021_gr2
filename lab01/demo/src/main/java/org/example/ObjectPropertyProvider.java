package org.example;


import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ObjectPropertyProvider {

    public List<Method> getPublicGetters(Class<?> clazz){

        List<Method> methods = Arrays.asList(clazz.getMethods());
        List<Method> getterMethods = new ArrayList<>();

        for (Method method:methods) {
            if (isGetter(method))
            {
                getterMethods.add(method);
            }
        }
        return getterMethods;
        
    }


    public List<Method> getPublicSetters(Class<?> clazz){
        List<Method> methods = Arrays.asList(clazz.getMethods());
        List<Method> setterMethods = new ArrayList<>();
        for (Method method:methods) {
            if (isSetter(method))
            {
                setterMethods.add(method);
            }
        }
        return setterMethods;
    }


    public List<Field> getFieldsForPublicProperties(Class<?> clazz){
        List<Method> methods = Arrays.asList(clazz.getMethods());
        List<Field> fields = Arrays.asList(clazz.getFields());
        for (Method method:methods) {
            if (isSetter(method) || isSetter(method))
            {
                //fields.add(method.);
            }
        }

        return fields;

   }

    public static boolean isGetter(Method method){
        if(!method.getName().startsWith("get"))      return false;
        if(method.getParameterTypes().length != 0)   return false;
        if(method.getReturnType().equals(void.class)) return false;
        return true;
    }

    public static boolean isSetter(Method method){
        if(!method.getName().startsWith("set")) return false;
        if(method.getParameterTypes().length != 1) return false;
        return true;
    }


}
