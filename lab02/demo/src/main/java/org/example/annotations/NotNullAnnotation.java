package org.example.annotations;


import java.lang.annotation.ElementType;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
public @interface NotNull {
    String message()default "NULL";
    String message2()default "EMPTY";
}