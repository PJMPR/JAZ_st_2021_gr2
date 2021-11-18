package org.example.handlers;

import org.example.Provider;
import org.example.Actions;
import org.example.Logger;

public interface ErrorHandler {
    Actions actions = new Actions();
    Logger logger = new Logger();
    String getMessage();
    void handle(Exception err, Provider method);
    boolean canHandle(Exception err);

}