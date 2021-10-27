package org.example.validators;


import org.example.annotations.NotNull;
import org.example.annotations.Range;
import org.example.annotations.Regex;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

public class Validator {

    public <TClass> ValidationResult validate(TClass object){

        Field[] fields = object.getClass().getDeclaredFields();
        ValidationResult result = new ValidationResult();
        result.setValidatedObject(object);

        for (Field field:fields) {
            List<String> errorMessages = new ArrayList<>();
            ValidatorFacade facade = new ValidatorFacade(field);

            if (facade.isValidNotNull())
            {
                errorMessages.add(field.getAnnotation(NotNull.class).error());
            }
            if (facade.hasRegex() && !facade.isValidRegex(object))
            {
                errorMessages.add(field.getAnnotation(Regex.class).message());
            }
            if (facade.isValidRange(object))
            {
                errorMessages.add("Number out of range"+
                        (field.getAnnotation(Range.class).min())+ " - "+
                        (field.getAnnotation(Range.class).max()));

            }
            if (errorMessages.size() > 0) {
                result.setValid(false);
            }
            result.setNotValidFields(field.getName(), errorMessages);
        }

        return result;
    }


}
