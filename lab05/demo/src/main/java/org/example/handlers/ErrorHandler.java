package org.example.handlers;

import org.example.functions.Waiting;
import org.example.supplier.BasicSupplier;
import org.example.loggers.Logger;

public interface ErrorHandler {

    Logger logger = new Logger();
    Waiting waiting = new Waiting();
    String getMessage();
    boolean canHandle(Exception error);
    void handle(Exception error, BasicSupplier method);

}
