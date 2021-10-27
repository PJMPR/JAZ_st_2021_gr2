package org.example.validators;

import org.example.annotations.NotNull;
import org.example.annotations.Range;
import org.example.annotations.Regex;

import java.lang.reflect.Field;
import java.util.*;

public class Validator {

    public <TClass> ValidationResult validate(TClass object) throws IllegalAccessException {

        Map<String, List<String>> notValidFields = new HashMap<>();
        ValidationResult validationResult = new ValidationResult(object, true, notValidFields);
        Field[] fieldList = object.getClass().getDeclaredFields();

        for (Field field : fieldList) {
            field.setAccessible(true);
            if ((field.isAnnotationPresent(NotNull.class))
                    && (field.get(object) == null)) {
                NotNullValidator.CheckForNotNull(validationResult, notValidFields, field);
            } else if ((field.isAnnotationPresent(Range.class))
                    && (((int) field.get(object) < field.getAnnotation(Range.class).min()
                    || (int) field.get(object) > field.getAnnotation(Range.class).max()))
                    && (!notValidFields.containsKey(field.getName()))) {
                RangeValidator.CheckForRange(validationResult, notValidFields, field);
            } else if (field.isAnnotationPresent(Regex.class)
                    && (!((String) field.get(object)).matches("^\\w+@[a-zA-Z_]+?\\.[a-zA-Z]{2,3}$")
                    && (!notValidFields.containsKey(field.getName())))) {
                RegexValidator.CheckForRegex(validationResult, notValidFields, field);
            }
        }
        return validationResult;
    }

    public static void ValidatorFalser(ValidationResult
                                               validationResult, Map<String, List<String>> notValidFields, Field field) {
        validationResult.setValid(false);
        notValidFields.put(field.getName(), new ArrayList<>());
    }
}
