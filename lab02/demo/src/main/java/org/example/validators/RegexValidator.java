package org.example.validators;

import org.example.annotations.Regex;
import java.lang.reflect.Field;
import java.util.List;
import java.util.Map;

public class RegexValidator {
    public static void CheckForRegex(ValidationResult validationResult, Map<String, List<String>> notValidFields, Field field) {
        Validator.ValidatorFalser(validationResult, notValidFields,field);
        notValidFields.get(field.getName()).add(field.getAnnotation(Regex.class).message());
    }
}
