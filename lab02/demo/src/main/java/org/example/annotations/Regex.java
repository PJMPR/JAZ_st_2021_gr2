package org.example.annotations;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
public @interface Regex {
    String pattern() default "^\\w+@[a-zA-Z_]+?\\.[a-zA-Z]{2,3}$";
    String message() default "regex error";
}
