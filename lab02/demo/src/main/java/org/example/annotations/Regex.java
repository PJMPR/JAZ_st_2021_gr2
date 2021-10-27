package org.example.annotations;

public @interface Regex {
    String pattern() default "^\\w+@[a-zA-Z_]+?\\.[a-zA-Z]{2,3}$";

    String message() default "regex error";
}
