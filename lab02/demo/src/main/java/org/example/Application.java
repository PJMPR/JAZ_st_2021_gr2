package org.example;

import org.example.annotations.NotNull;
import org.example.validators.Validator;

public class Application {
    public static void main(String[] args) throws IllegalAccessException {
        Validator validator= new Validator();
        validator.validate(new Sample());
    }
}

class Sample {
    @NotNull
    public String name;
    @NotNull
    public String nameTwo;
}

