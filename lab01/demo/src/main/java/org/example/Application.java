package org.example;

import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

public class Application {

    public static boolean isGetter(Method method){
        if(!Modifier.toString(method.getModifiers()).startsWith("public")) return false;
        if(!method.getName().startsWith("get"))      return false;
        if(!method.getName().startsWith("is"))      return false;
        if(method.getParameterTypes().length != 0)   return false;
        return true;
    }

    public static boolean isSetter(Method method){
        if(!Modifier.toString(method.getModifiers()).startsWith("public")) return false;
        if(!method.getName().startsWith("set")) return false;
        if(method.getParameterTypes().length != 1) return false;
        if(!void.class.equals(method.getReturnType())) return false;
        return true;
    }
    public static boolean haveField(Method method){
        if(!method.getName().startsWith("get")) return false;
        if(!method.getName().startsWith("is")) return false;
        if(!method.getName().startsWith("set")) return false;
        if(!method.getName().contains("field")) return false;
        return true;
    }

}
