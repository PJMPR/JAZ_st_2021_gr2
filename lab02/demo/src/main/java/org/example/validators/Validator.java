package org.example.validators;

import org.example.annotations.NotNull;
import org.example.annotations.Regex;
import org.example.annotations.Range;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Validator {

    public <TClass> ValidationResult validate(TClass object) throws IllegalAccessException {

        Map<String, List<String>> notValidFields = new HashMap<>();
        ValidationResult validationResult = new ValidationResult(notValidFields, object, true);
        Field[] fieldList = object.getClass().getDeclaredFields();

        for (Field field : fieldList) {
            field.setAccessible(true);
            if ((field.isAnnotationPresent(NotNull.class))
                    && (field.get(object) == null)) {
                vNotNull.NotNullCheck(validationResult, notValidFields, field);
            } else if ((field.isAnnotationPresent(Range.class))
                    && (((int) field.get(object) < field.getAnnotation(Range.class).min()
                    || (int) field.get(object) > field.getAnnotation(Range.class).max()))
                    && (!notValidFields.containsKey(field.getName()))) {
                vRange.RangeCheck(validationResult, notValidFields, field);
            } else if (field.isAnnotationPresent(Regex.class)
                    && (!((String) field.get(object)).matches("^\\w+@[a-zA-Z_]+?\\.[a-zA-Z]{2,3}$")
                    && (!notValidFields.containsKey(field.getName())))) {
                vRegex.RegexCheck(validationResult, notValidFields, field);
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

