package org.example.validators;


import org.example.annotations.NotNull;
import org.example.annotations.Range;
import org.example.annotations.Regex;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

public class Validator {

    public <TClass> ValidationResult validate(TClass object){
        List<String> list=new ArrayList<>();
        ValidationResult validationResult=new ValidationResult();
        validationResult.setValidatedObject(object);
        validationResult.setValid(true);
        for (Field field: object.getClass().getDeclaredFields()){
            field.setAccessible(true);
            Object o= null;
            try {
                o = field.get(object);

            if (field.isAnnotationPresent(NotNull.class)){
                if (o==null){
                    validationResult.setValid(false);
                    list.add(field.getAnnotation(NotNull.class).message());
                }
            }
            if (field.isAnnotationPresent(Range.class)){
                if((Integer) o<field.getDeclaredAnnotation(Range.class).min() ||
                        (Integer) o >field.getDeclaredAnnotation(Range.class).max()){
                    validationResult.setValid(false);
                    list.add(field.getAnnotation(Range.class).message());
                }
            }
            if (field.isAnnotationPresent(Regex.class)){
                if (!o.toString().matches(field.getDeclaredAnnotation(Regex.class).pattern())){
                    validationResult.setValid(false);
                    list.add(field.getAnnotation(Regex.class).message());
                }
            }
            if(list.isEmpty()==false){
                validationResult.getNotValidFields().put(field.getName(),new ArrayList<>());

            }
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
        }


        return null;
    }
}
