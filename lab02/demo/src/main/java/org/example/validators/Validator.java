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
        for (int i = 0; i < fieldList.length; i++) {
            Field list =fieldList[i];
            list.setAccessible(true);
            if (list.isAnnotationPresent(NotNull.class)) {
                if (list.get(object) == null) {
                    validationResult.setValid(false);
                    notValidFields.put(list.getName(), new ArrayList<>());
                    notValidFields.get(list.getName()).add(list.getAnnotation(NotNull.class).message());
                }
            }

            if (list.isAnnotationPresent(Range.class)) {
                if ((int) list.get(object) < list.getAnnotation(Range.class).min()
                        || (int) list.get(object) > list.getAnnotation(Range.class).max()) {
                    validationResult.setValid(false);
                    if (notValidFields.containsKey(list.getName())) {
                        notValidFields.get(list.getName()).add(list.getAnnotation(Range.class).message());
                    } else {
                        notValidFields.put(list.getName(), new ArrayList<>());
                        notValidFields.get(list.getName()).add(list.getAnnotation(Range.class).message());
                    }
                }
            }

            if (list.isAnnotationPresent(Regex.class)) {
                if (!((String) list.get(object)).matches("^\\w+@[a-zA-Z_]+?\\.[a-zA-Z]{2,3}$")) {
                    validationResult.setValid(false);
                    if (notValidFields.containsKey(list.getName())) {
                        notValidFields.get(list.getName()).add(list.getAnnotation(Regex.class).message());
                    } else {
                        notValidFields.put(list.getName(), new ArrayList<>());
                        notValidFields.get(list.getName()).add(list.getAnnotation(Regex.class).message());
                    }
                }
            }

        }


        return validationResult;
    }

}
