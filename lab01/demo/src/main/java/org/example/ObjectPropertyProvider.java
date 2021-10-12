package org.example;


import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ObjectPropertyProvider {

    public List<Method> getPublicGetters(Class<?> clazz){
        List<Method> listGetters = new ArrayList<Method>(); //wyjściowy array
        Method[] methodsOfClass = clazz.getMethods(); //wszystkie metody klasy
        for(Method method : methodsOfClass){ //dla wszystkich metod danej klasy
            if(method.getModifiers() == Modifier.PUBLIC) { //czy jest public
                if((method.getName().startsWith("get") && !method.getReturnType().equals(void.class)) || (method.getName().startsWith("is") && method.getReturnType().equals(boolean.class)) ) { //czy posiada get lub is
                    if(method.getParameterTypes().length == 0){ //czy jego parematry posiadają długość 0
                        listGetters.add(method);
                    }

                }
            }
        }
        return listGetters;
        //return Arrays.stream(clazz.getDeclaredMethods()).toList();

    }


    public List<Method> getPublicSetters(Class<?> clazz){
        List<Method> listSetters = new ArrayList<Method>();
        Method[] methodsOfClass = clazz.getMethods();
        for(Method method : methodsOfClass) {
            if(method.getModifiers() == Modifier.PUBLIC) {
                if(method.getName().startsWith("set") && method.getReturnType().equals(void.class)){
                    if(method.getParameterTypes().length == 1) {
                        listSetters.add(method);
                    }
                }
            }
        }

        return listSetters;
    }


    public List<Field> getFieldsForPublicProperties(Class<?> clazz){
        Field[] fieldsOfClass = clazz.getFields();
        List<Field> fieldTested = new ArrayList<Field>();
        int byq = 0;
        for(Field field : fieldsOfClass) {
            if(field.getName().startsWith("set")){
                byq += 1;
            }
            else if(field.getName().startsWith("get") || field.getName().startsWith("is")){
                byq += 1;
            }
        }
        if(byq > 0) {

        }

        return fieldTested;

    }


}
