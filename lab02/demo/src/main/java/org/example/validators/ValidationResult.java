package org.example.validators;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ValidationResult{

    private Object validatedObject;
    private boolean isValid;
    private Map<String, List<String>> notValidFields = new HashMap<String, List<String>>();

    public Object getValidatedObject() {
        return validatedObject;
    }

    public void setValidatedObject(Object validatedObject) {
        this.validatedObject = validatedObject;
    }

    public boolean isValid() {
        return isValid;
    }

    public void setValid(boolean valid) {
        isValid = valid;
    }

    public Map<String, List<String>> getNotValidFields() {
        return notValidFields;
    }

    public ValidationResult() {

    }
    public ValidationResult(Map<String, List<String>> notValidFields, Object validatedObject, boolean isValid) {
        this.notValidFields = notValidFields;
        this.validatedObject = validatedObject;
        this.isValid = isValid;
    }

}
