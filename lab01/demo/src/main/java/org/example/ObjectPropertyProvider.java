package org.example;


import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ObjectPropertyProvider {

    public List<Method> getPublicGetters(Class<?> clazz) {
        ArrayList<Method> list = new ArrayList<>();
        Method[] m = clazz.getDeclaredMethods();
        for (Method method : m)
            if (isGetter(method))
                list.add(method);

        return Arrays.stream(clazz.getDeclaredMethods()).toList();
    }

    public List<Method> getPublicSetters(Class<?> clazz) {

        return Arrays.stream(clazz.getDeclaredMethods()).toList();
    }


    public List<Field> getFieldsForPublicProperties(Class<?> clazz) {

        return Arrays.stream(clazz.getDeclaredFields()).toList();

    }

    public static boolean isGetter(Method m) {
        if (Modifier.isPublic(m.getModifiers()) && m.getParameterTypes().length == 0) {
            if (m.getName().startsWith("get") && !m.getReturnType().equals(void.class)) {
                return true;
            }
            if (m.getName().startsWith("is") && !m.getReturnType().equals(boolean.class)) {
                return true;
            }
        }
        return false;
    }
}


