package org.example.validators;


import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

public class Validator {

    public <TClass> ValidationResult validate(TClass object) {
        ValidationResult validationResult = new ValidationResult();

        validationResult.setValidatedObject(object);
        validationResult.setValid(true);

        for (Field field : object.getClass()
                        .getDeclaredFields()) {
            List<String> errors = new ArrayList<>();
            field.setAccessible(true);
        }


        return validationResult;
    }
}
