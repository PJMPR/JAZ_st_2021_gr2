package org.example.validators;

<<<<<<< Updated upstream
=======
import org.example.annotations.NotNull;
import org.example.annotations.Range;
import org.example.annotations.Regex;

import java.lang.reflect.Field;
>>>>>>> Stashed changes
import java.util.ArrayList;
import java.util.List;

public class Validator {

    public <TClass> ValidationResult validate(TClass object) {
        ValidationResult result = new ValidationResult();
        List<String> errors = new ArrayList<>();
        result.setValidatedObject(object);
<<<<<<< Updated upstream


        
        return null;
=======
        result.setValid(true);

        for( Field f : object.getClass().getDeclaredFields()){
            f.setAccessible(true);



            //NotNull
            if (f.isAnnotationPresent(NotNull.class)) {
                try {
                    if (f.get(object) == null) {
                        //errors.add(f.getAnnotation(NotNull.class).isEmpty());
                        errors.add(f.getAnnotation(NotNull.class).isNull());
                        result.setValid(false);
                    }
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                }
            }


            //Range
            if (f.isAnnotationPresent(Range.class)){
                try{
                    Integer range = (Integer) f.get(object);
                    int min = f.getDeclaredAnnotation(Range.class).min();
                    int max = f.getDeclaredAnnotation(Range.class).max();

                    if(min >= range || max <= range){
                        errors.add(f.getAnnotation(Range.class).range());
                        result.setValid(false);
                    }
                }catch (IllegalAccessException e){
                    e.printStackTrace();
                }
            }


            //Regex
            if (f.isAnnotationPresent(Regex.class)){
                try{
                    if(!f.get(object).toString().matches(f.getDeclaredAnnotation(Regex.class).pattern())){
                        errors.add(f.getAnnotation(Regex.class).message());
                        result.setValid(false);
                    }
                }catch (IllegalAccessException e){
                    e.printStackTrace();
                }
            }

            //isEmpty
            if(!errors.isEmpty()){
                result.getNotValidFields().put(f.getName(),
                        new ArrayList<>(errors));
                errors.clear();
            }


        }



        return result;
>>>>>>> Stashed changes
    }
}
