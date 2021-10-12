package org.example;

import javax.security.auth.Subject;
import java.lang.reflect.Method;
import java.util.List;

public class Application {


    public static void main(String[] args){
        Class myClass = new myClass().getClass();
        ObjectPropertyProvider provider = new ObjectPropertyProvider();
        List<Method> methods = provider.getPublicGetters(myClass);

        for (Method method:methods) {
            System.out.println(method.getName());
        }





    }
}
