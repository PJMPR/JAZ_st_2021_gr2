package org.example.Handlers;

import org.example.Actions.ExceptionActions;
import org.example.Logger.Logger;
import org.example.Supplier.Supplier;

public interface ExceptionHandler {
    ExceptionActions actions = new ExceptionActions();
    Logger logger = new Logger();

    String getMessage();

    boolean canHandle(Exception exc);

    void handle(Supplier method, Exception exc);

}
