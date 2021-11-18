package org.example.handlers;

import org.example.Provider;

import java.util.concurrent.TimeoutException;

public class Timeout implements ErrorHandler {

    @Override
    public String getMessage() {
        return "Connection timeout";
    }

    @Override
    public void handle(Exception err, Provider method) {
        if (canHandle(err)) {
            System.out.println("Connection timeout...reconnecting");
            actions.wait(3);
            if (actions.redo(method,5)) {
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
