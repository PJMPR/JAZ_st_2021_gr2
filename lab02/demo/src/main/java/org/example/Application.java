package org.example;

import org.example.annotations.NotNull;
import org.example.validators.Validator;

public class Application {
    public static void main(String[] args) throws NoSuchFieldException, IllegalAccessException {
        Sample obj = new Sample();
        Validator validator= new Validator();
        validator.validate(obj);
    }
}

