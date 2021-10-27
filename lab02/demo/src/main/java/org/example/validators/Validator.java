package org.example.validators;


import org.example.annotations.NotNull;
import org.example.annotations.Range;
import org.example.annotations.Regex;

import java.lang.reflect.Field;
import java.util.*;


public class Validator {

    public <TClass> ValidationResult validate(TClass object) {
        ValidationResult validationResult = new ValidationResult();
        validationResult.setValid(true);
        validationResult.setValidatedObject(object);

        for (Field field : object.getClass().getDeclaredFields()) {
            field.setAccessible(true);
            List<String> errors = new ArrayList<>();

            
            // not null validation

            if (field.isAnnotationPresent(NotNull.class)) {
                try {
                    if (field.get(object) == null) {
                        errors.add(field.getAnnotation(NotNull.class).message());
                        errors.add(field.getAnnotation(NotNull.class).message1());
                        validationResult.setValid(false);

                    }
                } catch (IllegalAccessException exc) {
                    exc.printStackTrace();
                }
            }
            
            
            
            //regex validation

            if (field.isAnnotationPresent(Regex.class)){
                try {
                    if (!field.get(object).toString().matches(field.getAnnotation(Regex.class).pattern())){
                        
                        errors.add(field.getAnnotation(Regex.class).message());
                        validationResult.setValid(false);

                    }
                } catch (IllegalAccessException exc) {
                    exc.printStackTrace();
                }
            }



            // range validation

            if (field.isAnnotationPresent(Range.class)) {
                try {

                    if (!((int) field.get(object) > (int) field.getAnnotation(Range.class).min()
                        && (int) field.get(object) < (int) field.getAnnotation(Range.class).max())) {

                        errors.add(field.getAnnotation(Range.class).message());
                        validationResult.setValid(false);

                    }
                } catch (IllegalAccessException exc) {
                    exc.printStackTrace();
                }
            }


            if (errors.size() != 0) {
                validationResult.getNotValidFields().put(field.getName(), errors);
                validationResult.setValid(false);
            }
        }
        return validationResult;
    }
}

