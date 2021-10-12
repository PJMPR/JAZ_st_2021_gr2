package org.example;


import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ObjectPropertyProvider {

    public List<Method> getPublicGetters(Class<?> clazz){
        ArrayList<Method> list = new ArrayList<Method>();
        //Method m = Arrays.stream(clazz.getDeclaredMethods()).findFirst().or(null).get();
        Method[] methods = clazz.getDeclaredMethods();
        for(Method method : methods){
            if (isGetter(method)){
                System.out.println("getter: " + method);
                list.add(method);
            }
        }
        return list;

        //return Arrays.stream(clazz.getDeclaredMethods()).toList();

    }

    public static boolean isGetter(Method method){
        if(!method.getName().startsWith("get"))
            return false;
        if(method.getParameterTypes().length != 0)
            return false;
        if(void.class.equals(method.getReturnType()))
            return false;
        if(method.getReturnType().equals(int.class))
            return false;
        return true;
    }


    public List<Method> getPublicSetters(Class<?> clazz){
        ArrayList<Method> list = new ArrayList<Method>();
        //Method m = Arrays.stream(clazz.getDeclaredMethods()).findFirst().or(null).get();
        Method[] methods = clazz.getDeclaredMethods();
        for(Method method : methods){
            if (isSetter(method)){
                System.out.println("setter: " + method);
                list.add(method);
            }
        }
        return list;
        //return Arrays.stream(clazz.getDeclaredMethods()).toList();
    }

    public static boolean isSetter(Method method){
        if(!method.getName().startsWith("set"))
            return false;
        if(method.getParameterTypes().length != 1)
            return false;
        if(method.getName().matches("^is[a-z].*") &&
                method.getReturnType().equals(boolean.class))
            return false;
        return true;
    }


    public List<Field> getFieldsForPublicProperties(Class<?> clazz){

        return Arrays.stream(clazz.getDeclaredFields()).toList();

    }


}
