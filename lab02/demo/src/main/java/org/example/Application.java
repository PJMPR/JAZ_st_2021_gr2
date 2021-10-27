package org.example;

import java.lang.reflect.Field;
import org.jetbrains.annotations.NotNull;
import org.example.validators.Validator;

public class Application {
    public static void main(String[] args) throws NoSuchFieldException, IllegalAccessException {

        System.out.println("adam@wp.pl".matches("^\\w+@[a-zA-Z_]+?\\.[a-zA-Z]{2,3}$"));
        //create object of class Sample
        Sample object = new Sample();
        //initialize validator
        Validator validator = new Validator();
        //validate the object of class Sample
        validator.validate(object);
    }
}



class Sample{
    //new variables accessible outside of class, they can't have nothing inside of them(NotNull)
    @NotNull
    public String name;
    @NotNull
    public String name2;
}