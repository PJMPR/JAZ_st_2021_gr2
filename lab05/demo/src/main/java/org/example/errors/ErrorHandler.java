package org.example.errors;

import org.example.Supplier;

public interface ErrorHandler {
    String getMessage();

    boolean canHandle(Exception exception);

    boolean handle(Exception exception, Supplier method);

    void log();
}
