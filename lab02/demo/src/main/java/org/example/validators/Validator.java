package org.example.validators;

import java.util.ArrayList;
import java.util.List;

public class Validator {

    public <TClass> ValidationResult validate(TClass object) {
        ValidationResult result = new ValidationResult();
        List<String> errors = new ArrayList<>();
        result.setValidatedObject(object);


        
        return null;
    }
}
