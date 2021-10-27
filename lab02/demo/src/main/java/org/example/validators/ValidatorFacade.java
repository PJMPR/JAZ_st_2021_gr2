package org.example.validators;

import org.example.annotations.NotNull;
import org.example.annotations.Range;
import org.example.annotations.Regex;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class ValidatorFacade {
    Field field;
    public ValidatorFacade(Field f)
    {
        field = f;
    }

    public boolean isValidNotNull()
    {
        return (field.isAnnotationPresent(NotNull.class) && field != null);
    }

    public boolean isValidRegex(Object obj)
    {
        try {
            return field.get(obj).toString().matches(field.getAnnotation(Regex.class).pattern());
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
        return false;
    }

    public boolean hasRegex()
    {
        return field.isAnnotationPresent(Regex.class);
    }

    public boolean isValidRange(Object object)
    {
        if (field.isAnnotationPresent(Range.class))
        {
            int min = field.getAnnotation(Range.class).min();
            int max = field.getAnnotation(Range.class).max();
            try {
                int value = (Integer)field.get(object);
                if (value >= min && value <= max)
                {
                    return true;
                }
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
        }
        return false;
    }

}
