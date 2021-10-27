package org.example.validators;

import org.example.annotations.Range;
import java.lang.reflect.Field;
import java.util.List;
import java.util.Map;

public class RangeValidator {
    public static void CheckForRange(ValidationResult validationResult, Map<String, List<String>> notValidFields, Field field) {
        Validator.ValidatorFalser(validationResult, notValidFields,field);
        notValidFields.get(field.getName()).add(field.getAnnotation(Range.class).message());
    }
}
