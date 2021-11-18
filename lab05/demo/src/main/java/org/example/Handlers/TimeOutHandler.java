package org.example.Handlers;

import org.example.Supplier.Supplier;

import java.util.concurrent.TimeoutException;

public class TimeOutHandler implements ExceptionHandler{
    @Override
    public String getMessage() {
        return "Connection timed out. Check your internet connection.";
    }

    @Override
    public void handle(Supplier method, Exception exc) {
        if (canHandle(exc)) {
            System.out.println("Connection timed out. Trying to reconnect...");
            actions.wait(3);
            if (actions.repeat(method,4)) {
                return;
            }
            System.out.println(getMessage());
            logger.log(getMessage());
        }
    }

    @Override
    public boolean canHandle(Exception err) {
        return err instanceof TimeoutException;
    }
}
