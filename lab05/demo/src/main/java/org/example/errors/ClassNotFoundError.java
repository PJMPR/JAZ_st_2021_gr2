package org.example.errors;

import org.apache.log4j.Logger;
import org.example.Supplier;

public class ClassNotFoundError implements ErrorHandler {
    private final Logger logger = Logger.getLogger(ClassNotFoundError.class.getName());

    @Override
    public String getMessage() {
        return "Class was not found";
    }

    @Override
    public boolean canHandle(Exception exception) {
        return exception instanceof ClassNotFoundException;
    }

    @Override
    public boolean handle(Exception exception, Supplier method) {
        if (canHandle(exception)) {
            System.out.println(getMessage());
            log();
            return true;
        }
        return false;
    }

    @Override
    public void log() {
        logger.error(getMessage());
    }
}
