package org.example;


import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.List;

public class ObjectPropertyProvider {

    public List<Method> getPublicGetters(Class<?> clazz){
        ArrayList<Method> list = new ArrayList<>();
        Method[] m = clazz.getDeclaredMethods();
        for (Method method : m)
            if (isGetter(method))
                list.add(method);

        return list;
    }

    public static boolean isGetter(Method m) {
        if (Modifier.isPublic(m.getModifiers()) && m.getParameterTypes().length == 0)
            if (m.getName().startsWith("get") && !m.getReturnType().equals(void.class))
                return true;
            if (m.getName().startsWith("is") && m.getReturnType().equals(boolean.class))
                return true;

        return false;
    }

    public List<Method> getPublicSetters(Class<?> clazz){
        ArrayList<Method> list = new ArrayList<>();
        Method[] m = clazz.getDeclaredMethods();
        for (Method method : m)
            if (isSetter(method))
                list.add(method);

        return list;
    }

    public static boolean isSetter(Method method) {
        if (Modifier.isPublic(method.getModifiers()))
            if (method.getReturnType().equals(void.class))
                if (method.getParameterTypes().length == 1)
                    if (method.getName().startsWith("set"))
                        return true;

        return false;
    }

    public List<Field> getFieldsForPublicProperties(Class<?> clazz){
        return null;
    }

}
