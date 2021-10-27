package org.example.validators;

import org.example.annotations.NotNull;

import java.lang.reflect.Field;
import java.util.List;
import java.util.Map;

public class vNotNull {
    public static void NotNullCheck(ValidationResult validationResult, Map<String, List<String>> notValidFields, Field field) {
        Validator.ValidatorFalser(validationResult, notValidFields,field);
        notValidFields.get(field.getName()).add(field.getAnnotation(NotNull.class).message());
        notValidFields.get(field.getName()).add(field.getAnnotation(NotNull.class).messageTwo());
    }
}
