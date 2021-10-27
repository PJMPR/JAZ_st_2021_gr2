package org.example.validators;

import org.example.annotations.NotNull;
import org.example.annotations.Regex;
import org.example.annotations.Range;
import java.lang.reflect.Field;
import java.util.*;

public class Validator {

    public <TClass> ValidationResult validate(TClass object){

        ValidationResult result = new ValidationResult();
        result.setValid(true);
        result.setValidatedObject(object);

        for (Field f : object.getClass().getDeclaredFields()) {
            f.setAccessible(true);
            List<String> errorList = new ArrayList<>();

//            check 1
            if (f.isAnnotationPresent(Regex.class)){
                try {
                    if (!f.get(object).toString().matches("^\\w+@[a-zA-Z_]+?\\.[a-zA-Z]{2,3}$")) {
                        errorList.add(f.getAnnotation(Regex.class).message());
                        result.setValid(false);

                    }
                } catch (IllegalAccessException exception) {
                    exception.printStackTrace();
                }
            }

//            check 2
            if (f.isAnnotationPresent(Range.class)) {
                try {
                    int number = (int) f.get(object);
                    if (!(number > 0 && number < 10)) {
                        errorList.add(f.getAnnotation(Range.class).message1());
                        result.setValid(false);

                    }
                } catch (IllegalAccessException exception) {
                    exception.printStackTrace();
                }
            }

//            check 3
            if (f.isAnnotationPresent(NotNull.class)) {
                try {
                    if (Objects.isNull(f.get(object))) {
                        errorList.add(f.getAnnotation(NotNull.class).message2());
                        errorList.add(f.getAnnotation(NotNull.class).message3());
                        result.setValid(false);

                    }
                } catch (IllegalAccessException exception) {
                    exception.printStackTrace();
                }
            }

            if (!errorList.isEmpty()) {
                result.getNotValidFields().put(f.getName(), errorList);
            }
        }
        return result;
    }
}
